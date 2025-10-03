package org.teamvoided.template.client.utils

import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import org.teamvoided.template.client.TemplateClient.config
import java.util.*

fun text(lang: String, vararg obj: Any): MutableComponent = Component.translatable(lang, *obj)
fun rawText(string: String): MutableComponent = Component.literal(string)

fun hex(hex: Int) = String.format(Locale.ROOT, "#%06X", hex)
fun hexText(hex: Int) = rawText(hex(hex))

fun primaryText(lang: MutableComponent): MutableComponent = lang.withStyle(config.primaryTooltipColor.get())
fun primaryText(lang: String, vararg obj: Any): MutableComponent = primaryText(text(lang, *obj))

fun getIndent(): MutableComponent = Component.literal(" ".repeat(config.indentSpaces.get()))
fun indented(lang: Component): MutableComponent = getIndent().append(lang)

fun indentedText(lang: MutableComponent): MutableComponent = indented(lang)
fun indentedText(lang: String): MutableComponent = indentedText(text(lang))
fun indentedPrimary(lang: String): MutableComponent = primaryText(indentedText(lang))
