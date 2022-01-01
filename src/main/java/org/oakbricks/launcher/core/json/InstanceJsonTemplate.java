package org.oakbricks.launcher.core.json;

import com.google.gson.Gson;
import lombok.NonNull;

import java.util.UUID;

public class InstanceJsonTemplate {

    public InstanceJsonTemplate(@NonNull UUID uuid, @NonNull String name, @NonNull String launchActionType, @NonNull String launchAction, @NonNull String exitActionType, @NonNull String exitAction) {
        instanceUuid = uuid;
        instanceName = name;
        instanceLaunchActionType = launchActionType;
        instanceLaunchAction = launchAction;
        instanceExitActionType = exitActionType;
        instanceExitAction = exitAction;
    }
    @NonNull
    UUID instanceUuid;
    @NonNull
    String instanceName;
    @NonNull
    String instanceLaunchActionType;
    @NonNull
    String instanceLaunchAction;
    @NonNull
    String instanceExitActionType;
    @NonNull
    String instanceExitAction;
}
