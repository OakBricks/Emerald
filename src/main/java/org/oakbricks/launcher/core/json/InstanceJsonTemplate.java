package org.oakbricks.launcher.core.json;

import lombok.NonNull;

import java.util.UUID;

public class InstanceJsonTemplate {

    public InstanceJsonTemplate(@NonNull UUID uuid, @NonNull String name, @NonNull ActionTypes launchActionType, @NonNull String launchAction, @NonNull ActionTypes exitActionType, @NonNull String exitAction) {
        instanceUuid = uuid;
        instanceName = name;
        instanceLaunchActionType = launchActionType;
        instanceLaunchAction = launchAction;
        instanceExitActionType = exitActionType;
        instanceExitAction = exitAction;
    }
    UUID instanceUuid;
    String instanceName;
    ActionTypes instanceLaunchActionType;
    String instanceLaunchAction;
    ActionTypes instanceExitActionType;
    String instanceExitAction;

    public enum ActionTypes {
        NONE,
        PYTHON,
        LUA,
        EXECUTE
    }
}
