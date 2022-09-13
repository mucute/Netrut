buildscript {
    dependencies {
        classpath("com.github.dcendents:android-maven-gradle-plugin:1.4.1")
    }
}
plugins {

    id("kotlin")
//    id("com.github.dcendents.android-maven")
    kotlin("jvm") version "1.7.10"
}

group = "com.github.mucute"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.4.0")
    implementation(kotlin("reflect"))
// https://mvnrepository.com/artifact/com.alibaba/fastjson
    implementation("com.alibaba:fastjson:2.0.12")
    implementation(kotlin("stdlib"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
