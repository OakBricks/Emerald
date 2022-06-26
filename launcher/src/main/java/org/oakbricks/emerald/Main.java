package org.oakbricks.emerald;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qt.widgets.QApplication;
import org.apache.commons.io.FileUtils;
import org.oakbricks.emerald.util.settings.SettingsJson;
import org.oakbricks.emerald.util.settings.SettingsUtil;
import org.tinylog.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) throws IOException {
        if (!SettingsUtil.getSettingsConfigFile().exists()) {
            Logger.info("Creating config file");
            SettingsUtil.getSettingsConfigFile().createNewFile();
            FileUtils.writeStringToFile(SettingsUtil.getSettingsConfigFile(), GSON.toJson(new SettingsJson(0)), StandardCharsets.UTF_8);
        } else {
            Logger.debug("Config found, loading as normal.");
        }
        QApplication.initialize(args);

        MainWindow mainWindow = new MainWindow();
        mainWindow.show();

        QApplication.exec();
    }
}
