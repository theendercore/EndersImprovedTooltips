package org.teamvoided.template.client.utils

import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import org.teamvoided.template.client.TemplateClient.config
import java.util.*

fun text(lang: String, vararg obj: Any): MutableComponent = Component.translatable(lang, *obj)
fun rawText(string: String): MutableComponent = Component.literal(string)
fun rawText(string: String, style: ChatFormatting): MutableComponent = Component.literal(string).withStyle(style)

fun hex(hex: Int) = String.format(Locale.ROOT, "#%06X", hex)
fun hexText(hex: Int) = rawText(hex(hex))
fun time(time: Float) = String.format(Locale.ROOT, "%2.0f:%02.0f", time / 60, time % 60)

fun primaryText(lang: MutableComponent): MutableComponent = lang.withStyle(config.primaryTooltipColor.get())
fun primaryText(lang: String, vararg obj: Any): MutableComponent = primaryText(text(lang, *obj))

fun getIndent(): MutableComponent = Component.literal(" ".repeat(config.indentSpaces.get()))
fun indented(lang: Component): MutableComponent = getIndent().append(lang)

fun indentedText(lang: MutableComponent): MutableComponent = indented(lang)
fun indentedText(lang: String): MutableComponent = indentedText(text(lang))
fun indentedPrimary(lang: String): MutableComponent = primaryText(indentedText(lang))
