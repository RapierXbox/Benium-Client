package me.rapierxbox.beniumclient.hacks;

import me.rapierxbox.beniumclient.util.Hack;
import net.minecraft.client.MinecraftClient;

public class Fullbright extends Hack {
    public Fullbright () {
        super("Fullbright");
    }

    public double startGamma = 1;

    @Override
    public void onEnable()
    {
        startGamma = MinecraftClient.getInstance().options.getGamma().getValue();
        MinecraftClient.getInstance().options.getGamma().setValue(16D);
    }

    @Override
    public void onDisable() {
        MinecraftClient.getInstance().options.getGamma().setValue(startGamma);
    }

}
