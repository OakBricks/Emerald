package org.oakbricks.launcher.core.json;


public class LauncherConfigJson {
    private class LauncherConfig {
        public LauncherConfig(int[] winPos, String windowIconPath, String launcherTheme, String lastUsedAccount) {
            this.winPos = winPos;
            this.windowIconPath = windowIconPath;
            this.launcherTheme = launcherTheme;
            this.lastUsedAccount = lastUsedAccount;
        }
        int[] winPos;
        String windowIconPath;
        String launcherTheme;
        String lastUsedAccount;
    }

}
