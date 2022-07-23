/*
 * This file is part of Ayon distribution * Copyright (C) 2022 Gabrielle Guimarães
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
  kotlin("multiplatform") version "1.6.10" apply false
  id("org.jetbrains.compose") version "1.1.0" apply false
}

group = "me.devgabi.ayon"
version = "1.0"

subprojects {
  apply(plugin = "org.jetbrains.kotlin.multiplatform")

  group = rootProject.group
  version = rootProject.version

  repositories {
    mavenCentral()
  }

  configure<KotlinMultiplatformExtension> {
    jvm {
      withJava()
      compilations.all {
        kotlinOptions.jvmTarget = "1.8"
      }
      testRuns["test"].executionTask.configure {
        testLogging.showStandardStreams = true
        testLogging.exceptionFormat = TestExceptionFormat.FULL
        useJUnitPlatform()
      }
    }

    js(IR) {
      browser {
        testTask {
          testLogging.showStandardStreams = true
          testLogging.exceptionFormat = TestExceptionFormat.FULL
        }
      }
      binaries.executable()
    }

    sourceSets {
      val commonMain by getting
      val commonTest by getting {
        dependencies {
          implementation(kotlin("test"))
        }
      }

      val jvmMain by getting
      val jvmTest by getting
    }
  }
}
