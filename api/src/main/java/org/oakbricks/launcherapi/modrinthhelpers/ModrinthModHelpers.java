package org.oakbricks.launcherapi.modrinthhelpers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ModrinthModHelpers {
    /**
     * @param name It is recommended to use an ID instead of a slug for mods
     * @return Returns raw JSON of a mod from modrinth.
     * @throws IOException
     */
    private static String getMod(String name) throws IOException {
        String out;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/project/" + name)
                .build(); // defaults to GET
        Response response = client.newCall(request).execute();
        out = response.body().string();
        response.close();

        return out;
    }
}
