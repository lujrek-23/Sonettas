/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.ui.utils

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.dp

fun CornerBasedShape.top(): CornerBasedShape = copy(bottomStart = CornerSize(0.dp), bottomEnd = CornerSize(0.dp))
