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

import com.RestroManagement.Entity.Room;
import com.RestroManagement.service.RoomService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public String getAllRooms(Model model) {
		model.addAttribute("rooms", roomService.getAllRooms());
		return "room-list";		
	}
	
	@GetMapping("/{id}")
	public String getRoomById(@PathVariable Long id,Model model) {
		Room room =roomService.getRoomById(id);
		model.addAttribute("room", room);
		return "room-details";
	}
	
	@GetMapping("/room-number/{roomNumber}")
	public String getRoomByRoomNumber(@PathVariable int roomNumber,Model model) {
		model.addAttribute("room", roomService.getRoomByRoomNumber(roomNumber));
		return "room-details";
		
	}
	@GetMapping("/new")
	public String showAddRoomForm(Model model) {
		model.addAttribute("room", new Room());
		return "room-form";
	}
	
	@PostMapping
	public String addRoom(Room room ,BindingResult result,RedirectAttributes redirectAttributes) {
	if(result.hasErrors()) {
		return "room-form";
	}
		roomService.SaveOrUpdateRoom(room);
		redirectAttributes.addFlashAttribute("message", "Rooms Added Succesfully");
		return "redirect:/rooms";
		
	}
	
	@GetMapping("edit/{id}")
	public String ShowEditForm(@PathVariable long id,Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		return "room-form";
		
	}
	
	@PostMapping("/edit/{id}")
	public String updateRoom(@PathVariable Long id,Room room,BindingResult result,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "room-form";
		}
		room.setId(id);
		roomService.SaveOrUpdateRoom(room);
		redirectAttributes.addFlashAttribute("message"," Room Updated Succesfully");
		return "redirect:/rooms";
		
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteRoom(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		roomService.DeleteRoom(id);
		redirectAttributes.addFlashAttribute("message"," Room Deleted Succesfully");		
		return "redirect:/rooms";
		
	}
}
