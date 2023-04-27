package com.zensar.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.zensar.entity.Stock;
import com.zensar.repo.StockRepository;

@Service
public class StockService {

	private final StockRepository stockRepository;

	@Autowired
	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	@Scheduled(fixedDelay = 3000)
	public void updatedPrice() {
		simpMessagingTemplate.convertAndSend("/topic/stocks", stockRepository.findAll());
	}

	@Scheduled(fixedRate = 3000)
	public void updateAppleStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByName("Apple");
		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepository.save(stock);
		}
	}

	@Scheduled(fixedRate = 3000)
	public void updateIBMStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByName("IBM");
		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepository.save(stock);
		}
	}

	@Scheduled(fixedRate = 3000)
	public void updateInfosysStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByName("Infosys");
		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepository.save(stock);
		}
	}

	@Scheduled(fixedRate = 3000)
	public void updateRelianceStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByName("Reliance");
		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepository.save(stock);
		}
	}

	@Scheduled(fixedRate = 3000)
	public void updateZensarStockPrice() {
		Optional<Stock> stockOptional = stockRepository.findByName("Zensar");
		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepository.save(stock);
		}
	}

	private int generateRandomPrice() {
		Random rand = new Random();
		int min = 100;
		int max = 200;
		return rand.nextInt((max - min) + 1) + min;
	}

	public List<Stock> getAllStocks() {
		return stockRepository.findAll();
	}

}
