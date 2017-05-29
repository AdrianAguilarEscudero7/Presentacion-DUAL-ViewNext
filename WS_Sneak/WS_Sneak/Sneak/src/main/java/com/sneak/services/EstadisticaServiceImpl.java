package com.sneak.services;

import com.sneak.dao.EstadisticaDAO;
import com.sneak.modelo.Estadistica;

public class EstadisticaServiceImpl implements EstadisticaService {

	private EstadisticaDAO estadisticaDao;
	
	public EstadisticaServiceImpl() {
	}
	
	public EstadisticaServiceImpl(EstadisticaDAO estadisticaDao) {
		this.estadisticaDao = estadisticaDao;
	}
	
	public Estadistica generaEstadistica() {
		return estadisticaDao.generaEstadistica();
	}

}
