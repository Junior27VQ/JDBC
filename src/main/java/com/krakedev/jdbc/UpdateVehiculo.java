package com.krakedev.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {
	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnetion();
			String sql = """
					update vehiculo set marca=?,modelo=?,anio=?,precio=?,color=?,disponible=?,kilometraje=? where placa=?;
					""";
			ps = con.prepareStatement(sql);

			
			ps.setString(1, "TOYOTA");
			ps.setString(2, "Deportivo");
			ps.setInt(3, 2010);
			ps.setBigDecimal(4, new BigDecimal(36000));
			ps.setString(5, "Negro");
			ps.setBoolean(6, true);
			ps.setInt(7, 60);
			ps.setString(8, "AAC-0123");
			
			int filas = ps.executeUpdate();
			log.info("Vehiculo actualizado: " + filas);

		} catch (Exception e) {
			log.error("Error al actualizar datos" + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				log.error("Error de conexion" + e.getMessage());
			}
		}
	}
}
