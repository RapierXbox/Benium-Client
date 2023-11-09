package net.rapierxbox.beniumclient.mixin;

import net.rapierxbox.beniumclient.util.HackMenu;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text text) {super(text);}

    @Inject(method = "initWidgets", at = @At("HEAD"))
    void initWidgets(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(10, 10, 90, 20,
                Text.literal("Benium Client"), btn -> this.client.setScreen(new HackMenu(this, client, 0))));
    }
}
