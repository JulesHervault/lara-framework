/**
 * Copyright 2016 SPeCS.
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

package org.lara.interpreter.joptions.config.interpreter;

import java.io.File;
import java.util.Collections;

import javax.swing.JFileChooser;

import org.lara.interpreter.joptions.keys.FileList;
import org.lara.interpreter.joptions.keys.OptionalFile;
import org.suikasoft.jOptions.Datakey.DataKey;
import org.suikasoft.jOptions.Datakey.KeyFactory;
import org.suikasoft.jOptions.storedefinition.StoreDefinition;
import org.suikasoft.jOptions.storedefinition.StoreDefinitionBuilder;

import pt.up.fe.specs.util.utilities.StringList;

public interface LaraiKeys {

    DataKey<File> LARA_FILE = KeyFactory.file("aspect", "lara", "js").setLabel("Aspect");

    DataKey<String> MAIN_ASPECT = KeyFactory.string("main").setLabel("Main Aspect");

    DataKey<String> ASPECT_ARGS = KeyFactory.string("argv").setLabel("Aspect Arguments");

    // DataKey<DataStore> WEAVER_ARGS = KeyFactory.dataStore("argw", new StoreDefinitionBuilder("Weaver Options"))
    // .setLabel("Weaver Options");

    // DataKey<File> WORKSPACE_FOLDER = KeyFactory.folder("workspace", false).setLabel("Source Folder");
    // DataKey<FileList> WORKSPACE_FOLDER = LaraIKeyFactory.folderList("workspace").setLabel(
    DataKey<FileList> WORKSPACE_FOLDER = LaraIKeyFactory.fileList("workspace", JFileChooser.FILES_AND_DIRECTORIES,
            Collections.emptyList())
            .setLabel("Sources");

    DataKey<File> OUTPUT_FOLDER = KeyFactory.folder("output", false).setLabel("Output Folder");

    DataKey<FileList> INCLUDES_FOLDER = LaraIKeyFactory.folderList("include")
            .setLabel("Includes Folder (LARA, JS scripts, JARs)");

    DataKey<StringList> EXTERNAL_DEPENDENCIES = KeyFactory.stringList("external_dependencies")
            .setLabel("External dependencies (URLs, git repos)");

    DataKey<OptionalFile> TOOLS_FILE = LaraIKeyFactory.optionalFile("tools", true, "xml").setLabel("Tools File");

    DataKey<OptionalFile> REPORT_FILE = LaraIKeyFactory.optionalFile("report", false, "js").setLabel("Report File");

    DataKey<OptionalFile> METRICS_FILE = LaraIKeyFactory.optionalFile("metrics", false, "js").setLabel("Metrics File");

    DataKey<VerboseLevel> VERBOSE = KeyFactory.enumeration("verbose", VerboseLevel.class).setLabel("Verbose Level")
            .setDefault(() -> VerboseLevel.all);

    DataKey<OptionalFile> LOG_FILE = LaraIKeyFactory.optionalFile("log", false).setLabel("Use Log File");

    DataKey<Boolean> LOG_JS_OUTPUT = KeyFactory.bool("javascript").setLabel("Log JavaScript Output");
    DataKey<Boolean> DEBUG_MODE = KeyFactory.bool("debug").setLabel("Debug Mode");

    DataKey<Boolean> TRACE_MODE = KeyFactory.bool("stack trace").setLabel("Call Stack Trace (BETA)");

    // TODO: Use List<String> instead
    DataKey<String> BUNDLE_TAGS = KeyFactory.string("bundle_tags").setLabel("Bundle tags");

    DataKey<Boolean> RESTRICT_MODE = KeyFactory.bool("restrict mode")
            .setLabel("Restric mode (some Java classes are not allowed)");

    // DataKey<WeaverEngine> WEAVER_INSTANCE = KeyFactory.object("weaver instance", WeaverEngine.class);

    StoreDefinition STORE_DEFINITION = new StoreDefinitionBuilder("LaraI Options")
            .addKeys(LARA_FILE, MAIN_ASPECT, ASPECT_ARGS, WORKSPACE_FOLDER, OUTPUT_FOLDER, INCLUDES_FOLDER,
                    EXTERNAL_DEPENDENCIES, TOOLS_FILE, REPORT_FILE, METRICS_FILE, VERBOSE, LOG_FILE, LOG_JS_OUTPUT,
                    DEBUG_MODE, TRACE_MODE, BUNDLE_TAGS, RESTRICT_MODE)
            .build();

    /**
     * Backup code
     */
    // DataKey<VerboseLevel> VERBOSE = LaraiKeyFactory.radioEnum("b", VerboseLevel.class)

    // DataKey<OptionalFile> INCLUDES_FOLDER = LaraiKeyFactory.optionalFolder("include")
    // // .setDefault(DEFAULT_DIR)
    // DataKey<Boolean> LOG_FILE = KeyFactory.bool("l").setLabel("Use log file");

    // .setLabel("Includes Folder");
    // DataKey<Boolean> SHOW_HELP = KeyFactory.bool("help").setLabel("Show Help");

    // DataKey<ClassProvider> WEAVER_CLASS = LaraiKeyFactory.classProvider("w")
    // .setDefault(ClassProvider.newInstance(DefaultWeaver.class))
    // .setLabel("Weaver Class");
    // DataKey<File> LANGUAGE_SPECIFICATION_FOLDER = KeyFactory.folder("x")
    // .setDefault(LaraiKeys.DEFAULT_DIR)
    // .setLabel("Language Specification");

    // DataKey<OptionsParser> CLI_PARSER = KeyFactory.object("cli_parser", OptionsParser.class);
}
