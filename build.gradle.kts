/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.dependency.PluginProjectDependency

fun properties(key: String) = project.findProperty(key)
    .toString()

plugins {
    // Java support
    id("java")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    // Gradle IntelliJ Plugin
    id("org.jetbrains.intellij") version "1.9.0"
    // Gradle Changelog Plugin
    id("org.jetbrains.changelog") version "1.3.1"
    // Gradle Qodana Plugin
    id("org.jetbrains.qodana") version "0.1.13"
    // grammarkit - read more: https://github.com/JetBrains/gradle-grammar-kit-plugin
    id("org.jetbrains.grammarkit") version "2021.2.2"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDir("$projectDir/src/main/gen")
        java.srcDir("$projectDir/src/main/java")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") // https://github.com/gradle/gradle/issues/22333
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(properties("jvmTarget")))
    }
}

// Configure Gradle IntelliJ Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))
    type.set(properties("platformType"))

    sandboxDir.set("$projectDir/sandbox")

    downloadSources.set(false)
    updateSinceUntilBuild.set(false)

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(
        properties("platformPlugins").split(',')
            .map(String::trim)
            .filter(String::isNotEmpty)
    )
}

grammarKit {
    // version of IntelliJ patched JFlex (see bintray link below), Default is 1.7.0-1
    jflexRelease.set("1.7.0-1")

    // tag or short commit hash of Grammar-Kit to use (see link below). Default is 2020.1
    grammarKitRelease.set("2021.1.2")
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    version.set(properties("pluginVersion"))
    groups.set(emptyList())
}

// Configure Gradle Qodana Plugin - read more: https://github.com/JetBrains/gradle-qodana-plugin
qodana {
    cachePath.set(projectDir.resolve(".qodana").canonicalPath)
    reportPath.set(projectDir.resolve("build/reports/inspections").canonicalPath)
    saveReport.set(true)
    showReport.set(
        System.getenv("QODANA_SHOW_REPORT")
            ?.toBoolean() ?: false
    )
}

tasks {
    withType<org.jetbrains.intellij.tasks.RunIdeBase> {
        autoReloadPlugins.set(true)
        /*project.file("jbr/bin/java")
                .takeIf { it.exists() }
                ?.let { projectExecutable.set(it.toString()) } ?: tasksUsingDownloadedJbr.add(this)*/
        jvmArgs("-Xmx2048m")
    }

    withType<org.jetbrains.intellij.tasks.PrepareSandboxTask> {
        configureExternalPlugin(
            PluginProjectDependency(
                file("dev-plugins/Dracula/lib/dracula-theme-1.14.0.jar"),
                "Dracula"
            )
        )
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        this.destinationDirectory.set(projectDir.resolve("build/classes/kotlin/main"))
        kotlinOptions.jvmTarget = properties("jvmTarget")
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=enable")
    }

    task("metadata") {
        outputs.upToDateWhen { false }
        doLast {
            val dir = project.buildDir.resolve("metadata")
            dir.mkdirs()
            dir.resolve("version.txt")
                .writeText(properties("pluginVersion"))
            dir.resolve("zipfile.txt")
                .writeText(
                    buildPlugin.get().archiveFile.get()
                        .toString()
                )
            dir.resolve("latest_changelog.md")
                .writeText(
                    changelog.getLatest()
                        .toText()
                )
        }
    }

    wrapper {
        gradleVersion = properties("gradleVersion")
    }

    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set(properties("pluginVersion"))
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription.set(projectDir.resolve("README.md")
                                  .readText()
                                  .lines()
                                  .run {
                                      val start = "<!-- Plugin description -->"
                                      val end = "<!-- Plugin description end -->"

                                      if (!containsAll(
                                              listOf(
                                                  start,
                                                  end
                                              )
                                          )
                                      ) {
                                          throw GradleException(
                                              "Plugin description section not found in README.md:\n$start ... $end"
                                          )
                                      }
                                      subList(
                                          indexOf(start) + 1,
                                          indexOf(end)
                                      )
                                  }
                                  .joinToString("\n")
                                  .run { markdownToHTML(this) })

        // Get the latest available change notes from the changelog file
        changeNotes.set(provider {
            changelog.run {
                getOrNull(properties("pluginVersion")) ?: getLatest()
            }
                .toHTML()
        })
    }

    // Configure UI tests plugin
    // Read more: https://github.com/JetBrains/intellij-ui-test-robot
    runIdeForUiTests {
        systemProperty(
            "robot-server.port",
            "8082"
        )
        systemProperty(
            "ide.mac.message.dialogs.as.sheets",
            "false"
        )
        systemProperty(
            "jb.privacy.policy.text",
            "<!--999.999-->"
        )
        systemProperty(
            "jb.consents.confirmation.enabled",
            "false"
        )
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token.set(System.getenv("PUBLISH_TOKEN"))
        // pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels.set(listOf(properties("pluginVersion").split('-')
                                .getOrElse(1) { "default" }
                                .split('.')
                                .first()))
    }
    runPluginVerifier {
        failureLevel.set(org.jetbrains.intellij.tasks.RunPluginVerifierTask.FailureLevel.ALL)
    }

    test {
        // This path value is a machine-specific placeholder text.
        // Set idea.home.path to the absolute path to the intellij-community source
        // on your local machine. For real world projects, use variants described in:
        // https://docs.gradle.org/current/userguide/build_environment.html
        systemProperty(
            "idea.home.path",
            properties("intellijCommunityPath")
        )
        useJUnitPlatform()
    }
}

apply(from = "gradle/bumpVersion.gradle.kts")