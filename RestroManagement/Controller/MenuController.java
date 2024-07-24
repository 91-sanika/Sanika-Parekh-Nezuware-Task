package com.RestroManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.RestroManagement.Entity.Menu;
import com.RestroManagement.service.MenuService;
import jakarta.transaction.Transactional;

@Controller
@Transactional
public class MenuController {
	@Autowired
	private MenuService menuService;
	
    @GetMapping("/registermenu")
	public String regimenu(Model model) {
		
		model.addAttribute("menu", new Menu());
		
		return "MenuRegestration";
		
	}
    @PostMapping("/status")
    public String getStatus(@Validated @ModelAttribute("menu") Menu menu,BindingResult bindResult) {
    	if(bindResult.hasErrors()) {
    		return "MenuRegestration";
    	}
    	menuService.saveMenu(menu);
    	return "redirect:/menulist";
    }
    

}
