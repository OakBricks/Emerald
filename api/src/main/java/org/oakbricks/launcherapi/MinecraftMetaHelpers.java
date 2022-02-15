package org.oakbricks.launcherapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinecraftMetaHelpers {
    public static Object[] getVersions() throws IOException {
        Gson gson = new Gson();
        ArrayList<String> out = new ArrayList<String>();
        VersionMetaAsClass versionMetaFromJson = gson.fromJson(getRawVersionMeta(), VersionMetaAsClass.class);
        for (VersionMetaAsClass.Version v: versionMetaFromJson.versions) {
            out.add(v.id);
        }
        Object[] outArr = out.toArray();
        return outArr;
    }

    public static List<String> getVersionsAsList() throws IOException {
        Gson gson = new Gson();
        ArrayList<String> out = new ArrayList<String>();
        VersionMetaAsClass versionMetaFromJson = gson.fromJson(getRawVersionMeta(), VersionMetaAsClass.class);
        for (VersionMetaAsClass.Version v: versionMetaFromJson.versions) {
            out.add(v.id);
        }
        return out;
    }

    public static String getRawVersionMeta() throws IOException {
        InputStream in = new URL("https://launchermeta.mojang.com/mc/game/version_manifest.json").openConnection().getInputStream();
        Scanner s = new Scanner(in).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    // Oh god no
    class VersionMetaAsClass {
        Latest latest;
        Version[] versions;

        public VersionMetaAsClass(Latest a, Version[] b) {
            latest = a;
            versions = b;
        }

        class Latest {
            static String release;
            static String snapshot;

            public static String getRelease() {
                return release;
            }

            public static String getSnapshot() {
                return snapshot;
            }
        }

        class Version {
            String id;
            static String type;
            static URL url;
            static String time;
            static String releaseTime;

            public String getId() {
                return id;
            }

            public static String getReleaseTime() {
                return releaseTime;
            }

            public static String getTime() {
                return time;
            }

            public static String getType() {
                return type;
            }

            public static URL getUrl() {
                return url;
            }
        }
    }
}
