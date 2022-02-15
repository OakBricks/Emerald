package org.oakbricks.launcher.util;

import java.nio.file.Path;

public class SettingsJson {
    public SettingsJson(int schemaVersion, Path styleSheetFile) {
        this.schemaVersion = schemaVersion;
        this.styleSheet = styleSheetFile;
    }

    public SettingsJson(int schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public int schemaVersion;
    public Path styleSheet;

    public int getSchemaVersion() {
        return schemaVersion;
    }

    public Path getStyleSheet() {
        return styleSheet;
    }
}
