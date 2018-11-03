package com.home.gou.repository;

import com.home.gou.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<RequestEntity, Integer> {

    public List<RequestEntity> findByRequesterId(int requesterId);

}
