package org.teamvoided.template.client.toolitp

import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.world.item.DyeColor
import net.minecraft.world.item.component.FireworkExplosion
import org.teamvoided.template.client.TemplateClient.config
import org.teamvoided.template.client.utils.*
import java.util.function.Consumer

val TRAIL = text("item.minecraft.firework_star.trail")
val TWINKLE = text("item.minecraft.firework_star.flicker")
val CUSTOM_COLOR_NAME = text("item.minecraft.firework_star.custom_color")
val FADE_TO = text("item.minecraft.firework_star.fade_to")

fun shapeTooltip(exp: FireworkExplosion, consumer: Consumer<Component>) {
    consumer.accept(primaryText(SHAPE).append(exp.shape.getName().withStyle(config.shapeColor.get())))
}

fun additionalTooltip(exp: FireworkExplosion, consumer: Consumer<Component>) {
    if (exp.colors.isNotEmpty()) {
        consumer.accept(appendList(indentedText(COLORS), exp.colors, ::getColorName))
    }
    if (exp.fadeColors.isNotEmpty()) {
        consumer.accept(appendList(indentedText(FADE_TO).append(": "), exp.fadeColors, ::getColorName))
    }
    val effects = buildList {
        if (exp.hasTrail) add(TRAIL.withStyle(config.trailColor.get()))
        if (exp.hasTwinkle) add(TWINKLE.withStyle(config.twinkleColor.get()))
    }
    if (effects.isNotEmpty()) {
        consumer.accept(appendList(indentedText(EFFECTS), effects))
    }
}

fun getColorName(idx: Int): MutableComponent {
    var text: MutableComponent
    var color: Int

    val dye = DyeColor.byFireworkColor(idx)
    if (dye != null) {
        color = dye.fireworkColor
        text = text("item.minecraft.firework_star.${dye.getName()}")
    } else {
        color = idx
        text = if (config.customColorsAsHex) hexText(idx) else CUSTOM_COLOR_NAME.copy()
    }

    return if (config.colorEntriesUseCustomColors)
        text.withColor(color)
    else
        text.withStyle(config.colorEntryColor.get())
}