/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB FILE — Music Together feature has been removed from Sonettas.
 * These types exist only to keep MusicService.kt compiling during the
 * transitional cleanup period. All operations are no-ops.
 */

package com.sonettas.app.together

// Session state sealed hierarchy
sealed interface TogetherSessionState {
    data object Idle : TogetherSessionState
    data class Joining(val link: TogetherLink) : TogetherSessionState
    data class JoiningOnline(val endpoint: TogetherOnlineEndpoint) : TogetherSessionState
    data class Hosting(
        val settings: TogetherRoomSettings,
        val server: TogetherServer,
    ) : TogetherSessionState
    data class HostingOnline(
        val settings: TogetherRoomSettings,
        val host: TogetherOnlineHost,
        val endpoint: TogetherOnlineEndpoint,
    ) : TogetherSessionState
    data class Joined(
        val role: TogetherRole,
        val roomState: TogetherRoomState,
    ) : TogetherSessionState
    data class Error(
        val message: String,
        val isRecoverable: Boolean = false,
        val canRetryOnline: Boolean = false,
    ) : TogetherSessionState
}

sealed interface TogetherRole {
    data object Host : TogetherRole
    data object Guest : TogetherRole
}

data class TogetherRoomSettings(
    val displayName: String = "",
    val allowGuestsToAddTracks: Boolean = true,
    val allowGuestsToControlPlayback: Boolean = true,
    val requireHostApprovalToJoin: Boolean = false,
)

data class TogetherTrack(
    val id: String,
    val title: String,
    val artists: List<String> = emptyList(),
    val durationMs: Long = 0L,
    val durationSec: Int = 0,
    val albumArt: String? = null,
    val thumbnailUrl: String? = null,
    val album: String? = null,
    val quality: String? = null,
    val source: String? = null,
    val mimeType: String? = null,
    val streamUrl: String? = null,
    val bitrate: Int = 0,
    val averageBitrate: Int = 0,
    val estimatedBitrate: Int = 0,
    val itag: Int = 0,
)

data class TogetherParticipant(
    val id: String,
    val displayName: String,
    val isHost: Boolean = false,
)

data class TogetherRoomState(
    val tracks: List<TogetherTrack> = emptyList(),
    val participants: List<TogetherParticipant> = emptyList(),
    val currentIndex: Int = 0,
    val positionMs: Long = 0L,
    val isPlaying: Boolean = false,
    val repeatMode: Int = 0,
    val shuffleEnabled: Boolean = false,
    val settings: TogetherRoomSettings = TogetherRoomSettings(),
    val host: TogetherParticipant? = null,
    val port: Int = 0,
    val sessionId: String = "",
    val sessionKey: String = "",
    val hostDisplayName: String = "",
)

data class TogetherJoinInfo(
    val displayName: String,
    val settings: TogetherRoomSettings,
    val host: String = "",
    val port: Int = 0,
    val sessionId: String = "",
    val sessionKey: String = "",
    val hostDisplayName: String = "",
    val hostParticipantId: String = "",
    val initialSettings: TogetherRoomSettings = TogetherRoomSettings(),
)

data class TogetherLink(val url: String, val code: String = "") {
    companion object {
        fun encode(info: TogetherJoinInfo): TogetherLink = TogetherLink(url = "")
        fun decode(url: String): TogetherJoinInfo? = null
    }
}

data class TogetherOnlineEndpoint(val url: String) {
    fun onlineWebSocketUrlOrNull(fallback: String): String? = null
    companion object
}

class TogetherOnlineApiException(message: String) : Exception(message)

data class HostTransferred(val newHostId: String)

// Control actions
sealed interface ControlAction {
    data object Play : ControlAction
    data object Pause : ControlAction
    data class SeekTo(val positionMs: Long) : ControlAction
    data object SkipNext : ControlAction
    data object SkipPrevious : ControlAction
    data class SeekToTrack(val trackId: String) : ControlAction
    data class SeekToIndex(val index: Int) : ControlAction
    data class SetRepeatMode(val mode: Int) : ControlAction
    data class SetShuffleEnabled(val enabled: Boolean) : ControlAction
}

enum class AddTrackMode { PLAY_NEXT, ADD_TO_QUEUE }

// Server / Client / Host stubs (no-op)
class TogetherServer(
    val port: Int = 0,
    val settings: TogetherRoomSettings = TogetherRoomSettings(),
    val onEvent: suspend (TogetherServerEvent) -> Unit = {},
    val scope: kotlinx.coroutines.CoroutineScope? = null,
    val sessionId: String = "",
    val sessionKey: String = "",
    val hostDisplayName: String = "",
    val initialSettings: TogetherRoomSettings = TogetherRoomSettings(),
    val hostParticipantId: String = "",
) {
    fun start() {}
    fun stop() {}
    fun broadcastRoomState(state: TogetherRoomState) {}
    fun transferHost(newHostId: String) {}
}

class TogetherOnlineHost(
    val endpoint: TogetherOnlineEndpoint,
    val settings: TogetherRoomSettings = TogetherRoomSettings(),
    val onEvent: suspend (TogetherServerEvent) -> Unit = {},
) {
    fun start() {}
    fun stop() {}
    fun broadcastRoomState(state: TogetherRoomState) {}
    fun transferHost(newHostId: String) {}
}

class TogetherClient(
    val url: String,
    val displayName: String,
    val onEvent: suspend (TogetherClientEvent) -> Unit = {},
) {
    fun connect() {}
    fun disconnect() {}
    fun sendControl(action: ControlAction) {}
    fun sendAddTrack(track: TogetherTrack, mode: AddTrackMode) {}
}

class TogetherClock {
    fun now(): Long = System.currentTimeMillis()
}

sealed interface TogetherClientEvent {
    data class Welcome(val roomState: TogetherRoomState) : TogetherClientEvent
    data class RoomState(val state: TogetherRoomState) : TogetherClientEvent
    data class HostTransferred(val transfer: HostTransferred) : TogetherClientEvent
    data class ControlRequested(val action: ControlAction, val fromParticipantId: String) : TogetherClientEvent
    data class AddTrackRequested(val track: TogetherTrack, val mode: AddTrackMode, val fromParticipantId: String) : TogetherClientEvent
    data class JoinDecision(val accepted: Boolean, val reason: String?) : TogetherClientEvent
    data class ServerIssue(val message: String, val recoverable: Boolean) : TogetherClientEvent
    data object HeartbeatPong : TogetherClientEvent
    data class Error(val throwable: Throwable) : TogetherClientEvent
    data object Disconnected : TogetherClientEvent
}

sealed interface TogetherServerEvent {
    data class ControlRequested(val action: ControlAction, val fromParticipantId: String) : TogetherServerEvent
    data class AddTrackRequested(val track: TogetherTrack, val mode: AddTrackMode, val fromParticipantId: String) : TogetherServerEvent
    data class ParticipantJoined(val participant: TogetherParticipant) : TogetherServerEvent
    data class ParticipantLeft(val participantId: String) : TogetherServerEvent
    data class HostTransferred(val transfer: HostTransferred) : TogetherServerEvent
    data class RoomStateReceived(val state: TogetherRoomState) : TogetherServerEvent
    data class Error(val throwable: Throwable) : TogetherServerEvent
}

sealed interface TogetherGuestOp {
    data class Control(val action: ControlAction) : TogetherGuestOp
    data class AddTrack(val track: TogetherTrack, val mode: AddTrackMode) : TogetherGuestOp
}

object TogetherGuestPlaybackPlanner {
    fun planPlayTrackNow(
        currentTrack: TogetherTrack,
        currentIndex: Int,
        roomTracks: List<TogetherTrack>,
    ): List<TogetherTrack> = emptyList()
}

object TogetherPlaybackSync {
    const val BroadcastIntervalMs: Long = 2000L
    fun isStaleRoomState(state: TogetherRoomState, now: Long): Boolean = false
    fun targetPositionMs(state: TogetherRoomState, now: Long): Long = 0L
    fun echoSuppressionUntil(state: TogetherRoomState, now: Long): Long = 0L
    fun needsQueueRebuild(current: List<String>, target: List<String>): Boolean = false
    fun shouldSeekForDrift(currentPos: Long, targetPos: Long): Boolean = false
}

object TogetherOnlineApi {
    suspend fun fetchEndpoints(): List<TogetherOnlineEndpoint> = emptyList()
}

object TogetherMessages {
    const val DEFAULT_PORT = 8842
}
