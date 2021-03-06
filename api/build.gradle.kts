plugins {
    java
}

group = "org.oakbricks"
version = "0.2.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.microsoft.azure:msal4j:1.12.0")
}