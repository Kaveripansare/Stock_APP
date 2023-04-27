package com.zensar.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer>{

	Optional<Stock> findByName(String string);

}
