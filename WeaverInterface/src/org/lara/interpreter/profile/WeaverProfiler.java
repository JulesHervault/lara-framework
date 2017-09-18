/**
 * Copyright 2017 SPeCS.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. under the License.
 */

package org.lara.interpreter.profile;

import org.lara.interpreter.exception.LaraIException;
import org.lara.interpreter.weaver.interf.AGear;
import org.lara.interpreter.weaver.interf.events.Stage;
import org.lara.interpreter.weaver.interf.events.data.ActionEvent;
import org.lara.interpreter.weaver.interf.events.data.ApplyEvent;
import org.lara.interpreter.weaver.interf.events.data.ApplyIterationEvent;
import org.lara.interpreter.weaver.interf.events.data.AspectEvent;
import org.lara.interpreter.weaver.interf.events.data.AttributeEvent;
import org.lara.interpreter.weaver.interf.events.data.JoinPointEvent;
import org.lara.interpreter.weaver.interf.events.data.SelectEvent;
import org.lara.interpreter.weaver.interf.events.data.WeaverEvent;

/**
 * Abstract profiler providing basic metrics:<br>
 * <ul>
 * <li>Number of
 * <ul>
 * <li>aspects called
 * <li>selects
 * <li>apply iterations
 * <li>attributes accessed
 * <li>actions performed (includes insert action)
 * <li>inserts performed
 * <li>native LOC injected by insert action
 * <li>LOC inserted by any means
 * <li>tools executed
 * </ul>
 * <li>Map containing
 * <ul>
 * <li>Number of times each aspect was called
 * <li>Number of times an action was performed
 * </ul>
 * </ul>
 * 
 * @author tiago
 *
 */
public abstract class WeaverProfiler extends AGear {

    private WeavingReport report = new WeavingReport();

    //////////////////////////////////////////////////////////
    // Methods to be defined by the weaver engine developer //
    //////////////////////////////////////////////////////////
    /**
     * Create a report by means of a {@link ReportWriter}. When invoked, the {@link ReportWriter} instance already
     * contains some metrics (see {@link WeaverProfiler})
     * 
     * @param data
     */
    protected abstract void buildReport(ReportWriter writer);

    /**
     * Triggers before and after the weaver is executed
     * 
     * @param data
     */
    protected abstract void onWeaverImpl(WeaverEvent data);

    /**
     * Triggers at the beginning and end of an aspect call
     * 
     * @param data
     */
    protected abstract void onAspectImpl(AspectEvent data);

    /**
     * Triggers before and after a select is executed
     * 
     * @param data
     */
    protected abstract void onSelectImpl(SelectEvent data);

    /**
     * Triggers when a join point is created
     * 
     * @param data
     */
    protected abstract void onJoinPointImpl(JoinPointEvent data);

    /**
     * Triggers before the apply statement starts and after it executes
     * 
     * @param data
     */
    protected abstract void onApplyImpl(ApplyEvent data);

    /**
     * Triggers every time an apply iteration is at the beginning or at the end
     * 
     * @param data
     */
    protected abstract void onApplyImpl(ApplyIterationEvent data);

    protected abstract void onAttributeImpl(AttributeEvent data);

    protected abstract void onActionImpl(ActionEvent data);

    @Override
    public final void onWeaver(WeaverEvent data) {
        onWeaverImpl(data);
    }

    @Override
    public final void onAspect(AspectEvent data) {
        onAspectImpl(data);
        if (data.getStage().equals(Stage.BEGIN)) {
            report.aspectCalled(data.getAspectCallee());
        }
    }

    @Override
    public final void onSelect(SelectEvent data) {
        onSelectImpl(data);
        if (data.getStage().equals(Stage.BEGIN)) {
            report.incSelects();
        }
    }

    @Override
    public final void onJoinPoint(JoinPointEvent data) {
        onJoinPointImpl(data);
    }

    @Override
    public final void onApply(ApplyEvent data) {
        onApplyImpl(data);
    }

    @Override
    public final void onApply(ApplyIterationEvent data) {
        onApplyImpl(data);
        if (data.getStage().equals(Stage.BEGIN)) {
            report.incApplies();
        }
    }

    @Override
    public final void onAttribute(AttributeEvent data) {
        onAttributeImpl(data);
        if (data.getStage().equals(Stage.END)) {
            report.incAttributes();
        }
    }

    @Override
    public final void onAction(ActionEvent data) {
        onActionImpl(data);
        if (data.getStage().equals(Stage.END)) {
            report.actionPerformed(data.getActionName());
            // System.out.println("[DEBUG] ACTION " + data.getActionName());
            if (data.getActionName().equals("insert")) {
                // System.out.println("[DEBUG] INSERT" + report.getInserts());
                report.incInserts();
            }
        }
    }

    @Override
    public final void reset() {
        report.reset();
    }

    /**
     * Increment the LOCs that were injected in the code
     * 
     * @param locs
     *            the lines of code that were injected
     * @param insertAction
     *            was the code injected by means of insertAction?
     */
    public final void reportLOCs(int locs, boolean insertAction) {

        if (insertAction) {
            report.incNativeLOCs(locs);
        } else {
            report.incTotalLOCs(locs);
        }
    }

    /**
     * Returns a report in JSON format
     * 
     * @return
     */
    public String buildJsonReport() {

        try (JsonReportWriter jsonWriter = new JsonReportWriter();) {
            jsonWriter.beginObject()
                    .report("aspects", report.getNumAspectCalls())
                    .report("selects", report.getSelects())
                    .report("applies", report.getApplies())
                    .report("actions", report.getNumActions())
                    .report("inserts", report.getInserts())
                    .report("attributes", report.getAttributes())
                    .report("insertNativeLOCs", report.getNativeLOCs())
                    .report("totalNativeLOCs", report.getTotalLOCs())
                    .report("runs", report.getRuns())
                    .report("aspectsCalled", report.getAspectsMap())
                    .report("actionsPerformed", report.getActionsMap());

            buildReport(jsonWriter);
            jsonWriter.endObject();
            return jsonWriter.toString();
        } catch (Exception e) {
            throw new LaraIException("Problems creating the report", e);
        }
    }

}
