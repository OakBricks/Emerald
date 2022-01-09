package org.oakbricks.launcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.oakbricks.launcher.core.json.LauncherConfigJson;
import org.oakbricks.launcher.gui.GuiMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    public static boolean IS_DEBUGGING = false;
    public static final Logger LOGGER = LoggerFactory.getLogger("Launcher");
    public static final File configFile = new File("launcher.json");
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static LauncherConfigJson config;
    static {
        try {
            config = gson.fromJson(FileUtils.readFileToString(configFile, StandardCharsets.UTF_8), LauncherConfigJson.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException, IOException {
        GuiMain guiThreadObj = new GuiMain();
        Thread guiThread = new Thread(guiThreadObj);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            config.setWinX(new GuiMain().getLocationOnScreen().x);
            config.setWinY(new GuiMain().getLocationOnScreen().y);
        }));
        LOGGER.info("Launcher Starting!");

        if (!configFile.exists()) {
            LOGGER.debug("Launcher config does not exist");
            configFile.createNewFile();
            FileUtils.writeStringToFile(configFile, gson.toJson(new LauncherConfigJson(0, 0, LauncherConfigJson.Themes.DEFAULT)), StandardCharsets.UTF_8);
        }

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
    }
}
