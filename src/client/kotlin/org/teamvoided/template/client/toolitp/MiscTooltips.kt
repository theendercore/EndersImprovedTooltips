package org.teamvoided.template.client.toolitp

import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import org.teamvoided.template.client.utils.hexText
import java.util.function.Consumer

fun dyeTooltips(rgb: Int, consumer: Consumer<Component>) {
    val color = hexText(rgb).withColor(rgb)
    consumer.accept(Component.translatable("item.color", color).withStyle(ChatFormatting.GRAY))
}

fun appendList(component: MutableComponent, list: List<Component>) = appendList(component, list) { it }
fun <T> appendList(component: MutableComponent, list: List<T>, proc: (T) -> Component): Component {
    for ((idx, item) in list.withIndex()) {
        if (idx > 0) component.append(", ")
        component.append(proc(item))
    }

    return component
}