plugins {
    java
    application
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
    // Api stuff
    implementation(project(":api"))
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
}

application {
    mainClass.set("org.oakbricks.emeraldpackman.Main")
}