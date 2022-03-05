package org.oakbricks.launcherapi.auth;

public interface BasicAuth {
    boolean allowsPiracy = false;

    void login(String username, String password);

    void verifyUser(String uid);
}
