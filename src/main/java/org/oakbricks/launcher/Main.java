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
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main {
    public static boolean IS_DEBUGGING = false;
    public static final Logger LOGGER = LoggerFactory.getLogger("Launcher");
    public static final File configFile = new File("launcher.json");

    public static void main(String[] args) throws ParseException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GuiMain guiThreadObj = new GuiMain();
        Thread guiThread = new Thread(guiThreadObj);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutting down launcher!")));
        LOGGER.info("Launcher Starting!");

        if (!configFile.exists()) {
            LOGGER.debug("Launcher config does not exist");
            configFile.createNewFile();
            FileUtils.writeStringToFile(configFile, gson.toJson(new LauncherConfigJson.LauncherConfig(new int[]{0, 0}, "", LauncherConfigJson.Themes.DEFAULT, Base64.getEncoder().encodeToString("None".getBytes(StandardCharsets.UTF_8)))), StandardCharsets.UTF_8);
        }

        // This is just its own mess
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("EnableLauncherDebugging", false, "Enable debugging features");
        CommandLineParser cmdLineParser = new DefaultParser();
        CommandLine commandLine = cmdLineParser.parse(cmdLineOptions, args);
        if (commandLine.hasOption("EnableLauncherDebugging")) {
            IS_DEBUGGING = true;
            LOGGER.debug("DEBUGGING ENABLED");
            //LOGGER.debug("\n"+gson.toJson(new InstanceJsonTemplate(UUID.randomUUID(), "Testing Instance", InstanceJsonTemplate.ActionTypes.NONE, "", InstanceJsonTemplate.ActionTypes.JAVASCRIPT, "")));
        }
        guiThread.start();
    }
}
