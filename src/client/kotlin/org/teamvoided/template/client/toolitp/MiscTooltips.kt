package org.teamvoided.template.client.toolitp

import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import java.util.*
import java.util.function.Consumer

fun dyeTooltips(rgb: Int, consumer: Consumer<Component>) {
    val color = Component.literal(String.format(Locale.ROOT, "#%06X", rgb)).withColor(rgb)
    consumer.accept(Component.translatable("item.color", color).withStyle(ChatFormatting.GRAY))
}
