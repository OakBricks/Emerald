package org.oakbricks.launcher.scripting;

import creativeintor.game.GameFrame;
import org.apache.commons.cli.ParseException;
import org.oakbricks.launcher.Main;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LauncherBaseJavascriptMethods {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");
    GameFrame getTheApple = new GameFrame();
    public LauncherBaseJavascriptMethods() {
        engine.put("logger", Main.LOGGER);
        engine.put("DEBUGGING", Main.IS_DEBUGGING);
        engine.put("genZLiberalTelephone5GCovidGoodQuaratineApplePhoneIPhoneWindowsBillGatesAndMore", getTheApple);
    }

    public void runJSCode(String code) throws Exception {
        engine.eval(code);
    }

    public void runJSCodeFromFile(String fileName) throws FileNotFoundException, ScriptException {
        engine.eval(new FileReader(fileName));
    }
}
