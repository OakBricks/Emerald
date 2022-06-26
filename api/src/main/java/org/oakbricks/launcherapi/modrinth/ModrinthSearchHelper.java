package org.oakbricks.launcherapi.modrinth;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ModrinthSearchHelper {
    public static String search(String query, String index, String limit) throws IOException {
        String out;

        out = directSearch(query, index, limit, "[[\"project_type:mod\"]]");

        return out;
    }

    public static String search(String query, String index, String limit, String facets) throws IOException {
        String out;

        out = directSearch(query, index, limit, facets);

        return out;
    }

    private static String directSearch(String query, String index, String limit, String facets) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/search?limit=" + limit +"&index=" + index + "&query=" + query + "&facets=" + facets)
                .build();
        Response response = client.newCall(request).execute();
        String out = response.body().string();
        response.close();
        return out;
    }
}
