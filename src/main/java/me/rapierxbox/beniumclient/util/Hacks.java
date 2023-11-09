package me.rapierxbox.beniumclient.util;

import me.rapierxbox.beniumclient.BeniumClient;
import me.rapierxbox.beniumclient.hacks.*;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hacks {
    public Map<Class<? extends Hack>, Hack> hacks_map = new HashMap<>();
    public ArrayList<Hack> hacks = new ArrayList<Hack>();

    public Hacks() {
        add(ESP.class, new ESP());
        add(Fly.class, new Fly());
        add(KillAura.class, new KillAura());
        add(NoFall.class, new NoFall());
        add(TriggerBot.class, new TriggerBot());
        add(XRay.class, new XRay());
        add(Fullbright.class, new Fullbright());
        add(PacketReach.class, new PacketReach());
        add(Jesus.class, new Jesus());
        add(TPAura.class, new TPAura());
    }

    public void add(Class<? extends Hack> class_, Hack hack_) {
        hacks_map.put(class_, hack_);
        hacks.add(hack_);
    }

     public void tick(MinecraftClient client) {
        for (Hack hack : hacks) {
            if (hack.isEnabled()) {
                try {
                    hack.tick(client);
                } catch (Exception e) {
                    BeniumClient.LOGGER.warn(String.format("Error in module %s while trying to tick: %s", hack.getName(), e));
                }
            }
        }
     }

     public List<String> getHudString() {
        List<String> value = new ArrayList<>();
        value.add("Benium Client V1");
        for (Hack hack : hacks) {
            if (hack.isEnabled()) {
                value.add("-" + hack.getName());
            }
        }
        return value;
     }
}
