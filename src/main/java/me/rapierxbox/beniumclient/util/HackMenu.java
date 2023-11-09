package me.rapierxbox.beniumclient.util;

import me.rapierxbox.beniumclient.BeniumClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

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
        this.addDrawableChild(new ButtonWidget.Builder(Text.of("Back"), btn -> this.client.setScreen(parent)).dimensions(10, 10, 40, 20).build());

        // 36 hacks per page

        for(int i = 0; i < 36; i++) {
            if (i >= BeniumClient.hacks.hacks.size()) {break;}
            Hack hack = BeniumClient.hacks.hacks.get(i);
            this.addDrawableChild(new ButtonWidget.Builder(Text.of(hack.getEnabledString()), btn -> hack.toggle()).dimensions((int) (60 + Math.ceil((i + 1) / 8) * 130), (int) (i * 30 - 20 - 200 * (Math.ceil((i + 1) / 8)) - 1), 120, 20).build());
            BeniumClient.LOGGER.info(String.valueOf((i * 30 - 20 - (200 * (Math.ceil((i + 1) / 8)) - 1))));
        }
    }
}
