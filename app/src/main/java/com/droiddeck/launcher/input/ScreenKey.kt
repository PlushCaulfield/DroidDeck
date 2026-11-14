package com.droiddeck.launcher.input

import android.content.Context

fun screenKeyLabel(context: Context, codes: List<Int>): String =
    codes.filter { it != 0 }.joinToString("+") { short(context, it) }

/**
 * A stick/d-pad direction holds one Int slot. To allow several keys on one direction (e.g. W+Shift),
 * up to three key codes are packed into that Int, 10 bits each. A single code (< 1024) is stored
 * unchanged, so existing layouts keep working.
 */
private const val PACK_BITS = 10
private const val PACK_MASK = (1 shl PACK_BITS) - 1
const val SCREEN_KEY_PACK_LIMIT = 3

fun packScreenKeyCodes(codes: List<Int>): Int {
    var packed = 0
    codes.filter { it in 1..PACK_MASK }.distinct().take(SCREEN_KEY_PACK_LIMIT).forEachIndexed { index, code ->
        packed = packed or (code shl (PACK_BITS * index))
    }
    return packed
}

fun unpackScreenKeyCodes(value: Int): List<Int> {
    if (value <= 0) return emptyList()
    if (value <= PACK_MASK) return listOf(value)
    return (0 until SCREEN_KEY_PACK_LIMIT).map { (value shr (PACK_BITS * it)) and PACK_MASK }.filter { it != 0 }
}

private fun short(context: Context, code: Int): String = when (code) {
    28 -> "⏎"
    14 -> "⌫"
    15 -> "Tab"
    57 -> "Space"
    58 -> "Caps"
    42, 54 -> "Shift"
    29, 97 -> "Ctrl"
    56 -> "Alt"
    100 -> "AltGr"
    125 -> "Super"
    else -> pcKeyLabel(context, code)
}

const val SCREEN_KEY_PILL = 0
const val SCREEN_KEY_ROUND = 1
const val SCREEN_KEY_CIRCLE = 2
const val SCREEN_KEY_RECT = 3
const val SCREEN_KEY_TRIGGER = 4
const val SCREEN_KEY_DPAD = 5
const val SCREEN_KEY_STICK = 6

val SCREEN_KEY_DPAD_DIRS = listOf("↑", "→", "↓", "←")
val SCREEN_KEY_STICK_DIRS = listOf("↑", "↗", "→", "↘", "↓", "↙", "←", "↖")

fun screenKeyDirections(shape: Int): List<String> = when (shape) {
    SCREEN_KEY_DPAD -> SCREEN_KEY_DPAD_DIRS
    SCREEN_KEY_STICK -> SCREEN_KEY_STICK_DIRS
    else -> emptyList()
}

data class ScreenKey(
    val codes: List<Int>,
    val x: Float,
    val y: Float,
    val size: Int,
    val glyph: String = "",
    val text: String = "",
    val image: String = "",
    val opacity: Float = 1f,
    val shape: Int = SCREEN_KEY_PILL,
    val toggle: Boolean = false,
    val labels: Boolean = true,
) {
}
