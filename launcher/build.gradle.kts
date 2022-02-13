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
    implementation("io.qtjambi:qtjambi:6.2.2")
    implementation("io.qtjambi:qtjambi-native-windows-x64:6.2.2")
}

application {
    mainClass.set("org.oakbricks.launcher.Main")
}