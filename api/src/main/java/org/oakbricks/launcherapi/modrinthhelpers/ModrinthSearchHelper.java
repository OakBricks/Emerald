package org.oakbricks.launcherapi.modrinthhelpers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ModrinthSearchHelper {
    public static String getSearchResults(String query, String index) throws IOException {
        String out;

        out = search(query, index, "20", "[[\"project_type:mod\"]]");

        return out;
    }

    public static String getSearchResults(String query, String index, String limit) throws IOException {
        String out;

        out = search(query, index, limit, "[[\"project_type:mod\"]]");

        return out;
    }

    public static String getSearchResults(String query, String index, String limit, String facets) throws IOException {
        String out;

        out = search(query, index, limit, facets);

        return out;
    }

    public static String testModrinthApi() throws IOException {
        String out;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/")
                .build(); // defaults to GET
        Response response = client.newCall(request).execute();
        out = response.body().string();
        response.close();

        return out;
    }

    private static String search(String query, String index, String limit, String facets) throws IOException {
        String out;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/search?limit=" + limit +"&index=" + index + "&query=" + query + "&facets=" + facets)
                .build(); // defaults to GET
        Response response = client.newCall(request).execute();
        out = response.body().string();
        response.close();

        return out;
    }
}
