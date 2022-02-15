package org.oakbricks.launcher.util;

import com.google.gson.Gson;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SettingsUtil {
    public static File settingsConfigFile = new File("settings.json");
    public static SettingsJson settings = new SettingsJson(1);

    static {
        try {
            settings = new Gson().fromJson(FileUtils.readFileToString(settingsConfigFile, StandardCharsets.UTF_8), SettingsJson.class);
        } catch (IOException e) {
            e.printStackTrace();
            settings = new SettingsJson(1);
        }
    }

    public SettingsUtil() {
    }

    public static File getSettingsConfigFile() {
        return settingsConfigFile;
    }
    public static String getStyleSheetFromConfig() throws IOException {
        String out;
        if (!settingsConfigFile.exists()) {
            out = "";
        } else {
            out = FileUtils.readFileToString(settings.getStyleSheet().toFile(), StandardCharsets.UTF_8);
        }
        return out;
    }
}
