package org.oakbricks.launcher.core.json;


import com.github.weisj.darklaf.theme.Theme;

public class LauncherConfigJson {
    public static class LauncherConfig {
        public LauncherConfig(int[] winPos, String windowIconPath, Themes launcherTheme, String lastUsedAccount) {
            this.winPos = winPos;
            this.windowIconPath = windowIconPath;
            this.launcherTheme = launcherTheme;
            this.lastUsedAccount = lastUsedAccount;
        }
        int[] winPos;
        String windowIconPath;
        Themes launcherTheme;
        String lastUsedAccount;
    }

    public enum Themes {
        DEFAULT,
        DARK,
        LIGHT,
        CUSTOM
    }

}
