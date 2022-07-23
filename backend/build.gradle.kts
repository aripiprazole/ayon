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

plugins {
  application
}

application {
  mainClass.set("me.devgabi.ayon.backend.MainKt")
}

kotlin {
  sourceSets {
    val jvmMain by getting {
      dependencies {
        implementation("io.ktor:ktor-server-core-jvm:2.0.3")
        implementation("io.ktor:ktor-server-netty-jvm:2.0.3")
        implementation("io.ktor:ktor-server-status-pages-jvm:2.0.3")
        implementation("io.ktor:ktor-server-default-headers-jvm:2.0.3")
      }
    }
  }
}
