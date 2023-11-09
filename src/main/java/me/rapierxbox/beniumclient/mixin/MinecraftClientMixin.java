package me.rapierxbox.beniumclient.mixin;

import me.rapierxbox.beniumclient.BeniumClient;
import me.rapierxbox.beniumclient.hacks.ESP;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Inject(method = "hasOutline", at = @At("HEAD"), cancellable = true)
    private void outlineEntities(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (BeniumClient.hacks.hacks_map.get(ESP.class).isEnabled()) ci.setReturnValue(true);
    }
}
