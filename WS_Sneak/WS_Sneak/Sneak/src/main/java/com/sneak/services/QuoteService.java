package com.sneak.services;

import java.util.Date;
import java.util.List;

import com.sneak.modelo.Quote;

public interface QuoteService {
	
	public List<Quote> cargaPorDia(Date date);
	
	public boolean insertToDB(Quote q);
	
	public boolean updateDB(Quote q);
}
