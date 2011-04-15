package com.danielhmoore.WaterRemover;

import java.io.*;
import java.net.*;
import org.bukkit.Server;

public class socketServer {
	//public static void main(String[] args)
	public socketServer ()
	{
		try {
			ServerSocket socket = new ServerSocket(8550);
			Socket insocket = socket.accept();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(insocket.getInputStream()));
			
			PrintWriter out = new PrintWriter(insocket.getOutputStream(), true);
			
			Server s = org.bukkit.Bukkit.getServer();
			
			String instring = in.readLine();
			out.println("The server got this: " + instring + "ServerName: " + s.getMaxPlayers());
			insocket.close();
			
		}
		catch (Exception e) {}
	}
}
