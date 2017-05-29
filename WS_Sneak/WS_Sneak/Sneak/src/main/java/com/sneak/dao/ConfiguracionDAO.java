package com.sneak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sneak.modelo.Configuracion;

public class ConfiguracionDAO implements IConfiguracionDAO {

	Configuracion c = new Configuracion();

	@Override
	public Configuracion insertResponsable(String valor) {

		Connection conex = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/sneak?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			conex = DriverManager.getConnection(url, "root", "");
			Statement s = conex.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM snk_conf WHERE clave='responsable' AND valor='" + valor + "'");
			if (rs.next()) {
				c.setMsg("El responsable introducido ya existe.");

				return c;

			} else {
				if (valor.isEmpty()) {
					c.setMsg("No ha introducido ningún responsable.");

					return c;

				} else {
					s.executeUpdate("INSERT INTO snk_conf (clave,valor)" + " values('Responsable','" + valor + "')");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conex != null && !conex.isClosed()) {
					conex.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return c;
	}

	@Override
	public Configuracion deleteResponsable(String valor) {
		Connection conex = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/sneak?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			conex = DriverManager.getConnection(url, "root", "");
			Statement s = conex.createStatement();

			if (valor == null) {
				c.setMsg("No ha seleccionado ningún responsable.");

				return c;
			} else {

				s.executeUpdate("DELETE FROM snk_conf where valor='" + valor + "'");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conex != null && !conex.isClosed()) {
					conex.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return c;
	}
}
