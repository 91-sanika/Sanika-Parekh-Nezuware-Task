package com.RestroManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestroManagement.Dao.RoomRepository;
import com.RestroManagement.Entity.Room;
@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;

	public List<Room> getAllRooms() {
		return roomRepository.findAll();

	}

	public Room getRoomById(Long id) {
		return roomRepository.findById(id).get();

	}
	
	public Room getRoomByRoomNumber(int roomNumber) {
		return roomRepository.getRoomByRoomNumber(roomNumber);
		
	}

	public void SaveOrUpdateRoom(Room room) {
	roomRepository.save(room);	
	}

	public void DeleteRoom(Long id) {
		roomRepository.deleteById(id);
	}
}
