package me.TraiUnity;

import org.bukkit.entity.Player;

public class PlayerCPS {

	private int leftCPS = 0;
	private int rightCPS = 0;
	private Player player;
	  
	public PlayerCPS(Player player){
		this.player = player;
	}
	  
	public void addLeft(){
		leftCPS += 1;
	}
	  
	public void addRight(){
		rightCPS += 1;
	}
	  
	public void clearClicks(){
	    rightCPS = 0;
	    leftCPS = 0;
	}
	  
	public Player getPlayer(){
	    return player;
	}
	  
	public int getLeft(){
		return this.leftCPS;
	}
	  
	public int getRight(){
		return this.rightCPS;
	}
}
