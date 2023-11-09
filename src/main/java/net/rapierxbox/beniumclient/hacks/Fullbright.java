package net.rapierxbox.beniumclient.hacks;

import net.minecraft.client.MinecraftClient;
import net.rapierxbox.beniumclient.util.Hack;

public class Fullbright extends Hack {
    public Fullbright () {
        super("Fullbright");
    }

    public static double startGamma = 1;

    @Override
    protected void onEnable(){
        startGamma = MinecraftClient.getInstance().options.getGamma().getValue();
        MinecraftClient.getInstance().options.getGamma().setValue(16D);
    }

    @Override
    protected void onDisable() {
        MinecraftClient.getInstance().options.getGamma().setValue(startGamma);
    }

}
