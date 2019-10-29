import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.gorttar"
version = "1.0-SNAPSHOT"

val kotlinGroup = "org.jetbrains.kotlin"
val kotlinVersion = "1.3.41"

plugins {
    java
    id("idea")
    id("org.jetbrains.intellij") version "0.4.10"
    kotlin("jvm") version "1.3.41"
}

apply(plugin = "kotlin")

repositories { mavenCentral() }

dependencies {
    implementation(group = "com.google.code.findbugs", name = "jsr305", version = "1.3.9")
    implementation(group = kotlinGroup, name = "kotlin-stdlib-jdk8", version = kotlinVersion)
    implementation(group = kotlinGroup, name = "kotlin-reflect", version = kotlinVersion)
    implementation(group = "com.nhaarman", name = "mockito-kotlin", version = "1.6.0")
    testImplementation(group = "org.testng", name = "testng", version = "6.14.3")
}

buildscript {
    repositories { mavenCentral() }
    dependencies {
        classpath(group = "org.testng", name = "testng", version = "6.14.3")
        classpath(group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version = "1.3.41")
    }
}

intellij {
    version = "2019.2.3"
    pluginName = "Inspections Extras"
    updateSinceUntilBuild = false
    apply(plugin = "kotlin")
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    withType<Test> { useTestNG() }
    withType<KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }
    wrapper { gradleVersion = "5.2.1" }
}