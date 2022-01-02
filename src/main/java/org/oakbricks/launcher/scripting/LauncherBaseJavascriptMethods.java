package org.oakbricks.launcher.scripting;

import org.oakbricks.launcher.Main;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LauncherBaseJavascriptMethods {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");
    public LauncherBaseJavascriptMethods() {
        engine.put("logger", Main.LOGGER);
        engine.put("DEBUGGING", Main.IS_DEBUGGING);
    }

    public void runJSCode(String code) throws Exception {
        engine.eval(code);
    }

    public void runJSCodeFromFile(String fileName) throws FileNotFoundException, ScriptException {
        engine.eval(new FileReader(fileName));
    }
}
