package com.zensar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zensar.entity.Stock;
import com.zensar.service.StockService;

@WebMvcTest(StockController.class)
public class StockControllerTest {

	@MockBean
	StockService stockService;
	@Test
	public void testGetAllStocks() {
		List<Stock> stocks=new ArrayList<Stock>();
		stocks.add(new Stock("Apple",22));
		stocks.add(new Stock("IBM",25));
		stocks.add(new Stock("Zensar",29));
		when(stockService.getAllStocks()).thenReturn(stocks);
		List<Stock> result=stockService.getAllStocks();
		assertEquals(stocks, result);
	}
}
