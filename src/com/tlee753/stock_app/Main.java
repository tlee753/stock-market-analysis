package com.tlee753.stock_app;


import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;


public class Main {
	
	public static void main(String[] args) {

		Stock stock = null;
		try {
			stock = YahooFinance.get("NVDA");
		} catch (IOException e) {
			System.out.println("Error retrieving Stock Information");
			e.printStackTrace();
		}

		BigDecimal price = stock.getQuote().getPrice();
		System.out.println(price);
		//BigDecimal change = stock.getQuote().getChangeInPercent();
		//BigDecimal peg = stock.getStats().getPeg();
		//BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
		 
		stock.print();
	}

}
