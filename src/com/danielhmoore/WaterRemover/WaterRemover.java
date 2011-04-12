package com.danielhmoore.WaterRemover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class WaterRemover extends JavaPlugin {
	public static final Logger log = Logger.getLogger("Minecraft");
	private final WaterRemoverBlockListener blockListener = new WaterRemoverBlockListener(this);
    public final HashMap<Player, ArrayList<Block>> WaterRemoverUsers = new HashMap<Player, ArrayList<Block>>();
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener,
				Event.Priority.Normal, this);
		log.info("WaterRemover STARTED");
	}

	public void onDisable() {
		log.info("WaterRemover DISABLED");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("WR")){
			toggleWaterRemover((Player) sender);
			log.info("GETTINGdfsdfsa HERE");
			return true;
		}
		return false;
	}
	public void toggleWaterRemover(Player player){
		if(enabled(player)){
			this.WaterRemoverUsers.remove(player);
			player.sendMessage("WaterRemover Disabled");
		}else{
			this.WaterRemoverUsers.put(player, null);
			player.sendMessage("WaterRemover Enabled");
		}
	}
	public boolean enabled(Player player){
		return this.WaterRemoverUsers.containsKey(player);
	}
}
