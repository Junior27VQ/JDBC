package com.krakedev.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SelectVehiculo {
	private static final Logger log = LogManager.getLogger(SelectVehiculo.class);
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con = Conexion.getConnetion();
			String sql=""" 
					select * from vehiculo
					""";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String placa=rs.getString("placa");
				String marca=rs.getString("marca");
				String modelo=rs.getString("modelo");
				int anio=rs.getInt("anio");
				BigDecimal precio=rs.getBigDecimal("precio");
				String color=rs.getString("color");
				boolean disponible=rs.getBoolean("disponible");
				int kilometraje=rs.getInt("kilometraje");
				
				log.info("Vehiculo: Placa: "+placa+" Marca: "+marca+" Modelo: "+modelo+" Año: "+anio+" Precio: "+precio+" Color: "+color+" Disponible: "+disponible+" Kilometraje: "+kilometraje);
				
			}
			
		}catch(Exception e) {
			log.error("Error al traer datos"+e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				log.error("Error de conexion"+e.getMessage());
			}
		}

	}

}
