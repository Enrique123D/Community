package me.TraiUnity.Listener;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SetBoots {

	public static void setBoots(Player p){
				
	    ItemStack Boots1 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B1 = (LeatherArmorMeta)Boots1.getItemMeta();
	    B1.setColor(Color.LIME);
	    Boots1.setItemMeta(B1);
	   	p.getInventory().setBoots(Boots1);
	    
	    ItemStack Boots2 = new ItemStack(Material.GOLD_BOOTS); 
	    ItemMeta B2 = Boots2.getItemMeta();
	    Boots2.setItemMeta(B2);
	    if(p.hasPermission("Rangsystem.Premium")){
	    	p.getInventory().setBoots(Boots2);
	    }
	    
	    ItemStack Boots3 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B3 = (LeatherArmorMeta)Boots3.getItemMeta();
	    B3.setColor(Color.YELLOW);
	    Boots3.setItemMeta(B3);  
	    if(p.hasPermission("Rangsystem.Premium+")){
	   		p.getInventory().setBoots(Boots3);
	    }
	    
	    ItemStack Boots4 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B4 = (LeatherArmorMeta)Boots4.getItemMeta();
	    B4.setColor(Color.RED);
	    Boots4.setItemMeta(B4);  
	    if(p.hasPermission("Rangsystem.Freund")){
	   		p.getInventory().setBoots(Boots4);
	    }
	    
	    ItemStack Boots5 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B5 = (LeatherArmorMeta)Boots5.getItemMeta();
	    B5.setColor(Color.PURPLE);
	    Boots5.setItemMeta(B5);  
	    if(p.hasPermission("Rangsystem.Streamer") || p.hasPermission("Rangsystem.Youtuber")){
	   		p.getInventory().setBoots(Boots5);
	    }
	    
	    ItemStack Boots6 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B6 = (LeatherArmorMeta)Boots6.getItemMeta();
	    B6.setColor(Color.GREEN);
	    Boots6.setItemMeta(B6);  
	    if(p.hasPermission("Rangsystem.Builder")){
	   		p.getInventory().setBoots(Boots6);
	    }
	    
	    ItemStack Boots7 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B7 = (LeatherArmorMeta)Boots7.getItemMeta();
	    B7.setColor(Color.TEAL);
	    Boots7.setItemMeta(B7);  
	    if(p.hasPermission("Rangsystem.ProbeSupporter") || p.hasPermission("Rangsystem.Supporter")){
	   		p.getInventory().setBoots(Boots7);
	    }
	    
	    ItemStack Boots8 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B8 = (LeatherArmorMeta)Boots8.getItemMeta();
	    B8.setColor(Color.BLUE);
	    Boots8.setItemMeta(B8);  
	    if(p.hasPermission("Rangsystem.Moderator") || p.hasPermission("Rangsystem.SrModerator")){
	   		p.getInventory().setBoots(Boots8);
	    }
	    
	    ItemStack Boots9 = new ItemStack(Material.DIAMOND_BOOTS); 
	    ItemMeta B9 = Boots9.getItemMeta();
	    Boots9.setItemMeta(B9);
	    if(p.hasPermission("Rangsystem.Content") || p.hasPermission("Rangsystem.JrDeveloper") || p.hasPermission("Rangsystem.Developer")
	    		|| p.hasPermission("Rangsystem.SrDeveloper")){
	    	p.getInventory().setBoots(Boots9);
	    }
	    
	    ItemStack Boots10 = new ItemStack(Material.LEATHER_BOOTS); 
	    LeatherArmorMeta B10 = (LeatherArmorMeta)Boots10.getItemMeta();
	    B10.setColor(Color.MAROON);
	    Boots10.setItemMeta(B10);  
	    if(p.hasPermission("Rangsystem.Administrator") || p.hasPermission("Rangsystem.Owner")){
	   		p.getInventory().setBoots(Boots10);
	    }
	}
}
