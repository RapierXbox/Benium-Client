package net.rapierxbox.beniumclient.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.rapierxbox.beniumclient.BeniumClient;

public class HackMenu extends Screen {
    private final Screen parent;
    private final MinecraftClient client;
    public int offset = 0;


    public HackMenu(Screen parent, MinecraftClient a_client, int offset) {
        super(Text.literal("Benium Client V1"));
        this.parent = parent;
        this.client = a_client;
        this.offset = offset;
    }

    protected void update() {
        this.client.setScreen(new HackMenu(this.parent, this.client, offset));
    }

    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 25,  10, 50 , 20,
                Text.literal("Back"), (button) -> {
            this.client.setScreen(this.parent);
        }));
    }
}
