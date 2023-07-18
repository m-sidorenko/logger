import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.7.21"
    // id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

java {
    withSourcesJar()
}

val gitLabPrivateTokenType: String by project
val gitLabPrivateToken: String by project

allprojects {

    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            name = "gitlab-maven"
            url = uri("https://nomia.dev/api/v4/groups/nomia/-/packages/maven")
            credentials(HttpHeaderCredentials::class.java) {
                name = gitLabPrivateTokenType
                value = gitLabPrivateToken
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "9"
        targetCompatibility = "9"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                groupId = "net.nomia.util"
                artifactId = "logger"
                version = "0.0.2"

                afterEvaluate {
                    from(components["java"])
                }
            }
        }

        repositories {
            maven {
                url = uri("https://nomia.dev/api/v4/projects/166/packages/maven")
                credentials(HttpHeaderCredentials::class.java) {
                    name = gitLabPrivateTokenType
                    value = gitLabPrivateToken
                }
                authentication {
                    create<HttpHeaderAuthentication>("header")
                }
            }
        }
    }
}