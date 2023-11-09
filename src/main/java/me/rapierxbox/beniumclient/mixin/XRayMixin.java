package me.rapierxbox.beniumclient.mixin;

import me.rapierxbox.beniumclient.BeniumClient;
import me.rapierxbox.beniumclient.hacks.XRay;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class XRayMixin {

    @Inject(at = @At("RETURN"), method = "shouldDrawSide", cancellable = true)
    private static void shouldDrawSide(BlockState state, BlockView reader, BlockPos pos, Direction face,
                                       BlockPos blockPos, CallbackInfoReturnable<Boolean> ci) {
        if(BeniumClient.hacks.hacks_map.get(XRay.class).isEnabled()) {
            XRay xray = (XRay) BeniumClient.hacks.hacks_map.get(XRay.class);
            ci.setReturnValue(xray.showBlock(state));
        }
    }
}
