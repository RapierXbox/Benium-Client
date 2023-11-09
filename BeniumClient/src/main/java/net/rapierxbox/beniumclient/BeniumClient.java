package net.rapierxbox.beniumclient;

import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.search.SearchManager;
import net.minecraft.client.util.InputUtil;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rapierxbox.beniumclient.util.Hacks;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.lwjgl.glfw.GLFW;
import static net.minecraft.server.command.CommandManager.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.net.URI;
import java.util.List;

public class BeniumClient implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	private static BeniumClient instance;
	public static List<String> hacks_string = new ArrayList();

	@Override
	public void onInitialize() {
		if (instance == null) instance = this;
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);
		Hacks.init();
		LOGGER.info("Benium Client!");
	}


	public void tick(MinecraftClient client) {
		client.getWindow().setTitle("Benium Client V1");
		client.updateWindowTitle();
		Hacks.tick(client);

	}

}
