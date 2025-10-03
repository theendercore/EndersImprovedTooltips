package org.teamvoided.template.client.config

import me.fzzyhmstrs.fzzy_config.config.Config
import me.fzzyhmstrs.fzzy_config.config.ConfigGroup
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedEnum
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt
import net.minecraft.ChatFormatting
import org.teamvoided.template.Template.MODID
import org.teamvoided.template.Template.id

class EITConfig : Config(id(MODID)) {
    var indentSpaces = ValidatedInt(2, 0..16)
    var primaryTooltipColor = ValidatedEnum(ChatFormatting.GRAY)

    @Suppress("unused")
    var enchantments = ConfigGroup("enchantments", false)

    var enchantmentColor = ValidatedEnum(ChatFormatting.GREEN)
    var maxLevelColor = ValidatedEnum(ChatFormatting.GOLD)
    var aboveMaxLevelColor = ValidatedEnum(ChatFormatting.YELLOW)

    @ConfigGroup.Pop
    var curseColor = ValidatedEnum(ChatFormatting.RED)

    @Suppress("unused")
    var fireworks = ConfigGroup("fireworks", false)

    var shapeColor = ValidatedEnum(ChatFormatting.GOLD)
    var colorEntriesUseCustomColors = true
    var colorEntryColor = ValidatedEnum(ChatFormatting.GREEN)
    var twinkleColor = ValidatedEnum(ChatFormatting.YELLOW)
    var trailColor = ValidatedEnum(ChatFormatting.YELLOW)


    @ConfigGroup.Pop
    var customColorsAsHex = true
}