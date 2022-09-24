plugins {

    id("kotlin")
    id("maven-publish")
    kotlin("jvm") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation(kotlin("reflect"))
    implementation("com.alibaba:fastjson:2.0.13.android")
    implementation(kotlin("stdlib"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
afterEvaluate {
    publishing {
        publications {
            create("maven_public", MavenPublication::class) {
                groupId = "com.github.mucute"
                artifactId = "Netrut"
                version = "1.0.0"
                from(components.getByName("java"))
            }

        }
    }
}