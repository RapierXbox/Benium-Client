package net.rapierxbox.beniumclient.hacks;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.rapierxbox.beniumclient.util.Hack;

import java.util.Objects;

public class Jesus extends Hack {

    public Jesus() {
        super("Jesus");
    }

    @Override
    protected void tick(MinecraftClient client) {
        BlockState blockunderplayer = client.world.getBlockState(new BlockPos(new Vec3d(client.player.getX(), client.player.getY() - 0.2, client.player.getZ())));
        if(Objects.equals(blockunderplayer.getBlock().toString(), "Block{minecraft:water}")) {
            Vec3d velocity = client.player.getVelocity();
            if (velocity.y <= 0) client.player.setVelocity(velocity.x, 0.0, velocity.z);
        }
        if(Objects.equals(blockunderplayer.getBlock().toString(), "Block{minecraft:lava}")) {
            Vec3d velocity = client.player.getVelocity();
            if (velocity.y <= 0) client.player.setVelocity(velocity.x, 0.0, velocity.z);
        }

    }
}
