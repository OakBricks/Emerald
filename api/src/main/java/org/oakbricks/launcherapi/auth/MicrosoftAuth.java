package org.oakbricks.launcherapi.auth;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MicrosoftAuth {
    HttpServer httpServer = HttpServer.create();
    public static Logger LOGGER = Logger.getLogger("OakLauncher MSAuth API");
    private String apiKey;

    public MicrosoftAuth(String apiKey) throws IOException {
        this.apiKey = apiKey;
    }

    public void login(String username, String password)  {
        LOGGER.log(Level.INFO, "Not implemented yet");
    }

    public void verifyUser(String uid) {
        LOGGER.log(Level.INFO, "Not implemented yet");
    }

    public void updateToken() {}
}
