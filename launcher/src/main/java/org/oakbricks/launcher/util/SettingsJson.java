package org.oakbricks.launcher.util;

import java.nio.file.Path;

public class SettingsJson {
    public SettingsJson(int schemaVersion, String styleSheetFile) {
        this.schemaVersion = schemaVersion;
        this.styleSheet = styleSheetFile;
    }

    public SettingsJson(int schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public int schemaVersion;
    public String styleSheet;

    public int getSchemaVersion() {
        return schemaVersion;
    }

    public String getStyleSheet() {
        return styleSheet;
    }
}
