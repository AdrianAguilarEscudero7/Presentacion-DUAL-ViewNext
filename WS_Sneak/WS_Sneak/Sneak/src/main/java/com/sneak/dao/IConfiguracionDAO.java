package com.sneak.dao;

import com.sneak.modelo.Configuracion;

public interface IConfiguracionDAO {
	
	Configuracion insertResponsable(String valor);

	Configuracion deleteResponsable(String valor);
}
