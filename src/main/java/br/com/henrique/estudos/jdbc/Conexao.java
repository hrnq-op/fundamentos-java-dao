package br.com.henrique.estudos.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    
    public static Connection getConnection() throws SQLException {
        try {
        	Properties prop = new Properties ();
        	try (FileInputStream fs = new FileInputStream ("src/main/resources/config.properties")){
        		prop.load(fs);
        		
        		String url = prop.getProperty("db.url"); 
        		String user = prop.getProperty("db.user");
        		String pass = prop.getProperty("db.pass");
        		
        		return DriverManager.getConnection(url, user, pass);
            }
            
        } catch (IOException e) {
            throw new SQLException("Erro ao ler arquivo de configuração: " + e.getMessage());
        }
    }
}