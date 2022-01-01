package org.oakbricks.launcher;

import com.github.weisj.darklaf.LafManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.cli.*;
import org.oakbricks.launcher.core.json.InstanceJsonTemplate;
import org.oakbricks.launcher.gui.GuiMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Main {
    public static boolean IS_DEBUGGING = false;
    public static final Logger LOGGER = LoggerFactory.getLogger("Launcher");

    public static void main(String[] args) throws ParseException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LafManager.install();
        LafManager.installTheme(LafManager.getPreferredThemeStyle());
        GuiMain guiThreadObj = new GuiMain();
        Thread guiThread = new Thread(guiThreadObj);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutting down launcher!")));
        LOGGER.info("Launcher Starting!");

        // This is just its own mess
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("EnableLauncherDebugging", false, "Enable debugging features");
        CommandLineParser cmdLineParser = new DefaultParser();
        CommandLine commandLine = cmdLineParser.parse(cmdLineOptions, args);
        if (commandLine.hasOption("EnableLauncherDebugging")) {
            IS_DEBUGGING = true;
            LOGGER.debug("DEBUGGING ENABLED");
        }
        guiThread.start();
        LOGGER.debug("\n"+gson.toJson(new InstanceJsonTemplate(UUID.randomUUID(), "Testing Instance", InstanceJsonTemplate.ActionTypes.NONE, "", InstanceJsonTemplate.ActionTypes.LUA, "")));
    }
}
