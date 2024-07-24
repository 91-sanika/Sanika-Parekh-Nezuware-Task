package com.RestroManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestroManagement.Entity.Hotel;
@Repository
public interface HotelRepository extends  JpaRepository<Hotel, Long>{

	Hotel getHotelByCity(String city);
}
