package com.sneak.dao;

import java.util.Date;
import java.util.List;

import com.sneak.modelo.Quote;

public interface IQuoteDAO {
	
	List<Quote> cargaPorDia(Date date);
	
	boolean insertToDB(Quote quote);
	
	boolean updateDB(Quote q);
}
