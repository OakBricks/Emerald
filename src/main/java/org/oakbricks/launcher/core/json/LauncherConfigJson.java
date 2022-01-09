package org.oakbricks.launcher.core.json;

public class LauncherConfigJson {
    private int winX;
    private int winY;
    private String windowIconPath;
    private Themes launcherTheme;
    private String lastUsedAccount;

    public LauncherConfigJson(int winX, int winY, String windowIconPath, Themes launcherTheme, String lastUsedAccount) {
        this.winX = winX;
        this.winY = winY;
        this.windowIconPath = windowIconPath;
        this.launcherTheme = launcherTheme;
        this.lastUsedAccount = lastUsedAccount;
    }

    public LauncherConfigJson(int winX, int winY, Themes launcherTheme, String lastUsedAccount) {
        this.winX = winX;
        this.winY = winY;
        this.windowIconPath = "";
        this.launcherTheme = launcherTheme;
        this.lastUsedAccount = lastUsedAccount;
    }

    public LauncherConfigJson(int winX, int winY, Themes launcherTheme) {
        this.winX = winX;
        this.winY = winY;
        this.windowIconPath = "";
        this.launcherTheme = launcherTheme;
        this.lastUsedAccount = lastUsedAccount;
    }

    public enum Themes {
        DEFAULT,
        DARK,
        LIGHT,
        CUSTOM
    }

    public String getLastUsedAccount() {
        return lastUsedAccount;
    }

    public int getWinX() {
        return winX;
    }

    public int getWinY() {
        return winY;
    }

    public String getWindowIconPath() {
        return windowIconPath;
    }

    public Themes getLauncherTheme() {
        return launcherTheme;
    }

    public void setLastUsedAccount(String lastUsedAccount) {
        this.lastUsedAccount = lastUsedAccount;
    }

    public void setLauncherTheme(Themes launcherTheme) {
        this.launcherTheme = launcherTheme;
    }

    public void setWindowIconPath(String windowIconPath) {
        this.windowIconPath = windowIconPath;
    }

    public void setWinX(int winX) {
        this.winX = winX;
    }

    public void setWinY(int winY) {
        this.winY = winY;
    }
}
