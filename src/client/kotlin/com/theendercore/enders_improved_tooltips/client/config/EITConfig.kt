package com.theendercore.enders_improved_tooltips.client.config

import me.fzzyhmstrs.fzzy_config.config.Config
import me.fzzyhmstrs.fzzy_config.config.ConfigGroup
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedEnum
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt
import net.minecraft.ChatFormatting
import com.theendercore.enders_improved_tooltips.EndersImprovedTooltips.MODID
import com.theendercore.enders_improved_tooltips.EndersImprovedTooltips.id

class EITConfig : Config(id(MODID)) {
    var indentSpaces = ValidatedInt(2, 0..16)
    var primaryTooltipColor = ValidatedEnum(ChatFormatting.GRAY)

    @Suppress("unused")
    var enchantments = ConfigGroup("enchantments", true)
    var enchantmentColor = ValidatedEnum(ChatFormatting.GREEN)
    var maxLevelColor = ValidatedEnum(ChatFormatting.GOLD)
    var aboveMaxLevelColor = ValidatedEnum(ChatFormatting.YELLOW)

    @ConfigGroup.Pop
    var curseColor = ValidatedEnum(ChatFormatting.RED)

    @Suppress("unused")
    var fireworks = ConfigGroup("fireworks", true)
    var shapeColor = ValidatedEnum(ChatFormatting.GOLD)
    var colorEntriesUseCustomColors = true
    var colorEntryColor = ValidatedEnum(ChatFormatting.GREEN)
    var twinkleColor = ValidatedEnum(ChatFormatting.YELLOW)
    var trailColor = ValidatedEnum(ChatFormatting.YELLOW)


    @ConfigGroup.Pop
    var customColorsAsHex = true

    @Suppress("unused")
    var jukeboxPlayable = ConfigGroup("jukebox_playable", true)
    var titleColor = ValidatedEnum(ChatFormatting.GOLD)
    var authorColor = ValidatedEnum(ChatFormatting.YELLOW)
    var comparatorOutputColor = ValidatedEnum(ChatFormatting.RED)
    var songLengthColor = ValidatedEnum(ChatFormatting.GREEN)

    @ConfigGroup.Pop
    var extraInfoRequiresShift = true

}