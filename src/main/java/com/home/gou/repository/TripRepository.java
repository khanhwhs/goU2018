package com.home.gou.repository;

import com.home.gou.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends JpaRepository<TripEntity, Integer> {

    @Query(nativeQuery = true, value ="SELECT * from TRIP where STR_TO_DATE(CREATED_ON,'%Y-%m-%d') >= CURDATE()-7 and  USER_CAR_ID =?")
    List<TripEntity> findByUserCarId(int userCarId);

    @Query(nativeQuery = true, value ="SELECT * from TRIP where STR_TO_DATE(CREATED_ON,'%Y-%m-%d') >= CURDATE()-7 and TRIP_ID =?")
    List<TripEntity> findById(int id);

    @Query(nativeQuery = true, value ="SELECT * from TRIP t where STR_TO_DATE(t.CREATED_ON,'%Y-%m-%d') >= CURDATE()" +
            "and (Select COUNT(*) from PTRIP pT where pT.TRIP_ID = t.TRIP_ID) < t.SEATS")
    List<TripEntity> findAllCurrent();
}
