/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — News feature removed.
 */

package com.sonettas.app.models

data class NewsItem(
    val id: String,
    val title: String,
    val body: String = "",
    val date: String = "",
    val image: String? = null,
    val url: String? = null,
)
