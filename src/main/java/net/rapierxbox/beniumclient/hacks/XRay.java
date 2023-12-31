package net.rapierxbox.beniumclient.hacks;

import net.minecraft.block.BlockState;
import net.rapierxbox.beniumclient.util.Hack;

import java.util.HashSet;

public class XRay extends Hack {

    private static HashSet<String> xrayBlocks = new HashSet();


    public XRay() {
        super("XRay");

    }

    @Override
    protected void onEnable() {
        xrayBlocks.clear();
        xrayBlocks.add("Block{minecraft:coal_ore}");
        xrayBlocks.add("Block{minecraft:iron_ore}");
        xrayBlocks.add("Block{minecraft:gold_ore}");
        xrayBlocks.add("Block{minecraft:diamond_ore}");
        xrayBlocks.add("Block{minecraft:emerald_ore}");
        xrayBlocks.add("Block{minecraft:lapis_ore}");
        xrayBlocks.add("Block{minecraft:redstone_ore}");
        xrayBlocks.add("Block{minecraft:coal_block}");
        xrayBlocks.add("Block{minecraft:iron_block}");
        xrayBlocks.add("Block{minecraft:gold_block}");
        xrayBlocks.add("Block{minecraft:diamond_block}");
        xrayBlocks.add("Block{minecraft:emerald_block}");
        xrayBlocks.add("Block{minecraft:lapis_block}");
        xrayBlocks.add("Block{minecraft:redstone_block}");
        xrayBlocks.add("Block{minecraft:deepslate_coal_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_iron_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_gold_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_diamond_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_emerald_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_lapis_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_redstone_ore}");
        xrayBlocks.add("Block{minecraft:chest}");
        xrayBlocks.add("Block{minecraft:mob_spawner}");
        xrayBlocks.add("Block{minecraft:bookshelf}");
        xrayBlocks.add("Block{minecraft:ancient_debris}");
        xrayBlocks.add("Block{minecraft:nether_gold_ore}");
        xrayBlocks.add("Block{minecraft:nether_quartz_ore}");
        xrayBlocks.add("Block{minecraft:glowstone}");
        xrayBlocks.add("Block{minecraft:lava}");
        xrayBlocks.add("Block{minecraft:obsidian}");
    }

    public static boolean showBlock(BlockState state) {
        if(xrayBlocks.contains(state.getBlock().toString())) {
            return true;
        }
        return false;
    }


}
