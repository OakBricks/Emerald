package org.oakbricks.launcher.core.json;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class LauncherConfigTemplate {
    @Getter
    @Setter
    int[] winPos;
    @Getter
    @Setter
    String windowIconPath;
    @Getter
    @Setter
    String uniqueLauncherUUID;
    @Getter
    @Setter
    String launcherTheme;
    @Getter
    @Setter
    String lastUsedAccount;

    @Override
    public String toString() {
        return "LauncherConfig(windowPosition: "+winPos+" windowIconPath: "+windowIconPath+" uniqueLauncherUUID: "+uniqueLauncherUUID+" launcherTheme: "+launcherTheme+" lastUsedAccount: "+lastUsedAccount+")";
    }
}
