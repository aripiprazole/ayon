/*
 * This file is part of Ayon distribution
 * Copyright (C) 2022 Gabrielle Guimarães
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

import org.jetbrains.compose.compose

plugins {
  id("org.jetbrains.compose")
}

repositories {
  google()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
  js(IR) {
    browser {
      testTask {
        testLogging.showStandardStreams = true
        useKarma {
          useChromeHeadless()
          useFirefox()
        }
      }
    }
    binaries.executable()
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(projects.common)
        implementation(compose.web.core)
        implementation(compose.runtime)
      }
    }

    val jsTest by getting {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}
