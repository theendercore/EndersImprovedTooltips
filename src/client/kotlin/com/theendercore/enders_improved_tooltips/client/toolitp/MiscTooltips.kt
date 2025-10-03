package com.theendercore.enders_improved_tooltips.client.toolitp

import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.world.item.Item
import net.minecraft.world.item.JukeboxPlayable
import com.theendercore.enders_improved_tooltips.client.EndersImprovedTooltipsClient
import com.theendercore.enders_improved_tooltips.client.EndersImprovedTooltipsClient.config
import com.theendercore.enders_improved_tooltips.client.utils.AUTHOR
import com.theendercore.enders_improved_tooltips.client.utils.COMP_OUTPUT
import com.theendercore.enders_improved_tooltips.client.utils.SONG_LENGTH
import com.theendercore.enders_improved_tooltips.client.utils.TITLE
import com.theendercore.enders_improved_tooltips.client.utils.hexText
import com.theendercore.enders_improved_tooltips.client.utils.primaryText
import com.theendercore.enders_improved_tooltips.client.utils.rawText
import com.theendercore.enders_improved_tooltips.client.utils.time
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

fun dyeTooltips(rgb: Int, consumer: Consumer<Component>) {
    val color = hexText(rgb).withColor(rgb)
    consumer.accept(primaryText("item.color", color))
}

fun discTooltips(playable: JukeboxPlayable, tooltipContext: Item.TooltipContext, c: Consumer<Component>) {
    val provider = tooltipContext.registries() ?: return
    val song = playable.song.unwrap(provider).getOrNull()?.value() ?: return
    val descInfo = song.description().string.split(" - ")
    if (descInfo.size != 2) {
        c.accept(primaryText(song.description().copy()))
    } else {
        c.accept(primaryText(TITLE).append(rawText(descInfo[1], config.titleColor.get())))
        c.accept(primaryText(AUTHOR).append(rawText(descInfo[0], config.authorColor.get())))
    }

    if (!config.extraInfoRequiresShift || EndersImprovedTooltipsClient.hasShift()) {
        c.accept(
            primaryText(COMP_OUTPUT)
                .append(rawText("${song.comparatorOutput()}", config.comparatorOutputColor.get()))
        )
        c.accept(
            primaryText(SONG_LENGTH)
                .append(rawText(time(song.lengthInSeconds).trim(), config.songLengthColor.get()))
        )
    }
}

fun appendList(component: MutableComponent, list: List<Component>) = appendList(component, list) { it }
fun <T> appendList(component: MutableComponent, list: List<T>, process: (T) -> Component): Component {
    for ((idx, item) in list.withIndex()) {
        if (idx > 0) component.append(", ")
        component.append(process(item))
    }

    return component
}