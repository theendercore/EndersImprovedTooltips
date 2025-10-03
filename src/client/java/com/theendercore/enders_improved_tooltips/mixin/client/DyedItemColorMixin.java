package com.theendercore.enders_improved_tooltips.mixin.client;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.DyedItemColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static com.theendercore.enders_improved_tooltips.client.toolitp.MiscTooltipsKt.dyeTooltips;

@Mixin(DyedItemColor.class)
public class DyedItemColorMixin {
    @Shadow @Final private boolean showInTooltip;
    @Shadow
    @Final
    private int rgb;

    @Inject(method = "addToTooltip", at = @At("HEAD"), cancellable = true)
    private void run(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag, CallbackInfo ci) {
        if (showInTooltip) {
            dyeTooltips(rgb, consumer);
        }
        ci.cancel();
    }
}
