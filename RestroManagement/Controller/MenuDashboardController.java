package com.RestroManagement.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.RestroManagement.Entity.Menu;
import com.RestroManagement.service.MenuService;

@Controller
public class MenuDashboardController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menulist")
    public String getMenuList(Model model) {
        List<Menu> menuList = menuService.menuList();
        model.addAttribute("menus", menuList);
        return "menus";
    }

    @PostMapping("/menu/delete")
    public String deleteMenu(@RequestParam("id") int id, Model model) {
        try {
            menuService.deleteById(id);
        } catch (Exception e) {
            // Handle exception gracefully, e.g., log the error
            return "error"; // Redirect to an error page
        }
        return "redirect:/menulist"; // Redirect to menu list page after successful delete
    }

    @GetMapping("/menu/edit")
    public String getEditForm(@RequestParam("id") int id, Model model) {
        Menu menu = menuService.fintById(id); // Corrected method name
        model.addAttribute("menu", menu);
        return "update-forms";
    }

    @PostMapping("/saveupdate")
    public String updateMenu(@Validated @ModelAttribute("menu") Menu menu, BindingResult bindResult, Model model) {
        if (bindResult.hasErrors()) {
            // Populate model with necessary data for update form and return to update form
            return "update-forms";
        }
        menuService.updateMenu(menu);
        return "redirect:/menulist"; // Redirect to menu list page after successful update
    }
}

