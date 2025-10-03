package com.theendercore.enders_improved_tooltips.mixin.client;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static com.theendercore.enders_improved_tooltips.client.toolitp.MiscTooltipsKt.discTooltips;

@Mixin(JukeboxPlayable.class)
public class JukeboxPlayableMixin {

    @Shadow
    @Final
    private boolean showInTooltip;

    @Inject(method = "addToTooltip", at = @At("HEAD"), cancellable = true)
    private void run2(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag, CallbackInfo ci) {
        if (this.showInTooltip) {
            discTooltips((JukeboxPlayable) (Object) this, tooltipContext, consumer);
        }
        ci.cancel();
    }
}
