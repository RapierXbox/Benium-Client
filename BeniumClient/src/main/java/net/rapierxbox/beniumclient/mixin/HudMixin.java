package net.rapierxbox.beniumclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.rapierxbox.beniumclient.BeniumClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class HudMixin {
    @Inject(at = @At("TAIL"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;F)V")
    private void render(MatrixStack matrices, float tickDelta, CallbackInfo info) {
        int x = 5;
        int offsety = 5;
        MinecraftClient client = MinecraftClient.getInstance();
        for (String enabled_hack : BeniumClient.hacks_string) {
            client.inGameHud.getTextRenderer().drawWithShadow(matrices, enabled_hack, x, offsety, 0xffb600);
            offsety += 10;
        }
    }
}
