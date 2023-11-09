package me.rapierxbox.beniumclient;

import me.rapierxbox.beniumclient.util.Hacks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class BeniumClient implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("beniumclient");
	public static Hacks hacks = new Hacks();

	@Override
	public void onInitialize() {
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);
		LOGGER.info("Benium Client!");
	}


	public void tick(MinecraftClient client) {
		client.getWindow().setTitle("Benium Client V1");
		client.updateWindowTitle();
		hacks.tick(client);

	}

}
