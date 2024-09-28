plugins {
    kotlin("jvm") version "2.0.0"
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "kr.jimin.walker"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    implementation("dev.jorel:commandapi-bukkit-shade:9.5.2")
}

tasks{

    test {
        useJUnitPlatform()
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }

    shadowJar {
        archiveFileName.set("NoFrostWalker-${rootProject.version}.jar")
        destinationDirectory.set(file("C:\\Users\\aa990\\OneDrive\\바탕 화면\\테스트 서버\\MyProject(100)\\plugins"))
    }

    build.get().dependsOn(shadowJar)
}

kotlin {
    jvmToolchain(21)
}