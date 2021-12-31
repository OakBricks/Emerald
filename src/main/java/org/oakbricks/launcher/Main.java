package org.oakbricks.launcher;

import org.apache.commons.cli.*;
import org.oakbricks.launcher.gui.GuiMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static boolean IS_DEBUGGING = false;
    public static final Logger LOGGER = LoggerFactory.getLogger("Launcher");

    public static void main(String[] args) throws ParseException {
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
    }
}
