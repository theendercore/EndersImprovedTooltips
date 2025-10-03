package org.teamvoided.template.mixin.client;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.component.FireworkExplosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static org.teamvoided.template.client.toolitp.FireworkTooltipKt.additionalTooltip;
import static org.teamvoided.template.client.toolitp.FireworkTooltipKt.shapeTooltip;

@Mixin(FireworkExplosion.class)
public class FireworkExplosionMixin {

    @Inject(method = "addShapeNameTooltip", at = @At("HEAD"), cancellable = true)
    private void run2(Consumer<Component> consumer, CallbackInfo ci) {
        shapeTooltip((FireworkExplosion) (Object) this, consumer);
        ci.cancel();
    }
    @Inject(method = "addAdditionalTooltip", at = @At("HEAD"), cancellable = true)
    private void run(Consumer<Component> consumer, CallbackInfo ci) {
        additionalTooltip((FireworkExplosion) (Object) this, consumer);
        ci.cancel();
    }
}
