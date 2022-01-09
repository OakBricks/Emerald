package org.oakbricks.launcher.core.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AccountsJson {
    private String uuid;
    private String email;
    private String username;
    private String password;
    private AccountType type;

    public AccountsJson(String uuid, String email, String username, String password, AccountType type) {
        this.uuid = uuid;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public static String getJsonFromAccount(String uuid, String email, String username, String password, AccountType type) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new AccountsJson(uuid, email, username, password, type));
    }

    public enum AccountType {
        MSA,
        MOJ
    }

    public AccountType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getUuid() {
        return uuid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
