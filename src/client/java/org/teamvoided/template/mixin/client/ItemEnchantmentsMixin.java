package org.teamvoided.template.mixin.client;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static org.teamvoided.template.client.toolitp.EnchantmentTooltipKt.enchantmentTooltips;

@Mixin(ItemEnchantments.class)
public class ItemEnchantmentsMixin {
    @Shadow @Final boolean showInTooltip;
    @Shadow @Final Object2IntOpenHashMap<Holder<Enchantment>> enchantments;

    @Inject(method = "addToTooltip", at = @At("HEAD"), cancellable = true)
    private void run(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag, CallbackInfo ci) {
        if (showInTooltip) {
            enchantmentTooltips(enchantments,tooltipContext, consumer, tooltipFlag);
        }
        ci.cancel();
    }
}
