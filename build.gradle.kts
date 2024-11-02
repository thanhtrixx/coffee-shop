plugins {
  kotlin("jvm") version "2.0.0"
  kotlin("plugin.spring") version "2.0.0"
  id("org.springframework.boot") version "3.3.5"
  id("io.spring.dependency-management") version "1.1.6"
  kotlin("plugin.jpa") version "2.0.0"
}

group = "trile"
version = "0.0.1"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

extra["springModulithVersion"] = "1.2.4"

configurations.forEach { it.exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging") }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("io.micrometer:micrometer-tracing-bridge-brave")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.springframework.modulith:spring-modulith-starter-core")
  implementation("org.springframework.modulith:spring-modulith-starter-jpa")

  implementation("org.springframework.boot:spring-boot-starter-log4j2")
  implementation("org.apache.logging.log4j:log4j-api-kotlin:1.5.0")

//  implementation("dev.krud:shapeshift:0.8.0")

  compileOnly("org.projectlombok:lombok")
  runtimeOnly("com.mysql:mysql-connector-j")
  runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
  runtimeOnly("org.springframework.modulith:spring-modulith-observability")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testImplementation("org.springframework.modulith:spring-modulith-starter-test")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
  imports {
    mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
  }
}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

allOpen {
  annotation("jakarta.persistence.Entity")
  annotation("jakarta.persistence.MappedSuperclass")
  annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
