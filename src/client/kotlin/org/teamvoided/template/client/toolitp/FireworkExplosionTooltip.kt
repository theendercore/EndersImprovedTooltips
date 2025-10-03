package org.teamvoided.template.client.toolitp

import it.unimi.dsi.fastutil.ints.IntList
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.CommonComponents
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.world.item.DyeColor
import net.minecraft.world.item.component.FireworkExplosion
import java.util.function.Consumer

fun fireworkExplosionTooltip(fireworkExplosion: FireworkExplosion, consumer: Consumer<Component>) {
    consumer.accept(
        Component.translatable(SHAPE).withStyle(ChatFormatting.GRAY)
            .append(fireworkExplosion.shape.getName().withStyle(ChatFormatting.GOLD))
    )

    if (!fireworkExplosion.colors.isEmpty()) consumer.accept(
        Component.translatable(COLORS).withStyle(ChatFormatting.GRAY).append(
            appendColors(
                Component.empty().withStyle(ChatFormatting.GRAY),
                fireworkExplosion.colors
            )
        )
    )

    if (!fireworkExplosion.fadeColors.isEmpty()) {
        consumer.accept(
            appendColors(
                Component.translatable("item.minecraft.firework_star.fade_to").append(CommonComponents.SPACE)
                    .withStyle(ChatFormatting.GRAY), fireworkExplosion.fadeColors
            )
        )
    }

    val effects = mutableListOf<Component>()
    if (fireworkExplosion.hasTrail) {
        effects.add(Component.translatable("item.minecraft.firework_star.trail").withStyle(ChatFormatting.AQUA))
    }

    if (fireworkExplosion.hasTwinkle) {
        effects.add(Component.translatable("item.minecraft.firework_star.flicker").withStyle(ChatFormatting.YELLOW))
    }
    if (effects.isNotEmpty()) {
        val effect = Component.translatable(EFFECTS).withStyle(ChatFormatting.GRAY)
        for (i in effects.indices) {
            if (i > 0) effect.append(", ")
            effect.append(effects[i])
        }

        consumer.accept(effect)
    }
}

fun appendColors(component: MutableComponent, intList: IntList): Component {
    component.append("[ ")
    for (i in intList.indices) {
        if (i > 0) component.append(", ")
        component.append(getColorName(intList.getInt(i)))
    }

    return component.append(" ]")
}

val CUSTOM_COLOR_NAME: MutableComponent = Component.translatable("item.minecraft.firework_star.custom_color")
fun getColorName(i: Int): MutableComponent {
    val dyeColor = DyeColor.byFireworkColor(i)
        ?.let { Component.translatable("item.minecraft.firework_star.${it.getName()}").withColor(it.fireworkColor) }

    return dyeColor ?: CUSTOM_COLOR_NAME
}