package com.RestroManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestroManagement.Dao.HotelRepository;
import com.RestroManagement.Entity.Hotel;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getAllHotels(){
		return hotelRepository.findAll();
		
	}
	
	public Hotel GetHotelById(Long id) {
		return hotelRepository.findById(id).get();
		
	}
	public void SaveOrUpdateHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}
	public void DeleteById(Long id) {
		hotelRepository.deleteById(id);
	}
	
	public Hotel getHotelByCity(String city) {
		return hotelRepository.getHotelByCity(city);
		
	}
}
