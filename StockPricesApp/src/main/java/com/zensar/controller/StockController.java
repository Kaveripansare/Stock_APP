package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Stock;
import com.zensar.service.StockService;

@RestController
public class StockController {

	@Autowired
	StockService stockService;

	@GetMapping("/stocks")
	//@MessageMapping("/stocks")
  	@SendTo("/topic/stocks")
	public List<Stock> getAllStocks(){
		List<Stock> stocks = stockService.getAllStocks();
		return stocks;
	}
	

}
