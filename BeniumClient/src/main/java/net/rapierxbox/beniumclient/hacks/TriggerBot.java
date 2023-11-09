package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.rapierxbox.beniumclient.util.Hack;

import java.util.Random;

public class TriggerBot extends Hack {
    private static int cooldown = 4;
    private static Random rand = new Random();

    public TriggerBot() {
        super("TriggerBot");
    }

    @Override
    protected void tick(MinecraftClient client) {
        if (!isEnabled()) return;
        if (cooldown == 0) {
            HitResult hit = client.crosshairTarget;
            Entity entity = null;

            if (hit.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHit = (EntityHitResult) hit;
                entity = entityHit.getEntity();
                if (entity != null) client.player.networkHandler.sendPacket(PlayerInteractEntityC2SPacket.attack(entity, client.player.isSneaking()));
                client.player.swingHand(Hand.MAIN_HAND);
                cooldown = rand.nextInt(3) + 2;
            }
        }
        if (cooldown > 0) cooldown--;
    }
}
