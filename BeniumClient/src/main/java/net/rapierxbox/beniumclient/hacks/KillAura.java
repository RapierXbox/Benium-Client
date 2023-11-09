package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.rapierxbox.beniumclient.util.Hack;
import net.rapierxbox.beniumclient.util.BUtil;

import java.util.Random;

public class KillAura extends Hack {
    public KillAura() {
        super("KillAura");
    }

    private Entity target;
    private static int cooldown = 5;

    @Override
    protected void tick(MinecraftClient client) {
        if (BUtil.getNearestEntity(client) != null && cooldown <= 0) {
            Random random = new Random();
            Entity target = BUtil.getNearestEntity(client);
            client.interactionManager.attackEntity(client.player, target);
            client.player.swingHand(Hand.MAIN_HAND);
            cooldown = 4 + random.nextInt(2);
        }
        if (cooldown > 0) cooldown--;


    }
}
