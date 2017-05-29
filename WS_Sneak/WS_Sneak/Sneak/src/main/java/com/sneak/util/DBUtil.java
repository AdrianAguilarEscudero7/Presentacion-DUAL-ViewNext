/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sneak.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Adrián Aguilar
 */
public class DBUtil {
	


	public DBUtil() {
	}

	/**
	 * 
	 * @param url
	 *            URL de conexión a BBDD.
	 * @param user
	 * @param pass
	 * @param driver
	 * @return
	 * @throws DBUtilException
	 */
	public static Connection getConnection(String url, String user, String pass, String driver) {
		Connection conexion = null;
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return conexion;
	}

	/**
	 * Realiza una consulta
	 * 
	 * @param conn
	 * @param query
	 * @return
	 * @throws DBUtilException
	 */
	public static ResultSet exeQuery(Connection conn, String query) {
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	/**
	 * Realiza una inserción
	 * 
	 * @param conn
	 * @param insert
	 * @return
	 * @throws DBUtilException
	 */
	public static boolean exeInsert(Connection conn, String insert) {
		boolean ret = false;
		try {
			Statement stmt = conn.createStatement();
			int ins = stmt.executeUpdate(insert);

			if (ins == 0) {
				ret = false;
			} else {
				ret = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ret;
	}

	/**
	 * Realiza una actualización
	 * 
	 * @param conn
	 * @param update
	 * @return
	 * @throws DBUtilException
	 */
	public static int exeUpdate(Connection conn, String update) {
		int updt = 0;
		try {
			Statement stmt = conn.createStatement();
			updt = stmt.executeUpdate(update);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return updt;
	}
}
