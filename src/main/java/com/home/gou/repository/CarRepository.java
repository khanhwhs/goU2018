package com.home.gou.repository;

import com.home.gou.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {


}