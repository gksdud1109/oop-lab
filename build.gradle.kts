plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.onezero"
version = "0.0.1-SNAPSHOT"

kotlin {
    jvmToolchain(21)
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
