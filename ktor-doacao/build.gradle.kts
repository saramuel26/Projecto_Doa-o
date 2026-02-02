plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.prodoacao"
version = "1.0"

application {
    mainClass.set("com.prodoacao.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor
    implementation("io.ktor:ktor-server-core:2.3.4")
    implementation("io.ktor:ktor-server-netty:2.3.4")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.4")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4")

    // Exposed ORM
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")

    // MySQL
    implementation("mysql:mysql-connector-java:8.0.33")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.4.11")
}

// Forçar Kotlin JVM target compatível com Java 17
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}
