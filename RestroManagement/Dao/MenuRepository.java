package com.RestroManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.RestroManagement.Entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>{

}
