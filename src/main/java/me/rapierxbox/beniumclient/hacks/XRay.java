package me.rapierxbox.beniumclient.hacks;

import me.rapierxbox.beniumclient.util.Hack;
import net.minecraft.block.BlockState;

import java.util.HashSet;
import java.util.Map;

public class XRay extends Hack {

    private static HashSet<String> xrayBlocks = new HashSet();
    private Map map;


    public XRay() {
        super("XRay");
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

    public boolean showBlock(BlockState state) {
        if(xrayBlocks.contains(state.getBlock().toString())) {
            return true;
        }
        return false;
    }


}
