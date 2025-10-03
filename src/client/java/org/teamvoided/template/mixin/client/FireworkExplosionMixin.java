package org.teamvoided.template.mixin.client;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.FireworkExplosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static org.teamvoided.template.client.toolitp.FireworkExplosionTooltipKt.fireworkExplosionTooltip;

@Mixin(FireworkExplosion.class)
public class FireworkExplosionMixin {

    @Inject(method = "addToTooltip", at = @At("HEAD"), cancellable = true)
    private void run(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag, CallbackInfo ci) {
        fireworkExplosionTooltip((FireworkExplosion) (Object) this, consumer);
        ci.cancel();
    }
}
