/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — AI service & translator removed from Huasic.
 * AiLyricsDocument/AiLyricsSegment/AiLyricsDocumentParser remain in this
 * package because they are used by the regular translator (not AI).
 */

package com.sonettas.app.ai

data class AiServiceConfig(
    val provider: AiProvider = AiProvider.NONE,
    val apiKey: String = "",
    val customEndpoint: String = "",
    val model: String = "",
)

enum class AiProvider { CHATGPT, GEMINI, CLAUDE, OPENROUTER, CUSTOM, NONE }

enum class AiApiValidationStatus { UNKNOWN, SUCCESS, FAILED }

object AiTextService {
    suspend fun complete(
        config: AiServiceConfig,
        systemPrompt: String,
        userPrompt: String,
        temperature: Double = 0.7,
        maxTokens: Int = 2048,
    ): String = ""
}

class AiLyricsTranslator {
    suspend fun translate(
        config: AiServiceConfig,
        lyrics: String,
        targetLanguage: String,
    ): String = lyrics
}

object AiJsonUtils {
    fun safeParse(json: String): org.json.JSONObject? =
        runCatching { org.json.JSONObject(json) }.getOrNull()
}

object AiModels {
    const val DEFAULT_MODEL = ""
}
