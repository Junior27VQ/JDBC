package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
	private static final Logger log =LogManager.getLogger(Conexion.class);
	private static final String URL="jdbc:postgresql://localhost:5432/tallerjdbc";
	private static final String USUARIO="postgres";
	private static final String CLAVE="Junior0207VQ";
	
	public static Connection getConnetion() {
		Connection con =null;	      
		try {
			con=DriverManager.getConnection(URL, USUARIO, CLAVE);
			log.info("Conexion exitosa: ");
			return con;
		} catch (SQLException e) {
			log.error("Error de conexion: "+e.getMessage());
			throw new RuntimeException("Error de conexion", e);
		}
	}
}
