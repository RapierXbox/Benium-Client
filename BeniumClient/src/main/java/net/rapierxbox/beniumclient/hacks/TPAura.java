package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.Hand;
import net.rapierxbox.beniumclient.util.BUtil;
import net.rapierxbox.beniumclient.util.Hack;

import java.util.Random;

public class TPAura extends Hack {
    public TPAura(String name) {
        super(name);
    }
    private static int cooldown = 5;

    protected void tick(MinecraftClient client) {
        if (BUtil.getNearestEntity(client) != null && cooldown <= 0) {
            Random random = new Random();
            Entity target = BUtil.getNearestEntity(client);
            client.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(target.getX() + random.nextDouble(4.0) - 2.0, target.getY(), target.getZ() + random.nextDouble(4.0) - 2.0, true));
            client.interactionManager.attackEntity(client.player, target);
            client.player.swingHand(Hand.MAIN_HAND);
            cooldown = 4 + random.nextInt(2);
        }
        if (cooldown > 0) cooldown--;
    }
}
