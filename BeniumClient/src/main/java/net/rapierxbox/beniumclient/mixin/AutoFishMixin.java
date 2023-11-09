package net.rapierxbox.beniumclient.mixin;

import net.rapierxbox.beniumclient.BeniumClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import net.rapierxbox.beniumclient.hacks.AutoFish;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public class AutoFishMixin {

    @Shadow private boolean caughtFish;

    @Inject(method = "onTrackedDataSet", at = @At("TAIL") )
    public void onTrackedDataSet(TrackedData<?> data, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (caughtFish && AutoFish.isEnabled()) {
            AutoFish.recastRod = 20;
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
        }
    }


}
