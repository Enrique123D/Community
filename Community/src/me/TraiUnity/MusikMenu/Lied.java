package me.TraiUnity.MusikMenu;

import org.bukkit.Material;

import com.xxmicloxx.NoteBlockAPI.Song;

public class Lied {
	private Song s;
	private String name;
	private String interpret;
	private String l�nge;
	private Material mat;

	public Lied(Song s, String name, String interpret, String l�nge, Material mat) {
		this.s = s;
		this.name = name;
		this.interpret = interpret;
		this.l�nge = l�nge;
		this.mat = mat;
	}

	public Song getSong() {
		return s;
	}
	
	public String getName(){
		return name;
	}

	public String getInterpret() {
		return interpret;
	}

	public String getL�nge() {
		return l�nge;
	}
	
	public Material getMaterial(){
		return mat;
	}
}
