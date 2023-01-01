package net.risingdev.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.risingdev.springboot.entity.*;
public interface ProductRepo extends 
JpaRepository<Product, Integer>{

}
