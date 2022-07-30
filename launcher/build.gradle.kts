plugins {
    java
    application
}

val qtNatives = Pair(
    System.getProperty("os.name")!!,
    System.getProperty("os.arch")!!
).let { (os, arch) ->
    when {
        arrayOf("Linux", "FreeBSD", "SunOS", "Unit").any { os.startsWith(it) } ->
            "linux-x64"
        arrayOf("Mac OS X", "Darwin").any { os.startsWith(it) }                ->
            "macos"
        arrayOf("Windows").any { os.startsWith(it) }                           ->
            "windows-x64"
        else -> throw Error("Unrecognized or unsupported platform. Please set \"lwjglNatives\" manually")
    }
}


group = "org.oakbricks"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.tinylog:tinylog-api:2.4.1")
    implementation("org.tinylog:tinylog-impl:2.4.1")
    implementation("commons-io:commons-io:2.11.0")
    implementation("com.google.code.gson:gson:2.9.0")
    // qt stuff
    implementation("io.qtjambi:qtjambi:6.3.1")
    implementation("io.qtjambi:qtjambi-native-${qtNatives}:6.3.1")
    // Api stuff
    implementation(project(":api"))
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
}

application {
    mainClass.set("org.oakbricks.emerald.Main")
}