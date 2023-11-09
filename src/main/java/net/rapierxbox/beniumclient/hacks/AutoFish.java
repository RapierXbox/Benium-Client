package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;
import net.rapierxbox.beniumclient.util.Hack;

public class AutoFish extends Hack {

    public static int recastRod = -1;

    public AutoFish() {
        super("AutoFish");
    }

    @Override
    protected void tick(MinecraftClient client) {
        if (!isEnabled()) return;
        if (recastRod > 0) {
            recastRod--;
        }
        if (recastRod==0) {
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            recastRod = -1;
        }
    }
}
