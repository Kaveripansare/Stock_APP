package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockTable")
public class Stock {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Stock(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Stock(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Stock() {
		super();
	}
	@Override
	public String toString() {
		return "StockEntity [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
