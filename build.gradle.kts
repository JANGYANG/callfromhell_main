plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "team90s"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_19
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // spring boot starter
    implementation("org.springframework.boot:spring-boot-starter-activemq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")


    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

    implementation("com.twilio.sdk:twilio:9.14.1")
    implementation("org.springframework.boot:spring-boot-starter-test")


    // logging
    testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl")
    implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")
    implementation("org.apache.logging.log4j:log4j-core:2.22.0")
    implementation("org.apache.logging.log4j:log4j-api:2.22.0")

    implementation("org.apache.camel:camel-jetty-starter:3.0.0-M4")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")


}

configurations {
    all {
        exclude("org.springframework.boot", "spring-boot-starter-logging")
        exclude(group = "commons-logging", module = "commons-logging")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}
