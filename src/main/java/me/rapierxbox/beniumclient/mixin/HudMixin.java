package me.rapierxbox.beniumclient.mixin;

import me.rapierxbox.beniumclient.BeniumClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class HudMixin {
    @Inject(at = @At("TAIL"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;F)V")
    private void render(MatrixStack matrices, float tickDelta, CallbackInfo info) {
        MinecraftClient client = MinecraftClient.getInstance();

        int yoffset = 5;
        for (String text : BeniumClient.hacks.getHudString()) {
            client.inGameHud.getTextRenderer().drawWithShadow(matrices, text, 5, yoffset, 0xffb600);
            yoffset += 10;
        }
    }
}
