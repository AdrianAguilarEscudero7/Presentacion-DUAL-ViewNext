package com.sneak.modelo;

import java.sql.Timestamp;

public class Quote {
	
	private int id;
	private int cargaId;
	private Timestamp created;
	private String quoteRef;
	private String statCd;
	private String xVfStatus;
	private String quoteType;
	private String login;
	private String orderRef;
	private String incidencia;
	private String responsable;
	private String responsableNuevo;
	private String estado;
	private String codigo;
	private String descripcion;
	private String planItemId;
	private String nativeErrorDesc;
	private String estadoActual;
	private String incidentActual;
	private String msg;

	public Quote() {
	}
	
	public Quote(String quoteRef) {
		this.quoteRef = quoteRef;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCargaId() {
		return cargaId;
	}

	public void setCargaId(int cargaId) {
		this.cargaId = cargaId;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getQuoteRef() {
		return quoteRef;
	}

	public void setQuoteRef(String quoteRef) {
		this.quoteRef = quoteRef;
	}

	public String getStatCd() {
		return statCd;
	}

	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}

	public String getxVfStatus() {
		return xVfStatus;
	}

	public void setxVfStatus(String xVfStatus) {
		this.xVfStatus = xVfStatus;
	}

	public String getQuoteType() {
		return quoteType;
	}

	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getResponsableNuevo() {
		return responsableNuevo;
	}

	public void setResponsableNuevo(String responsableNuevo) {
		this.responsableNuevo = responsableNuevo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPlanItemId() {
		return planItemId;
	}

	public void setPlanItemId(String planItemId) {
		this.planItemId = planItemId;
	}

	public String getNativeErrorDesc() {
		return nativeErrorDesc;
	}

	public void setNativeErrorDesc(String nativeErrorDesc) {
		this.nativeErrorDesc = nativeErrorDesc;
	}

	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}

	public String getIncidentActual() {
		return incidentActual;
	}

	public void setIncidentActual(String incidentActual) {
		this.incidentActual = incidentActual;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
