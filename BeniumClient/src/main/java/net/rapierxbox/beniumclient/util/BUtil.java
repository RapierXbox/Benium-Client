package net.rapierxbox.beniumclient.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class BUtil {
    public static Entity getNearestEntity(MinecraftClient client) {
        Entity best_entity = null;
        Double best_dis = 6.0;

        for (Entity entity : client.world.getEntities()) {
            if (!entity.isPlayer() && entity.isAttackable() && entity.isAlive()) {
                if (BMath.getdistance(client.player.getPos(), entity.getPos()) < best_dis) {
                    best_entity = entity;
                    best_dis = BMath.getdistance(client.player.getPos(), entity.getPos());
                }
            }
        }
        return best_entity;
    }

    public static Entity getNearestEntity(MinecraftClient client, BlockPos pos) {
        Entity best_entity = null;
        Double best_dis = 5.0;

        for (Entity entity : client.world.getEntities()) {
            if (!entity.isPlayer() && entity.isAttackable() && entity.isAlive()) {
                if (BMath.getdistance(new Vec3d(pos.getX(), pos.getY(), pos.getZ()), entity.getPos()) < best_dis) {
                    best_entity = entity;
                    best_dis = BMath.getdistance(new Vec3d(pos.getX(), pos.getY(), pos.getZ()), entity.getPos());
                }
            }
        }
        return best_entity;
    }
}
