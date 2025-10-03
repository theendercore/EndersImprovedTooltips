package org.teamvoided.template.client.toolitp

import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import org.teamvoided.template.client.utils.hexText
import org.teamvoided.template.client.utils.primaryText
import java.util.function.Consumer

fun dyeTooltips(rgb: Int, consumer: Consumer<Component>) {
    val color = hexText(rgb).withColor(rgb)
    consumer.accept(primaryText("item.color", color))
}

fun appendList(component: MutableComponent, list: List<Component>) = appendList(component, list) { it }
fun <T> appendList(component: MutableComponent, list: List<T>, process: (T) -> Component): Component {
    for ((idx, item) in list.withIndex()) {
        if (idx > 0) component.append(", ")
        component.append(process(item))
    }

    return component
}