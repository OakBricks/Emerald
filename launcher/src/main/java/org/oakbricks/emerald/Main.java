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
//    public static int microsoftAccountAuthPort = generatePortNumberForRedirect();
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

    // holy shit i didn't even know that java literally uses port 0 to automatically allocate a port for you i should really look shit up on google, but im keeping this code just in case
//    public static int generatePortNumberForRedirect() {
//        int result = 1;
//
//        Random r = new Random();
//        int port = r.nextInt(65536);
//
//        if (!isTcpPortAvailable(port)) {
//            generatePortNumberForRedirect();
//        } else {
//            result = port;
//        }
//
//        return result;
//    }
//
//    // https://stackoverflow.com/a/48828373
//    public static boolean isTcpPortAvailable(int port) {
//        try (ServerSocket serverSocket = new ServerSocket()) {
//            // setReuseAddress(false) is required only on macOS,
//            // otherwise the code will not work correctly on that platform
//            serverSocket.setReuseAddress(false);
//            serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port), 1);
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }
//    }
}
