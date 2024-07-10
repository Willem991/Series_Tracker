plugins {
    java
    application
}

group = "com.gemail.ruannieu"
version = "application"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src/main/java"))
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Set the main class for the application
    mainClass.set("com.gemail.ruannieu.Main")
}

tasks.jar {
    manifest {
        attributes(
                "Main-Class" to "com.gemail.ruannieu.Main"
        )
    }
}
