package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.rapierxbox.beniumclient.util.Hack;

public class NoFall extends Hack {

    public NoFall() {
        super("NoFall");
    }

    @Override
    protected void tick(MinecraftClient client) {
        if (!isEnabled()) return;
        ClientPlayerEntity player = client.player;
        if(player.fallDistance <= (player.isFallFlying() ? 1 : 2))
            return;

        if(player.isFallFlying() && player.isSneaking()
                && player.getVelocity().y >= -0.5)
            return;

        player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
    }
}
