package com.danielhmoore.WaterRemover;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

public class WaterRemoverBlockListener extends BlockListener {
	public static WaterRemover plugin;

	public WaterRemoverBlockListener(WaterRemover instance) {
		plugin = instance;
	}
	public void onBlockBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		if(block.getType() == Material.TORCH && plugin.enabled(player)){
			player.sendMessage(ChatColor.RED + "You broke a torch.");
		}
	}
}