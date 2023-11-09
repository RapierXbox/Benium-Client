package net.rapierxbox.beniumclient.util;

import net.minecraft.util.math.Vec3d;

public class BMath {
    public static double getdistance(Vec3d p1, Vec3d p2) {
        return java.lang.Math.sqrt(java.lang.Math.pow(p1.x - p2.x, 2)
                + java.lang.Math.pow(p1.y - p2.y, 2)
                + java.lang.Math.pow(p1.z - p2.z, 2));
    }
}
