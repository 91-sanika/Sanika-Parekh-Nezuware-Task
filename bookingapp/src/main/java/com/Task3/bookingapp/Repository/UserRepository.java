package com.Task3.bookingapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task3.bookingapp.Entity.User1;

@Repository
public interface UserRepository extends JpaRepository<User1, Long> {

}
