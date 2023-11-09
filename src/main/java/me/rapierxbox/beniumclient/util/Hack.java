package me.rapierxbox.beniumclient.util;

import net.minecraft.client.MinecraftClient;

public class Hack {
    private final String name;


    private boolean enabled;
    public Hack(String name)
    {
        this.name = name;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public String getName() {return this.name;}

    public void setEnabled(boolean enabled)
    {
        if (this.enabled == enabled){
            return;
        }
        this.enabled = enabled;

        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public String getEnabledString() {
        if (enabled) {
            return name + " enabled";
        } else {
            return name + " disabled";
        }
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void onEnable()
    {

    }

    public void onDisable()
    {

    }

    public void tick(MinecraftClient client) {

    }
}
