package com.RestroManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

	
	@GetMapping("/gallary")
	public String GallaryRooms() {
		return "gallary";
	}
	
}
