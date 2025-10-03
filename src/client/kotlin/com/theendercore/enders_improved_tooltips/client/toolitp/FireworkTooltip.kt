package com.theendercore.enders_improved_tooltips.client.toolitp

import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.world.item.DyeColor
import net.minecraft.world.item.component.FireworkExplosion
import com.theendercore.enders_improved_tooltips.client.EndersImprovedTooltipsClient.config
import com.theendercore.enders_improved_tooltips.client.utils.COLORS
import com.theendercore.enders_improved_tooltips.client.utils.EFFECTS
import com.theendercore.enders_improved_tooltips.client.utils.SHAPE
import com.theendercore.enders_improved_tooltips.client.utils.hexText
import com.theendercore.enders_improved_tooltips.client.utils.indentedPrimary
import com.theendercore.enders_improved_tooltips.client.utils.primaryText
import com.theendercore.enders_improved_tooltips.client.utils.text
import java.util.function.Consumer

val TRAIL = text("item.minecraft.firework_star.trail")
val TWINKLE = text("item.minecraft.firework_star.flicker")
const val CUSTOM_COLOR_NAME = "item.minecraft.firework_star.custom_color"
const val FADE_TO = "item.minecraft.firework_star.fade_to"

fun shapeTooltip(exp: FireworkExplosion, consumer: Consumer<Component>) {
    consumer.accept(primaryText(SHAPE).append(exp.shape.getName().withStyle(config.shapeColor.get())))
}

fun additionalTooltip(exp: FireworkExplosion, consumer: Consumer<Component>) {
    if (exp.colors.isNotEmpty()) {
        consumer.accept(appendList(indentedPrimary(COLORS), exp.colors, ::getColorName))
    }
    if (exp.fadeColors.isNotEmpty()) {
        consumer.accept(appendList(indentedPrimary(FADE_TO).append(": "), exp.fadeColors, ::getColorName))
    }
    val effects = buildList {
        if (exp.hasTrail) add(TRAIL.withStyle(config.trailColor.get()))
        if (exp.hasTwinkle) add(TWINKLE.withStyle(config.twinkleColor.get()))
    }
    if (effects.isNotEmpty()) {
        consumer.accept(appendList(indentedPrimary(EFFECTS), effects))
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
        text = if (config.customColorsAsHex) hexText(idx) else text(CUSTOM_COLOR_NAME)
    }

    return if (config.colorEntriesUseCustomColors)
        text.withColor(color)
    else
        text.withStyle(config.colorEntryColor.get())
}