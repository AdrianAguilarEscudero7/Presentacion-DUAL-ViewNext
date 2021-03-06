package com.sneak.modelo;

public class Estadistica {
	private int total;
	private int blank_total;
	private int blank_completas;
	private int blank_catalogadas;
	private int blank_sin_tocar;
	private int catalog_total;
	private int catalog_completas;
	private int catalog_recatalogada;
	private int catalog_sin_tocar;
	
	private String responsable;
	private String msg;
	
	private String str_blank_completa;
	private String str_blank_catalogada;
	private String str_blank_sin_tocar;
	
	private String str_catalog_completa;
	private String str_catalog_recatalogada;
	private String str_catalog_sin_tocar;
	
	
	/*
	 * M�todos de incremento de contadores	
	 */	
	public void suma_total(){
		total++;
	}
	public void suma_blank_total(){
		blank_total++;
	}
	public void suma_blank_completas(){
		blank_completas++;
	}
	public void suma_blank_catalogadas(){
		blank_catalogadas++;
	}
	public void suma_blank_sin_tocar(){
		blank_sin_tocar++;
	}
	public void suma_catalog_total(){
		catalog_total++;
	}
	public void suma_catalog_completas(){
		catalog_completas++;
	}
	public void suma_catalog_recatalogada(){
		catalog_recatalogada++;
	}	
	public void suma_catalog_sin_tocar(){
		catalog_sin_tocar++;
	}	
	/*
	 * Fin de M�todos de incremento de contadores
	 */
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public int getTotal() {
		return total;
	}
	public String getStr_blank_completa() {
		return str_blank_completa;
	}
	public void setStr_blank_completa(String str_blank_completa) {
		this.str_blank_completa = str_blank_completa;
	}
	public String getStr_blank_catalogada() {
		return str_blank_catalogada;
	}
	public void setStr_blank_catalogada(String str_blank_catalogada) {
		this.str_blank_catalogada = str_blank_catalogada;
	}
	public String getStr_blank_sin_tocar() {
		return str_blank_sin_tocar;
	}
	public void setStr_blank_sin_tocar(String str_blank_sin_tocar) {
		this.str_blank_sin_tocar = str_blank_sin_tocar;
	}
	public String getStr_catalog_completa() {
		return str_catalog_completa;
	}
	public void setStr_catalog_completa(String str_catalog_completa) {
		this.str_catalog_completa = str_catalog_completa;
	}
	public String getStr_catalog_recatalogada() {
		return str_catalog_recatalogada;
	}
	public void setStr_catalog_recatalogada(String str_catalog_recatalogada) {
		this.str_catalog_recatalogada = str_catalog_recatalogada;
	}
	public String getStr_catalog_sin_tocar() {
		return str_catalog_sin_tocar;
	}
	public void setStr_catalog_sin_tocar(String str_catalog_sin_tocar) {
		this.str_catalog_sin_tocar = str_catalog_sin_tocar;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getBlank_total() {
		return blank_total;
	}
	public void setBlank_total(int blank_total) {
		this.blank_total = blank_total;
	}
	public int getBlank_completas() {
		return blank_completas;
	}
	public void setBlank_completas(int blank_completas) {
		this.blank_completas = blank_completas;
	}
	public int getBlank_catalogadas() {
		return blank_catalogadas;
	}
	public void setBlank_catalogadas(int blank_catalogadas) {
		this.blank_catalogadas = blank_catalogadas;
	}
	public int getBlank_sin_tocar() {
		return blank_sin_tocar;
	}
	public void setBlank_sin_tocar(int blank_sin_tocar) {
		this.blank_sin_tocar = blank_sin_tocar;
	}
	public int getCatalog_total() {
		return catalog_total;
	}
	public void setCatalog_total(int catalog_total) {
		this.catalog_total = catalog_total;
	}
	public int getCatalog_completas() {
		return catalog_completas;
	}
	public void setCatalog_completas(int catalog_completas) {
		this.catalog_completas = catalog_completas;
	}
	public int getCatalog_recatalogada() {
		return catalog_recatalogada;
	}
	public void setCatalog_recatalogada(int catalog_recatalogada) {
		this.catalog_recatalogada = catalog_recatalogada;
	}
	public int getCatalog_sin_tocar() {
		return catalog_sin_tocar;
	}
	public void setCatalog_sin_tocar(int catalog_sin_tocar) {
		this.catalog_sin_tocar = catalog_sin_tocar;
	}
	

	
}
