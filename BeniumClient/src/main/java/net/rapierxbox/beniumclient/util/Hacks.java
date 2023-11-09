package net.rapierxbox.beniumclient.util;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.client.MinecraftClient;
import net.rapierxbox.beniumclient.BeniumClient;
import net.rapierxbox.beniumclient.hacks.*;

import java.util.ArrayList;
import java.util.List;

public class Hacks {
    public static List<Hack> hacks = new ArrayList<>();

    public static void init() {
        hacks.add(new AutoFish());
        hacks.add(new ESP());
        hacks.add(new Fly());
        hacks.add(new KillAura());
        hacks.add(new NoFall());
        hacks.add(new TriggerBot());
        hacks.add(new XRay());
        hacks.add(new Fullbright());
        hacks.add(new PacketReach());
        hacks.add(new Jesus());
        hacks.add(new TriggerBot());
    }

     public static void tick(MinecraftClient client) {
        for (int i = 0; i < hacks.size(); i++)
            try {
                hacks.get(i).tick(client);
            } catch (Exception e) {
                BeniumClient.LOGGER.warn(String.format("Error in module %s while trying to tick: %s", hacks.get(i).getName(), e));
            }
     }
}
