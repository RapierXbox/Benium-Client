package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.rapierxbox.beniumclient.BeniumClient;
import net.rapierxbox.beniumclient.util.BUtil;
import net.rapierxbox.beniumclient.util.Hack;
import net.rapierxbox.beniumclient.util.Raycast;

public class PacketReach extends Hack {
    public PacketReach() {
        super("PacketReach");
    }

    @Override
    protected void tick(MinecraftClient client) {
        if (client.options.attackKey.wasPressed()) {
            client.player.sendMessage(Text.of("Attack"));
            attack(client, getTarget(client));
        }

    }

    public static Entity getTarget (MinecraftClient client) {
        Vec3d cameraDirection = client.cameraEntity.getRotationVector();

        HitResult hit = Raycast.raycastInDirection(client, cameraDirection);

        HitResult.Type hittype = hit.getType();
        BeniumClient.LOGGER.info("Type=" + hittype.toString());
        if (hittype == HitResult.Type.MISS) {
            BeniumClient.LOGGER.info("Nothing found :(");
            return null;
        } else if (hittype == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;
            BlockPos blockPos = blockHit.getBlockPos();
            BeniumClient.LOGGER.info("Block found :|");
            return BUtil.getNearestEntity(client, blockPos);
        } else if (hittype == HitResult.Type.ENTITY) {
            EntityHitResult entityHit = (EntityHitResult) hit;
            BeniumClient.LOGGER.info("Entity found :))))");
            return entityHit.getEntity();
        }
        return null;

    }

    public static void attack(MinecraftClient client, Entity target) {
        if (target == null) return;
        final Vec3d start_pos = new Vec3d(client.player.getX(), client.player.getY(), client.player.getZ());
        final Vec3d target_pos = target.getPos();
        teleport(client, target_pos);
        client.getNetworkHandler().getConnection().send(PlayerInteractEntityC2SPacket.attack(target, false));
        teleport(client, start_pos);
    }

    public static void teleport(MinecraftClient client, Vec3d pos) {
        for (int i = 0; i < 8; i++) {
            client.getNetworkHandler().getConnection().send(new PlayerMoveC2SPacket.PositionAndOnGround(client.player.getX(), client.player.getY(), client.player.getZ(), true));
        }
        client.getNetworkHandler().getConnection().send(new PlayerMoveC2SPacket.PositionAndOnGround(pos.getX(), pos.getY(), pos.getZ(), true));
    }
}
