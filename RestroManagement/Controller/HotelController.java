package com.RestroManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RestroManagement.Entity.Hotel;
import com.RestroManagement.Entity.Room;
import com.RestroManagement.service.HotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping
	public String getAllHotels(Model model) {
		model.addAttribute("hotels", hotelService.getAllHotels());
		return "hotel-list";		
	}
	
	@GetMapping("/{id}")
	public String getHotelById(@PathVariable Long id,Model model) {
		Hotel hotel =hotelService.GetHotelById(id);
		model.addAttribute("hotel", hotel);
		return "hotel-details";
	}
	
	@GetMapping("/city/{city}")
	public String getRoomByCity(@PathVariable String city,Model model) {
		model.addAttribute("hotels", hotelService.getHotelByCity(city));
		return "hotel-details";
		
	}
	
	@GetMapping("/new")
	public String showAddHotelForm(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "hotel-form";
	}
	
	@PostMapping
	public String addHotel(Hotel hotel ,BindingResult result,RedirectAttributes redirectAttributes) {
	if(result.hasErrors()) {
		return "hotel-form";
	}
	hotelService.SaveOrUpdateHotel(hotel);
		redirectAttributes.addFlashAttribute("message", "Hotel Added Succesfully");
		return "redirect:/hotels";
		
	}
	
	@GetMapping("edit/{id}")
	public String ShowEditForm(@PathVariable long id,Model model) {
		model.addAttribute("hotel", hotelService.GetHotelById(id));
		return "hotel-form";
		
	}
	
	@PostMapping("/edit/{id}")
	public String updateHotel(@PathVariable Long id,Hotel hotel,BindingResult result,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "hotel-form";
		}
		hotel.setId(id);
		hotelService.SaveOrUpdateHotel(hotel);
		redirectAttributes.addFlashAttribute("message"," Room Updated Succesfully");
		return "redirect:/hotels";
		
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteHotel(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		hotelService.DeleteById(id);
		redirectAttributes.addFlashAttribute("message"," Room Deleted Succesfully");		
		return "redirect:/hotels";
		
	}
	
}
