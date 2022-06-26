package org.oakbricks.emeraldpackapi.modrinth;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ModrinthSearchHelper {

    private static String search(String query) throws IOException {
        String limit = "10";
        String facets = "[[\"categories:fabric\"],[\"versions:1.19\"],[\"project_type:mod\"]]";
        String index = "relevance";

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
