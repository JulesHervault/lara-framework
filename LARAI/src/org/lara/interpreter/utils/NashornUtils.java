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

package org.lara.interpreter.utils;

import java.util.Collection;

import com.google.common.base.Preconditions;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import jdk.nashorn.api.scripting.ScriptUtils;

/**
 * @deprecated this should be moved to JsEngine project
 * @author JoaoBispo
 *
 */
@Deprecated
public class NashornUtils {

    public static boolean isUndefined(Object object) {
        // SpecsLogs.msgWarn("SCRIPTOBJECTMIRROR");
        return ScriptObjectMirror.isUndefined(object);
    }

    // public static boolean isJSArray(Object object) {
    // // SpecsLogs.msgWarn("SCRIPTOBJECTMIRROR");
    // return object instanceof ScriptObjectMirror
    // && ((ScriptObjectMirror) object).isArray();
    // }

    public static Collection<Object> getValues(Object object) {
        // SpecsLogs.msgWarn("SCRIPTOBJECTMIRROR");
        Preconditions.checkArgument(object instanceof ScriptObjectMirror, "Expected object of class '"
                + ScriptObjectMirror.class.getSimpleName() + "', got " + object.getClass());

        return ((ScriptObjectMirror) object).values();
    }

    public static <T> T convert(Object object, Class<T> toConvert) {
        // SpecsLogs.msgWarn("SCRIPTOBJECTMIRROR");
        return toConvert.cast(ScriptUtils.convert(object, toConvert));
    }

}
