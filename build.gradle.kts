plugins {
    id("java")
}

group = "jozaCo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

object Versions {
    const val SELENIUM_VERSION = "4.23.0"
    const val LOG4J_VERSION = "2.19.0"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")


//    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")

    implementation("org.seleniumhq.selenium:selenium-java:${Versions.SELENIUM_VERSION}")
    implementation("org.seleniumhq.selenium:selenium-devtools-v113:4.11.0")

    implementation("org.apache.logging.log4j:log4j-api:${Versions.LOG4J_VERSION}")
    implementation("org.apache.logging.log4j:log4j-core:${Versions.LOG4J_VERSION}")

    implementation("org.slf4j:slf4j-simple:2.0.7")

    implementation("io.rest-assured:rest-assured:5.3.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

}

tasks.test {
    useJUnitPlatform()
}