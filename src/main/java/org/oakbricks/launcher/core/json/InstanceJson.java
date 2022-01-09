package org.oakbricks.launcher.core.json;

import lombok.NonNull;

import java.util.UUID;

public class InstanceJson {

    UUID instanceUuid;
    String instanceName;
    ActionTypes instanceLaunchActionType;
    String instanceLaunchAction;
    ActionTypes instanceExitActionType;
    String instanceExitAction;
    
    public InstanceJson(UUID uuid, String name, ActionTypes launchActionType, String launchAction, ActionTypes exitActionType, String exitAction) {
        instanceUuid = uuid;
        instanceName = name;
        instanceLaunchActionType = launchActionType;
        instanceLaunchAction = launchAction;
        instanceExitActionType = exitActionType;
        instanceExitAction = exitAction;
    }

    public InstanceJson(UUID uuid, String name, ActionTypes launchActionType, String launchAction) {
        instanceUuid = uuid;
        instanceName = name;
        instanceLaunchActionType = launchActionType;
        instanceLaunchAction = launchAction;
        instanceExitActionType = ActionTypes.NONE;
        instanceExitAction = "";
    }

    public InstanceJson(UUID uuid, String name) {
        instanceUuid = uuid;
        instanceName = name;
        instanceLaunchActionType = ActionTypes.NONE;
        instanceLaunchAction = "";
        instanceExitActionType = ActionTypes.NONE;
        instanceExitAction = "";
    }

    public enum ActionTypes {
        NONE,
        JAVASCRIPT,
        EXECUTE
    }

    public ActionTypes getInstanceExitActionType() {
        return instanceExitActionType;
    }

    public ActionTypes getInstanceLaunchActionType() {
        return instanceLaunchActionType;
    }

    public String getInstanceExitAction() {
        return instanceExitAction;
    }

    public String getInstanceLaunchAction() {
        return instanceLaunchAction;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public UUID getInstanceUuid() {
        return instanceUuid;
    }

    public void setInstanceExitAction(String instanceExitAction) {
        this.instanceExitAction = instanceExitAction;
    }

    public void setInstanceExitActionType(ActionTypes instanceExitActionType) {
        this.instanceExitActionType = instanceExitActionType;
    }

    public void setInstanceLaunchAction(String instanceLaunchAction) {
        this.instanceLaunchAction = instanceLaunchAction;
    }

    public void setInstanceLaunchActionType(ActionTypes instanceLaunchActionType) {
        this.instanceLaunchActionType = instanceLaunchActionType;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public void setInstanceUuid(UUID instanceUuid) {
        this.instanceUuid = instanceUuid;
    }
}
