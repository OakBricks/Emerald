package org.oakbricks.launcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.oakbricks.launcher.core.json.LauncherConfigJson;
import org.oakbricks.launcher.gui.FirstLaunchFrame;
import org.oakbricks.launcher.gui.MainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static boolean IS_DEBUGGING = false;
    public static final Logger LOGGER = LoggerFactory.getLogger("Launcher");
    public static final File configFile = new File("launcher.json");
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static LauncherConfigJson config = new LauncherConfigJson(0, 0, "light");

    public static void main(String[] args) throws ParseException, IOException, UnsupportedLookAndFeelException {

        LOGGER.info("Launcher Starting!");

        //LauncherConfigJson config = null;
        //try {
        //    config = gson.fromJson(FileUtils.readFileToString(configFile, StandardCharsets.UTF_8), LauncherConfigJson.class);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        //LauncherConfigJson finalConfig = config;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

        }));

        // This is just its own mess
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("EnableLauncherDebugging", false, "Enable debugging features");
        CommandLineParser cmdLineParser = new DefaultParser();
        CommandLine commandLine = cmdLineParser.parse(cmdLineOptions, args);
        if (commandLine.hasOption("EnableLauncherDebugging")) {
            IS_DEBUGGING = true;
            LOGGER.debug("DEBUGGING ENABLED");
        }
        try {
            config = gson.fromJson(FileUtils.readFileToString(configFile, StandardCharsets.UTF_8), LauncherConfigJson.class);
        } catch (IOException e) {
            config = new LauncherConfigJson(0, 0, "light");
        }
        if (!configFile.exists()) {
//            LOGGER.debug("Launcher config does not exist, creating!");
//            configFile.createNewFile();
//            FileUtils.writeStringToFile(configFile, gson.toJson(new LauncherConfigJson(0, 0, "default")), StandardCharsets.UTF_8);
            new FirstLaunchFrame();
        } else {
            new MainFrame();
        }
    }
}
