package org.teamvoided.template.client.utils

import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import org.teamvoided.template.client.TemplateClient.indented
import java.util.*

fun text(lang: String, vararg obj: Any): MutableComponent = Component.translatable(lang, *obj)
fun rawText(string: String): MutableComponent = Component.literal(string)

fun hex(hex: Int) = String.format(Locale.ROOT, "#%06X", hex)
fun hexText(hex: Int) = rawText(hex(hex))

fun primaryText(lang: String): MutableComponent = primaryText(text(lang))
fun primaryText(lang: MutableComponent): MutableComponent = lang.withStyle(ChatFormatting.GRAY)

fun indentedText(lang: String): MutableComponent = indentedText(text(lang))
fun indentedText(lang: Component): MutableComponent = primaryText(indented(lang))


