package me.TraiUnity.Secrets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

import me.TraiUnity.MySQL;

public class Secret {
	
	public static void setSecretTables(){
		MySQL.Update("CREATE TABLE IF NOT EXISTS Secret (location varchar(999), owner varchar(32))");
		MySQL.Update("CREATE TABLE IF NOT EXISTS SecretFound (UUID varchar(64), location varchar(999))");
	}
	
	public static void addLocation(Location loc){
		if(!secretExists(loc)) MySQL.Update("INSERT INTO Secret (location, owner) VALUES ('" + loc.toString() + "', '');");
	}
	
	public static void addFoundSecret(String uuid, Location loc){
		if(!playerExists(uuid)) MySQL.Update("INSERT INTO SecretFound (UUID, location) VALUES ('" + uuid + "', '" + loc.toString() + "');");
	}
	
	public static void removeLocation(Location loc){
		if(secretExists(loc)){
			MySQL.Update("DELETE FROM Secret WHERE location='"+loc.toString()+"'");
			MySQL.Update("DELETE FROM SecretFound WHERE location='"+loc.toString()+"'");
		}
	}
	
	public static void setSecretOwner(String ownername, Location loc) {
		if(secretExists(loc)) MySQL.Update("UPDATE Secret SET owner='" + ownername + "' WHERE location='" + loc.toString() + "'");
	}
	
	public static String getSecretOwner(Location loc) {
		try {
			PreparedStatement State = MySQL.c.prepareStatement("SELECT * FROM Secret WHERE location='"+loc.toString()+"';");
			
			ResultSet Result = State.executeQuery();
			Result.next();
			
			String s = Result.getString("owner");
			
			Result.close();
			State.close();
			
			return s;
		} catch (SQLException e) {}
		
		return "MHF_Question";
	}
	
	public static List<Block> getFoundedSecrets(String uuid) {
		try {
			PreparedStatement State = MySQL.c.prepareStatement("SELECT * FROM SecretFound WHERE UUID='"+uuid+"';");
			
			ResultSet Result = State.executeQuery();
			
			List<Block> list = new ArrayList<>();
			while(Result.next()){
				String[] s = Result.getString("location").replaceAll("Location", "").replaceAll("}", "").replaceAll("world=CraftWorld", "")
				.replaceAll("name=", "").replaceAll("x=", "").replaceAll("y=", "").replaceAll("z=", "").replaceAll(".0", "").split(",");
				String W = s[0].substring(2);
				int X = Integer.parseInt(s[1]);
				int Y = Integer.parseInt(s[2]);
				int Z = Integer.parseInt(s[3]);
				list.add(Bukkit.getWorld(W).getBlockAt(X, Y, Z));
			}
			
			Result.close();
			State.close();
			
			return list;
		} catch (SQLException e) {}
		
		return new ArrayList<>();
	}
	
	public static boolean secretExists(Location loc) {
	    try {
	        PreparedStatement State = MySQL.c.prepareStatement("SELECT * FROM Secret WHERE location='"+loc.toString()+"'");
	        
	        ResultSet Result = State.executeQuery();
	        
	        boolean Contains = Result.next();
	        
	        State.close();
	        Result.close();
	        
	        return Contains;
	    } catch (Exception e) {}
	    return false;
	}
	
	public static boolean playerExists(String uuid) {
	    try {
	        PreparedStatement State = MySQL.c.prepareStatement("SELECT * FROM SecretFound WHERE UUID='"+uuid+"'");
	        
	        ResultSet Result = State.executeQuery();
	        boolean Contains = Result.next();
	        
	        State.close();
	        Result.close();
	        
	        return Contains;
	    } catch (Exception e) {}
	    return false;
	}
	
	public static boolean playerHasFoundSecret(String uuid, Location loc) {
	    try {
	        PreparedStatement State = MySQL.c.prepareStatement("SELECT * FROM SecretFound WHERE UUID='"+uuid+"'");
	        
	        ResultSet Result = State.executeQuery();
	        
	        boolean Contains = false;
	        while(Result.next()){
	        	if(Result.getString("location").equals(loc.toString())) Contains = true;
	        }
	        
	        State.close();
	        Result.close();
	        
	        return Contains;
	    } catch (Exception e) {}
	    return false;
	}
}
