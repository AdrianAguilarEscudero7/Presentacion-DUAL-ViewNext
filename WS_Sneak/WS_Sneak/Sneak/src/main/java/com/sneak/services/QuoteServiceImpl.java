package com.sneak.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sneak.dao.QuoteDAO;
import com.sneak.modelo.Quote;

@Service
public class QuoteServiceImpl implements QuoteService {
	
	private QuoteDAO quoteDao;
	
	public QuoteServiceImpl() {
	}
	
	public QuoteServiceImpl(QuoteDAO quoteDao) {
		this.quoteDao = quoteDao;
	}
	
	public List<Quote> cargaPorDia(Date date) {
		return quoteDao.cargaPorDia(date);
	}
	
	public boolean insertToDB(Quote q) {
		return quoteDao.insertToDB(q);
	}
	
	public boolean updateDB(Quote q) {
		return quoteDao.updateDB(q);
	}
}
