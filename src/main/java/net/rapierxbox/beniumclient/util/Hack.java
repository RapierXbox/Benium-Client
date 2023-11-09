package net.rapierxbox.beniumclient.util;

import net.minecraft.client.MinecraftClient;

public class Hack {
    private final String name;

    private static boolean enabled;
    public Hack(String name)
    {
        this.name = name;
    }

    public static final boolean isEnabled()
    {
        return enabled;
    }

    public String getName() {return this.name;}

    public final void setEnabled(boolean enabled)
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

    public final String getEnabledString() {
        if (enabled) {
            return name + " enabled";
        } else {
            return name + " disabled";
        }
    }

    public final void toggle() {
        setEnabled(!enabled);
    }

    protected void onEnable()
    {

    }

    protected void onDisable()
    {

    }

    protected void tick(MinecraftClient client) {

    }
}
