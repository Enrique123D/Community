package me.TraiUnity.MusikMenu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.xxmicloxx.NoteBlockAPI.NBSDecoder;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

import me.TraiUnity.ItemBuilder1;

public class Music {
	
	public static HashMap<Integer, Lied> songs = new HashMap<>();
	
	public static Lied aktuelles_lied = null;
	public static SongPlayer aktueller_player = null;
	public static ArrayList<Lied> aktuelle_playlist = new ArrayList<>();
	public static boolean loop = false;
	public static boolean pause = false;
	
	public static void setSongs(){
		songs.put(0, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Faded.nbs")), "Faded", "Alan Walker", "3:48", Material.getMaterial(getSubID(0))));
		songs.put(1, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Alone.nbs")), "Alone", "Alan Walker", "2:44", Material.getMaterial(getSubID(1))));
		songs.put(2, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Spectre.nbs")), "Spectre", "Alan Walker", "3:27", Material.getMaterial(getSubID(2))));
		songs.put(3, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Tired.nbs")), "Tired", "Alan Walker", "3:37", Material.getMaterial(getSubID(3))));
		songs.put(4, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "He's_A_Pirate.nbs")), "He's A Pirate", "Klaus Badelt", "1:19", Material.getMaterial(getSubID(4))));
		songs.put(5, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Jingle_Bells.nbs")), "Jingle Bells", "Boney M.", "0:51", Material.getMaterial(getSubID(5))));
		songs.put(6, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Merry_Christmas.nbs")), "We wish you a merry Christmas", "Coccole Sonore", "0:39", Material.getMaterial(getSubID(6))));
		songs.put(7, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Tetris_A_Theme.nbs")), "Tetris A Theme", "Unbekannt", "1:17", Material.getMaterial(getSubID(7))));
		songs.put(8, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Tetris_B_Theme.nbs")), "Tetris B Theme", "Unbekannt", "1:46", Material.getMaterial(getSubID(8))));
		songs.put(9, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Pokemon_Center.nbs")), "Pokemon Center Theme", "Junichi Masuda", "0:57", Material.getMaterial(getSubID(9))));
		songs.put(10, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Freaks.nbs")), "Freaks", "Timmy Trumpet", "3:25", Material.getMaterial(getSubID(10))));
		songs.put(11, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Primo_Victoria.nbs")), "Primo Victoria", "Sabaton", "4:09", Material.getMaterial(getSubID(11))));
		songs.put(12, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Metal_Maghine.nbs")), "Metal Maghine", "Sabaton", "3:35", Material.getMaterial(getSubID(12))));
		songs.put(13, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "A_Kind_of_Magic.nbs")), "A Kind of Magic", "Higaphix", "3:55", Material.getMaterial(getSubID(13))));
		songs.put(14, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "All_Star.nbs")), "All Star", "Unbekannt", "2:46", Material.getMaterial(getSubID(14))));
		songs.put(15, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Call_Me_Maybe.nbs")), "Call Me Maybe", "Unbekannt", "1:41", Material.getMaterial(getSubID(15))));
		songs.put(16, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "DJ_Got_Us_Fallin'_in_Love.nbs")), "DJ Got Us Fallin' in Love", "Unbekannt", "3:25", Material.getMaterial(getSubID(16))));
		songs.put(17, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Don't_Stop_Me_Now.nbs")), "Don't Stop Me Now", "Unbekannt", "3:35", Material.getMaterial(getSubID(17))));
		songs.put(18, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Dynamite.nbs")), "Dynamite", "Unbekannt", "2:44", Material.getMaterial(getSubID(18))));
		songs.put(19, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Gangnam_Style.nbs")), "Gangnam Style", "Unbekannt", "3:08", Material.getMaterial(getSubID(19))));
		songs.put(20, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Heart_Attack.nbs")), "Heart Attack", "Unbekannt", "2:41", Material.getMaterial(getSubID(20))));
		songs.put(21, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "It's_My_Life.nbs")), "It's My Life", "Unbekannt", "3:12", Material.getMaterial(getSubID(21))));
		songs.put(22, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Nyan_Cat.nbs")), "Nyan Cat", "Unbekannt", "3:29", Material.getMaterial(getSubID(22))));
		songs.put(23, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Party_Rock_Anthem.nbs")), "Party Rock Anthem", "Unbekannt", "3:00", Material.getMaterial(getSubID(23))));
		songs.put(24, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Popcorn.nbs")), "Popcorn", "Unbekannt", "1:54", Material.getMaterial(getSubID(24))));
		songs.put(25, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Radioactive.nbs")), "Radioactive", "Petraller", "2:44", Material.getMaterial(getSubID(25))));
		songs.put(26, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Super_Mario_Bros_3_Athletic.nbs")), "Super Mario Bros 3 Athletic", "Unbekannt", "1:06", Material.getMaterial(getSubID(26))));
		songs.put(27, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Sweden.nbs")), "Sweden", "Unbekannt", "1:44", Material.getMaterial(getSubID(27))));
		songs.put(28, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Viva_La_Vida.nbs")), "Viva La Vida", "Unbekannt", "3:36", Material.getMaterial(getSubID(28))));
		songs.put(29, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "What_is_Love.nbs")), "What is Love", "Unbekannt", "3:52", Material.getMaterial(getSubID(29))));
		songs.put(30, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Geboren_um_zu_Leben.nbs")), "Geboren um zu Leben", "Unheilig", "3:26", Material.getMaterial(getSubID(30))));
		songs.put(31, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Dreamer.nbs")), "Dreamer", "Axwell Λ Ingrosso", "4:09", Material.getMaterial(getSubID(31))));
		songs.put(32, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Bailando.nbs")), "Bailando", "Enrique Iglesias", "4:08", Material.getMaterial(getSubID(32))));
		songs.put(33, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Escape.nbs")), "Escape", "Enrique Iglesias", "3:31", Material.getMaterial(getSubID(33))));
		songs.put(34, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Tonight_im_lovin_you.nbs")), "Tonight im lovin you", "Enrique Iglesias", "4:01", Material.getMaterial(getSubID(34))));
		songs.put(35, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "How_it_is.nbs")), "How It Is", "BibisBeautyPalace", "2:55", Material.getMaterial(getSubID(35))));
		songs.put(36, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Zombie.nbs")), "Zombie", "Cranberries", "5:11", Material.getMaterial(getSubID(36))));
		songs.put(37, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Final_Countdown.nbs")), "Final Countdown", "Europe", "5:29", Material.getMaterial(getSubID(37))));
		songs.put(38, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "O_Tannenbaum.nbs")), "O Tannenbaum O Tannenbaum", "Unbekannt", "2:28", Material.getMaterial(getSubID(38))));
		songs.put(39, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Alle_Jahre_wieder.nbs")), "Alle Jahre wieder", "Unbekannt", "1:12", Material.getMaterial(getSubID(39))));
		songs.put(40, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Yellowsubmarine.nbs")), "Yellowsubmarine", "Beatles", "2:24", Material.getMaterial(getSubID(40))));
		songs.put(41, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Norwegian_Wood.nbs")), "Norwegian Wood", "Beatles", "2:11", Material.getMaterial(getSubID(41))));
		songs.put(42, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Obladi_Oblada.nbs")), "Obladi Oblada", "Beatles", "3:00", Material.getMaterial(getSubID(42))));
		songs.put(43, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Dusk_Till_Dawn.nbs")), "Dusk Till Dawn", "ZAYN", "4:22", Material.getMaterial(getSubID(43))));
		songs.put(44, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Engel.nbs")), "Engel", "Rammstein", "4:26", Material.getMaterial(getSubID(44))));
		songs.put(45, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Sonne.nbs")), "Sonne", "Rammstein", "4:31", Material.getMaterial(getSubID(45))));
		songs.put(46, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Feuer_Frei.nbs")), "Feuer Frei", "Rammstein", "3:13", Material.getMaterial(getSubID(46))));
		songs.put(47, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Benzin.nbs")), "Benzin", "Rammstein", "3:31", Material.getMaterial(getSubID(47))));
		songs.put(48, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Adios.nbs")), "Adios", "Rammstein", "3:37", Material.getMaterial(getSubID(48))));
		songs.put(49, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Still.nbs")), "Still", "Jupiter Jones", "4:04", Material.getMaterial(getSubID(49))));
		songs.put(50, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Nationalhymne.nbs")), "Deutsche Nationalhymne", "Joseph Haydn", "0:53", Material.getMaterial(getSubID(50))));
		songs.put(51, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Despacito.nbs")), "Despacito", "Luis Fonsi", "0:47", Material.getMaterial(getSubID(51))));
		songs.put(52, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "HeyBrother.nbs")), "Hey Brother", "Avicii", "4:12", Material.getMaterial(getSubID(52))));	
		songs.put(53, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Bohemian_Rhapsody.nbs")), "Bohemian Rhapsody", "Lucky Cobra", "5:31", Material.getMaterial(getSubID(53))));
		songs.put(54, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Comptine.nbs")), "Comptine", "Unbekannt", "1:24", Material.getMaterial(getSubID(54))));
		songs.put(55, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Johnny_B_Goode.nbs")), "Johnny B Goode", "Unbekannt", "2:15", Material.getMaterial(getSubID(55))));
		songs.put(56, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Positive_Force.nbs")), "Positive Force", "Unbekannt", "2:31", Material.getMaterial(getSubID(56))));
		songs.put(57, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Vanilla_Twilight.nbs")), "Vanilla Twilight", "Petraller", "3:25", Material.getMaterial(getSubID(57))));
		songs.put(58, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Indiana_Jones_Theme.nbs")), "Indiana Jones Theme", "Unbekannt", "4:10", Material.getMaterial(getSubID(58))));
		songs.put(59, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Fireflies.nbs")), "Fireflies", "Unbekannt", "3:17", Material.getMaterial(getSubID(59))));
		songs.put(60, new Lied(NBSDecoder.parse(new File("plugins/TraidioNET-Traiunity_V3/Musik/Musik", "Let_It_Be.nbs")), "Let It Be", "Unbekannt", "3:44", Material.getMaterial(getSubID(60))));
	}
	
	@SuppressWarnings("serial")
	private static String getSubID(int slot){
		if(!FileManager2.subcfg.contains(""+slot)){
			List<Material> subids = new ArrayList<Material>(){{
				add(Material.RECORD_3);
				add(Material.RECORD_4);
				add(Material.RECORD_5);
				add(Material.RECORD_6);
				add(Material.RECORD_7);
				add(Material.RECORD_8);
				add(Material.RECORD_9);
				add(Material.RECORD_10);
				add(Material.RECORD_11);
				add(Material.RECORD_12);
				add(Material.GOLD_RECORD);
				add(Material.GREEN_RECORD);
			}};
			FileManager2.subcfg.set(""+slot, subids.get(new Random().nextInt(subids.size())).toString());
			try { 	FileManager2.subcfg.save(FileManager2.subfile); } catch (IOException e) {}
		}
		
		return FileManager2.subcfg.getString(""+slot);
	}
	
	public static void openPlaylistInv(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, "§bPlaylist");
		
		int i = 0;
		
		for(Lied l : aktuelle_playlist){			
			inv.setItem(i, ItemBuilder1.createItemWithLore(Music.songs.get(i).getMaterial(), 1, "§e" + l.getName(), ItemBuilder1.getNewStringArray(new String[]{
					"§8» §7Interpret §8● §e" + l.getInterpret(),
					"§8» §7Länge §8● §e" + l.getLänge()
			})));			
			i++;
		}
		
		if(pause){
			inv.setItem(21, ItemBuilder1.createItem(Material.MINECART, 1, "§cStatus §8● §cPausiert"));
		}else{
			inv.setItem(21, ItemBuilder1.createItem(Material.MINECART, 1, "§cStatus §8● §aLäuft.."));
		}
		
		if(loop){
			inv.setItem(23, ItemBuilder1.createItem(Material.DIAMOND, 1, "§aWiederholen §8● §aJa"));
		}else{
			inv.setItem(23, ItemBuilder1.createItem(Material.DIAMOND, 1, "§aWiederholen §8● §cNein"));
		}
		
		inv.setItem(26, ItemBuilder1.createItem(Material.ARROW, 1, "§8» §7Zum Musik Inventar"));
		
		p.openInventory(inv);
	}

}
