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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
  var count: Int by mutableStateOf(0)

  renderComposable(rootElementId = "root") {
    Div({ style { padding(25.px) } }) {
      Button(
        attrs = {
          onClick { count -= 1 }
        },
      ) {
        Text("-")
      }

      Span({ style { padding(15.px) } }) {
        Text("$count")
      }

      Button(
        attrs = {
          onClick { count += 1 }
        },
      ) {
        Text("+")
      }
    }
  }
}
