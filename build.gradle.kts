import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
}

group = "top.vuhe"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    // springboot 启动框架
    implementation("org.springframework.boot:spring-boot-starter-web")

    // json 默认解析包
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // kotlin 默认配置
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // springboot 默认测试框架
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // 数据库配置
    implementation("com.baomidou:mybatis-plus-boot-starter:3.4.1")
    implementation("com.alibaba:druid-spring-boot-starter:1.2.4")
    implementation("mysql:mysql-connector-java:8.0.22")
    implementation("org.springframework:spring-jdbc:5.3.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
