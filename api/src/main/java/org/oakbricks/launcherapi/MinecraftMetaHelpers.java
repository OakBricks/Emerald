package org.oakbricks.launcherapi;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
            String release;
            String snapshot;

            public String getRelease() {
                return release;
            }

            public String getSnapshot() {
                return snapshot;
            }
        }

        class Version {
            String id;
            String type;
            URL url;
            String time;
            String releaseTime;

            public String getId() {
                return id;
            }

            public String getReleaseTime() {
                return releaseTime;
            }

            public  String getTime() {
                return time;
            }

            public String getType() {
                return type;
            }

            public URL getUrl() {
                return url;
            }
        }
    }
}
