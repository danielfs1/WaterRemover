package com.danielhmoore.WaterRemover;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

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
	public void onBlockFlow(BlockFromToEvent event)
	{
		Block block = event.getBlock();
		
		WaterRemover.log.info("HERE");
		
		if(block.getType() == Material.DIRT)
		{
			block.setType(Material.AIR);
			WaterRemover.log.info("Destroyed Water");
		}
	}
	public void onBlockDamage(BlockDamageEvent event)
	{
		Block block = event.getBlock();
		
		WaterRemover.log.info("HERE" + block.getType());
		
		if(block.getType() == Material.DIRT)
		{
			block.setType(Material.AIR);
			WaterRemover.log.info("Destroyed Water");
		}
	}
}