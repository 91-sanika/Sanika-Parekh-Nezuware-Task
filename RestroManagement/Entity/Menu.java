package com.RestroManagement.Entity;

import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Menu {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Menu_name;
	private int price;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private File menus;
	
	public File getMenus() {
		return menus;
	}
	public void setMenus(File menus) {
		this.menus = menus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenu_name() {
		return Menu_name;
	}
	public void setMenu_name(String menu_name) {
		Menu_name = menu_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", Menu_name=" + Menu_name + ", price=" + price + ", quantity=" + quantity +", menus="+menus+"]";
	}
	public Menu(int id, String menu_name, int price,int quantity,File menus) {
		super();
		this.id = id;
		this.Menu_name = menu_name;
		this.price = price;
		this.quantity = quantity;
		this.menus=menus;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
