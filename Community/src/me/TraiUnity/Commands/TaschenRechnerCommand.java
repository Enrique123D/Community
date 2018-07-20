package me.TraiUnity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TraiUnity.Main;

public class TaschenRechnerCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		Player p = (Player)sender;
		
		try{
		if(args.length == 3){
			double Zahl1 = Integer.parseInt(args[0]);
			double Zahl2 = Integer.parseInt(args[2]);
			if(args[1].equalsIgnoreCase("+")){
				double Ergebnis = Zahl1+Zahl2;
				p.sendMessage(Main.tr + "§7" + Zahl1 + " + " + Zahl2 + " = " + Ergebnis);
			}
			if(args[1].equalsIgnoreCase("-")){
				double Ergebnis = Zahl1-Zahl2;
				p.sendMessage(Main.tr + "§7" + Zahl1 + " - " + Zahl2 + " = " + Ergebnis);
			}
			if(args[1].equalsIgnoreCase("*")){
				double Ergebnis = Zahl1*Zahl2;
				p.sendMessage(Main.tr + "§7" + Zahl1 + " * " + Zahl2 + " = " + Ergebnis);
			}
			if(args[1].equalsIgnoreCase(":")){
				double Ergebnis = Zahl1/Zahl2;
				p.sendMessage(Main.tr + "§7" + Zahl1 + " : " + Zahl2 + " = " + Ergebnis);
			}
		}else{
			if(args.length == 5){
				double Zahl1 = Integer.parseInt(args[0]);
				double Zahl2 = Integer.parseInt(args[2]);
				double Zahl3 = Integer.parseInt(args[4]);
			if(args[1].equalsIgnoreCase("+")){
				if(args[3].equalsIgnoreCase("+")){
					double Ergebnis = Zahl1+Zahl2+Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " + " + Zahl2 + " + " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("-")){
					double Ergebnis = Zahl1+Zahl2-Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " + " + Zahl2 + " - " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("*")){
					double Ergebnis = Zahl1+Zahl2*Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " + " + Zahl2 + " * " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase(":")){
					double Ergebnis = Zahl1+Zahl2/Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " + " + Zahl2 + " : " + Zahl3 + " = " + Ergebnis);
				}	
			}
			if(args[1].equalsIgnoreCase("-")){
				if(args[3].equalsIgnoreCase("+")){
					double Ergebnis = Zahl1-Zahl2+Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " - " + Zahl2 + " + " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("-")){
					double Ergebnis = Zahl1-Zahl2-Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " - " + Zahl2 + " - " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("*")){
					double Ergebnis = Zahl1-Zahl2*Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " - " + Zahl2 + " * " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase(":")){
					double Ergebnis = Zahl1-Zahl2/Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " - " + Zahl2 + " : " + Zahl3 + " = " + Ergebnis);
				}
			}
			if(args[1].equalsIgnoreCase("*")){
				if(args[3].equalsIgnoreCase("+")){
					double Ergebnis = Zahl1*Zahl2+Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " * " + Zahl2 + " + " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("-")){
					double Ergebnis = Zahl1*Zahl2-Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " * " + Zahl2 + " - " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("*")){
					double Ergebnis = Zahl1*Zahl2*Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " * " + Zahl2 + " * " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase(":")){
					double Ergebnis = Zahl1*Zahl2/Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " * " + Zahl2 + " : " + Zahl3 + " = " + Ergebnis);
				}
			}
			if(args[1].equalsIgnoreCase(":")){
				if(args[3].equalsIgnoreCase("+")){
					double Ergebnis = Zahl1/Zahl2+Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " : " + Zahl2 + " + " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("-")){
					double Ergebnis = Zahl1/Zahl2-Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " : " + Zahl2 + " - " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase("*")){
					double Ergebnis = Zahl1/Zahl2*Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " : " + Zahl2 + " * " + Zahl3 + " = " + Ergebnis);
				}
				if(args[3].equalsIgnoreCase(":")){
					double Ergebnis = Zahl1/Zahl2/Zahl3;
					p.sendMessage(Main.tr + "§7" + Zahl1 + " : " + Zahl2 + " : " + Zahl3 + " = " + Ergebnis);
				}
			}
			}else{
				p.sendMessage(Main.tr + "§cBenutze §e/taschenrechner §8[§7Zahl +/-/*/: Zahl [+/-/*/: Zahl§8]");
			}
		}
		}catch(Exception ex){
			p.sendMessage(Main.tr + "§7Bitte benutze ganze Zahlen!");
		}
		return false;
	} 
}
