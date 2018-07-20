package me.TraiUnity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	
	public static String host = Main.ranking.getString("MySQL.Host");
	public static String port = String.valueOf(Main.ranking.getInt("MySQL.Port"));
	public static String database = Main.ranking.getString("MySQL.Datenbank");
	public static String username = Main.ranking.getString("MySQL.Benutzername");
	public static String password = Main.ranking.getString("MySQL.Passwort");
	
	public static Connection connection;
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static boolean isConnected1() {
		return (connection == null ? false : true);
	}
	
	public static void connect1() {
		if (!isConnected()) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
			} catch (SQLException ex) {
				System.out.println("[Traiunity_MySQL] Konnte nicht zur Datenbank verbinden!");
				ex.printStackTrace();
			}
		}
	}
	
	public static Connection c;
    
    public static void connect(){
    	
		try{
			c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.port + "/" + Main.db + "?autoReconnect=true",Main.user,Main.pw);
			System.out.println("[MySQL] Connected.");
		} catch(SQLException e){
			System.out.println("[MySQL] Connection failed.");
			e.printStackTrace();
		}
	}
	
    public static void disconnect() {
    	if(c != null) {
        	try {
    			c.close();
    			connection.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public static boolean isConnected(){
    	return(c == null ? false : true);
    }
    
    public static void Update(String qry) {
        try {
        	Statement stmt = c.createStatement();
        	stmt.executeUpdate(qry);
        	stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            disconnect();
	        connect();
        }
    }
}
