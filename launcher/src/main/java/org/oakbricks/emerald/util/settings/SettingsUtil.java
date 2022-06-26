package org.oakbricks.emerald.util.settings;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.tinylog.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SettingsUtil {
    private static final int currentConfigVersion = 0;
    public static File settingsConfigFile = new File("settings.json");
    public static SettingsJson settings;

    static {
        try {
            settings = new Gson().fromJson(FileUtils.readFileToString(settingsConfigFile, StandardCharsets.UTF_8), SettingsJson.class);
        } catch (IOException e) {
            settings = new SettingsJson(0);
        }
    }

    public SettingsUtil() {

    }

    public static String[] getJavaEnvironmentInfo() {
        String version = System.getProperty("java.version");
        String vendor = System.getProperty("java.vendor");

        return new String[]{version, vendor};
    }

    public static File getSettingsConfigFile() {
        return settingsConfigFile;
    }

    public static String getStyleSheetFromConfig() {
        String out;
        if (!settingsConfigFile.exists() || settings.getStyleSheet().equals("") || settings.getStyleSheet() == null) {
            out = "";
        } else {
            out = settings.getStyleSheet();
        }
        return out;
    }

    public static void validateConfig() {
        SettingsJson config = settings;
        if (config.settingsVersion != currentConfigVersion) {
            Logger.warn("Config file is outdated (TODO: FIX CONFIG FILE IF ITS OUTDATED)");
        }
    }

    public static void setSettings(SettingsJson settings) {
        SettingsUtil.settings = settings;
    }
}
