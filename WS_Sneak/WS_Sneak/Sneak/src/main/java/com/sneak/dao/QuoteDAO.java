package com.sneak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sneak.modelo.Quote;

@Repository
public class QuoteDAO implements IQuoteDAO {

	// private DataSource dataSource;
	Connection conex;

	PreparedStatement ps = null;

	public QuoteDAO() {
	}

	public QuoteDAO(Connection conn) {
		this.conex = conn;
	}
	
	@Override
	public List<Quote> cargaPorDia(Date date) { // Preguntar

		List<Quote> quotes = new ArrayList<Quote>();

		String query = "SELECT * FROM snk_rep_dato WHERE cargaid = (SELECT ID FROM snk_rep_carga WHERE fecha=? ORDER BY FECHA DESC LIMIT 1)";

		try {

			ps = conex.prepareStatement(query);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			String sDate = sdf.format(date);

			ps.setString(1, sDate);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Quote quote = new Quote(rs.getString("quoteref"));
				quote.setId(rs.getInt("id"));
				quote.setCargaId(rs.getInt("cargaid"));
				quote.setCreated(rs.getTimestamp("created"));
				quote.setStatCd(rs.getString("stat_cd"));
				quote.setxVfStatus(rs.getString("x_vf_status"));
				quote.setQuoteType(rs.getString("quote_type"));
				quote.setLogin(rs.getString("login"));
				quote.setOrderRef(rs.getString("orderref"));
				quote.setIncidencia(rs.getString("incidencia"));
				quote.setResponsable(rs.getString("responsable"));
				quote.setResponsableNuevo(rs.getString("responsable_nuevo"));
				quote.setEstado(rs.getString("estado"));
				quote.setCodigo(rs.getString("codigo"));
				quote.setDescripcion(rs.getString("descripcion"));
				quote.setPlanItemId(rs.getString("planitemid"));
				quote.setNativeErrorDesc(rs.getString("nativeerrordesc"));
				quote.setEstadoActual(rs.getString("estado_actual"));
				quote.setIncidentActual(rs.getString("incident_actual"));
				quotes.add(quote);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return quotes;
	}
	
	@Override
	public boolean insertToDB(Quote q) {
		boolean ret = false;

		String query = "INSERT INTO snk_rep_dato (cargaid,created,quoteref,stat_cd,x_vf_status,quote_type,login,"
				+ "orderref,incidencia,responsable,responsable_nuevo,estado,codigo,descripcion,planitemid,"
				+ "nativeerrordesc, estado_actual, incident_actual) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'','')";

		try {
			// Connection conex = dataSource.getConnection();
			if (!conex.isClosed()) {

				PreparedStatement ps = conex.prepareStatement(query);
				ps.setInt(1, q.getCargaId());
				ps.setTimestamp(2, q.getCreated());
				ps.setString(3, q.getQuoteRef());
				ps.setString(4, q.getStatCd());
				ps.setString(5, q.getxVfStatus());
				ps.setString(6, q.getQuoteType());
				ps.setString(7, q.getLogin());
				ps.setString(8, q.getOrderRef());
				ps.setString(9, q.getIncidencia());
				ps.setString(10, q.getResponsable());
				ps.setString(11, q.getResponsableNuevo());
				ps.setString(12, q.getEstado());
				ps.setString(13, q.getCodigo());
				ps.setString(14, q.getDescripcion());
				ps.setString(15, q.getPlanItemId());
				ps.setString(16, q.getNativeErrorDesc());

				int exeRet = ps.executeUpdate();

				if (exeRet == 1) {
					ret = true;
				} else {
					ret = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public boolean updateDB(Quote q) {
		boolean ret = false;
		String upd = "UPDATE snk_rep_dato SET estado_actual=?, incident_actual=? WHERE quoteref=? and cargaid=?";
		try {
			ps = conex.prepareStatement(upd);
			ps.setString(1, q.getEstadoActual());
			ps.setString(2, q.getIncidentActual());
			ps.setString(3, q.getQuoteRef());
			ps.setInt(4, q.getCargaId());
			
			int exeRet = ps.executeUpdate();
			
			if (exeRet == 1) {
				ret = true;
			} else {
				ret = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
