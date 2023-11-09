package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.rapierxbox.beniumclient.util.Hack;

public class Fly extends Hack {

    static int maxSpeed = 3;
    static double fallSpeed = -0.04;
    static double acceleration = 0.1;
    static int toggle = 0;

    public Fly() {
        super("Fly");
    }

    @Override
    protected void tick(MinecraftClient client) {
        if (!isEnabled()) {return;}
        if (client.player != null) {
            boolean jumpPressed = client.options.jumpKey.isPressed();
            boolean forwardPressed = client.options.forwardKey.isPressed();
            boolean backwardPressed = client.options.backKey.isPressed();
            boolean rightPressed = client.options.rightKey.isPressed();
            boolean leftPressed = client.options.leftKey.isPressed();

            Entity object = client.player;
            if(client.player.hasVehicle()) {object = client.player.getVehicle();}

            Vec3d velocity = object.getVelocity();
            Vec3d newVelocity = new Vec3d(velocity.x, -fallSpeed ,velocity.z);
            if(jumpPressed) {
                if(forwardPressed) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration);
                }
                if(leftPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(3.1415927F/ 2);
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }
                if(rightPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(-3.1415927F/ 2);
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }
                if(backwardPressed) {
                    newVelocity = client.player.getRotationVector().negate().multiply(acceleration);
                }

                newVelocity = new Vec3d(newVelocity.x, (toggle == 0 && newVelocity.y>fallSpeed) ? fallSpeed : newVelocity.y, newVelocity.z);
                object.setVelocity(newVelocity);

                if(forwardPressed || backwardPressed || rightPressed || leftPressed) {
                    if (acceleration<maxSpeed) {
                        acceleration += 0.1;
                    } else if (acceleration > 0.2) {
                        acceleration -= 0.2;
                    }
                }
            }
            if(toggle == 0 || newVelocity.y <= -0.04) {
                toggle = 40;
            }
            toggle--;
        }
    }
}
