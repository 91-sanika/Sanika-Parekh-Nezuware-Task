package com.RestroManagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestroManagement.Dao.MenuRepository;
import com.RestroManagement.Entity.Menu;

@Service
public class MenuServiceImp implements MenuService{
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public Menu saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

	@Override
	public List<Menu> menuList() {
		List<Menu> findAll= menuRepository.findAll();

		return findAll;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(id);	
	}

	@Override
	public Menu fintById(int id) {
		Optional<Menu> fintById=menuRepository.findById(id);
		Menu menu=fintById.get();
		return menu;		
	}

	@Override
	public Menu updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

}
