package com.krakedev.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {
	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try {
			con = Conexion.getConnetion();
			String sql=""" 
				insert into vehiculo(placa,marca,modelo,anio,precio,color,disponible)
				values(?,?,?,?,?,?,?);
				""";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, "AAC-0123");
			ps.setString(2, "SUZUKI");
			ps.setString(3, "Deportivo");
			ps.setInt(4, 2020);
			ps.setBigDecimal(5, new BigDecimal(15400));
			ps.setString(6, "Gris");
			ps.setBoolean(7, true);
			
			int filas = ps.executeUpdate();
			log.info("Vehiculo insertado: "+filas);
			
		} catch (SQLException e) {
			log.error("Error de conexion"+e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				log.error("Error de conexion"+e.getMessage());
			}
		}
		

	}

}
