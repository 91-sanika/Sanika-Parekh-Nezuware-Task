package com.RestroManagement.service;

import java.util.List;

import com.RestroManagement.Entity.Menu;

public interface MenuService {
	public Menu saveMenu(Menu menu);
	public List<Menu> menuList();
	public void deleteById(int id);
	public Menu fintById(int id);
	public Menu updateMenu(Menu menu);
}
