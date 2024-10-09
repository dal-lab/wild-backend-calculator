plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web:3.3.4")
    //  implementation("org.springframework:spring-core:6.1.13")
    //  implementation("org.springframework:spring-context:6.1.13")
    //  implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")

    // for testing.
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.4")
    //  testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.2")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "com.example.demo.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
