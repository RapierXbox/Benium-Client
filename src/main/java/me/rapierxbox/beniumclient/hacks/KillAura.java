package me.rapierxbox.beniumclient.hacks;

import me.rapierxbox.beniumclient.util.BUtil;
import me.rapierxbox.beniumclient.util.Hack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;


import java.util.Random;

public class KillAura extends Hack {
    public KillAura() {
        super("KillAura");
    }

    private Entity target;
    private int cooldown = 5;

    @Override
    public void tick(MinecraftClient client) {
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
