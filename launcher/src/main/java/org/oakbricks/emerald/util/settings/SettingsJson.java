package org.oakbricks.emerald.util.settings;

public class SettingsJson {
    public SettingsJson(int settingsVersion, String styleSheetFile, String launcherUID) {
        this.settingsVersion = settingsVersion;
        this.styleSheet = styleSheetFile;
        this.launcherUID = launcherUID;
    }

    public SettingsJson(int settingsVersion) {
        this.settingsVersion = settingsVersion;
    }

    public int settingsVersion;
    public String styleSheet;
    public String launcherUID;
    public String microsoftClientID;

    public int getSettingsJsonVersion() {
        return settingsVersion;
    }

    public String getStyleSheet() {
        return styleSheet;
    }
}
