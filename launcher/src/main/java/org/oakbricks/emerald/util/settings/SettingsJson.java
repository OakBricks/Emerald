package org.oakbricks.emerald.util.settings;

public class SettingsJson {
    public SettingsJson(int settingsVersion, String launcherUID) {
        this.settingsVersion = settingsVersion;
        this.launcherUID = launcherUID;
    }

    public SettingsJson(int settingsVersion) {
        this.settingsVersion = settingsVersion;
    }

    public int settingsVersion;
    public String launcherUID;
    public String microsoftClientID;

    public int getSettingsJsonVersion() {
        return settingsVersion;
    }
}
