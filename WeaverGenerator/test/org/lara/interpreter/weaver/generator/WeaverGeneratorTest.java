/**
 * Copyright 2020 SPeCS.
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

package org.lara.interpreter.weaver.generator;

import static pt.up.fe.specs.lara.langspec.LanguageSpecificationTestResource.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.lara.language.specification.dsl.LanguageSpecificationV2;

import pt.up.fe.specs.lara.langspec.LangSpecsXmlParser;
import pt.up.fe.specs.util.SpecsSystem;

public class WeaverGeneratorTest {

    private static final LanguageSpecificationV2 LANG_SPEC = LangSpecsXmlParser.parse(JOIN_POINT_MODEL.toStream(),
            ATTRIBUTE_MODEL.toStream(),
            ACTION_MODEL.toStream());

    @BeforeClass
    public static void init() {
        SpecsSystem.programStandardInit();
    }

    @Test
    public void testJson() {

        // ResourceProvider parserTestExpected = () -> "pt/up/fe/specs/lara/langspec/test/ParserTestResult.txt";
        //
        // assertEquals(SpecsStrings.normalizeFileContents(parserTestExpected.read(), true),
        // SpecsStrings.normalizeFileContents(langSpec.toString(), true));
    }

}
