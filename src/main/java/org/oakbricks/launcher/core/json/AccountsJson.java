package org.oakbricks.launcher.core.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AccountsJson {
    private static class Account {
        public Account(String uuid, String email, String username, String password, AccountType type) {
            this.uuid = uuid;
            this.email = email;
            this.username = username;
            this.password = password;
            this.type = type;
        }

        String uuid;
        String email;
        String username;
        String password;
        AccountType type;
    }

    public enum AccountType {
        MSA,
        MOJ
    }
    public static String getJsonFromAccount(String uuid, String email, String username, String password, AccountType type) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new Account(uuid, email, username, password, type));
    }
}
