package org.oakbricks.launcher.core.json;

import org.oakbricks.launcher.Main;
import org.oakbricks.launcher.gui.MainFrame;

public class LauncherConfigJson {
    private int winX;
    private int winY;
    private Themes launcherTheme;
    private String preferredAccount;

    public LauncherConfigJson() {
        winX = 0;
        winY = 0;
        launcherTheme = Themes.DEFAULT;
    }

    public LauncherConfigJson(int winX, int winY, Themes launcherTheme, String preferredAccount) {
        this.winX = winX;
        this.winY = winY;
        this.launcherTheme = launcherTheme;
        this.preferredAccount = preferredAccount;
    }

    public LauncherConfigJson(int winX, int winY, Themes launcherTheme) {
        this.winX = winX;
        this.winY = winY;
        this.launcherTheme = launcherTheme;
    }

    public enum Themes {
        DEFAULT,
        DARK,
        LIGHT,
        CUSTOM
    }

    public String getPreferredAccount() {
        return preferredAccount;
    }

    public int getWinX() {
        return winX;
    }

    public int getWinY() {
        return winY;
    }

    public Themes getLauncherTheme() {
        return launcherTheme;
    }

    public void setPreferredAccount(String preferredAccount) {
        this.preferredAccount = preferredAccount;
    }

    public void setLauncherTheme(Themes launcherTheme) {
        this.launcherTheme = launcherTheme;
    }

    public void setWinX(int winX) {
        this.winX = winX;
    }

    public void setWinY(int winY) {
        this.winY = winY;
    }

    /**
     * @since 0.1@1/12/2022
     * There is a better way i could do this
     */
    public static LauncherConfigJson flushConfig() {
        LauncherConfigJson lCJ = new LauncherConfigJson();
        LauncherConfigJson configToBeFlushed;

        if (Main.config.getPreferredAccount() == null) {
            configToBeFlushed = new LauncherConfigJson(MainFrame.WINDOW_X, MainFrame.WINDOW_Y, lCJ.getLauncherTheme());
        } else if (Main.config.getPreferredAccount() != null) {
            configToBeFlushed = new LauncherConfigJson(MainFrame.WINDOW_X, MainFrame.WINDOW_Y, lCJ.getLauncherTheme(), lCJ.getPreferredAccount());
        } else {
            configToBeFlushed = new LauncherConfigJson();
        }

        return configToBeFlushed;
    }
}
