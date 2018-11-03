package com.home.gou.repository;

import com.home.gou.entity.PassengersTripEntity;
import com.home.gou.entity.PtripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PTripRepository extends JpaRepository<PtripEntity, Integer> {

    List<PtripEntity> findByUserId(int userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value ="delete from PTRIP where user_id=?1 and trip_id=?2")
    void deleteByUserIdAndTripId(int userId, int tripId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value ="select * from PTRIP where trip_id=?1")
    List<PtripEntity> findByTripId(int tripId);
}
