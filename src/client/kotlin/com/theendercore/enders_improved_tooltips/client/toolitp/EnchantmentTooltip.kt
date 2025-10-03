package com.theendercore.enders_improved_tooltips.client.toolitp

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap
import net.minecraft.core.Holder
import net.minecraft.core.HolderLookup
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.CommonComponents
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.ComponentUtils
import net.minecraft.network.chat.Style
import net.minecraft.tags.EnchantmentTags
import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantment
import com.theendercore.enders_improved_tooltips.client.EndersImprovedTooltipsClient.config
import com.theendercore.enders_improved_tooltips.client.utils.ENCHANTMENTS
import com.theendercore.enders_improved_tooltips.client.utils.indentedText
import com.theendercore.enders_improved_tooltips.client.utils.primaryText
import java.util.function.Consumer

fun enchantmentTooltips(
    enchants: Object2IntOpenHashMap<Holder<Enchantment>>, ctx: Item.TooltipContext, c: Consumer<Component>,
) {
    if (enchants.isEmpty()) return

    val holderSet = getTooltipOrder(ctx.registries())
    c.accept(primaryText(ENCHANTMENTS))
    for (holder in holderSet) {
        val level = enchants.getInt(holder)
        if (level > 0) {
            c.accept(getFullName(holder, level))
        }
    }

    for ((key, level) in enchants.object2IntEntrySet()) {
        if (!holderSet.contains(key)) {
            c.accept(getFullName(key, level))
        }
    }
}

fun getTooltipOrder(provider: HolderLookup.Provider?): HolderSet<Enchantment> {
    if (provider != null) {
        val optional = provider.lookupOrThrow(Registries.ENCHANTMENT).get(EnchantmentTags.TOOLTIP_ORDER)
        if (optional.isPresent) return optional.get()
    }
    return HolderSet.direct()
}

fun getFullName(holder: Holder<Enchantment>, level: Int): Component {
    val enchantment = indentedText(holder.value().description.copy())
    val isMaxLevel = holder.value().maxLevel <= level

    val color =
        if (holder.`is`(EnchantmentTags.CURSE)) config.curseColor
        else if (isMaxLevel) config.maxLevelColor
        else config.enchantmentColor

    ComponentUtils.mergeStyles(enchantment, Style.EMPTY.withColor(color.get()))

    if (level != 1 || holder.value().maxLevel != 1) {
        var levelText = Component.translatable("enchantment.level.$level")
        if (level > holder.value().maxLevel) {
            levelText = levelText.withStyle(config.aboveMaxLevelColor.get())
        }
        enchantment.append(CommonComponents.SPACE).append(levelText)
    }

    return enchantment
}

