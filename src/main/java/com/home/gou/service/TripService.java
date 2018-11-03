package com.home.gou.service;

import com.home.gou.entity.PassengersTripEntity;
import com.home.gou.entity.TripEntity;
import com.home.gou.model.PTrip;
import com.home.gou.model.Trip;
import com.home.gou.model.User;
import com.home.gou.repository.PTripRepository;
import com.home.gou.repository.TripRepository;
import com.home.gou.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    PTripRepository pTripRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PTripService pTripService;


    @Autowired
    private ModelMapper modelMapper;

    public List<Trip> findAllTrips() {
        List<TripEntity> tripEntityList = tripRepository.findAllCurrent();
        List<Trip> trips = tripEntityList.stream().map(tripEntity ->{
                Trip trip = convert(tripEntity);
                User driver = userService.findUserbyId(trip.getUserCarId());
                trip.setDriver(driver);
                return trip;
            }
        ).collect(Collectors.toList());
        return trips;
    }

    public Trip findTripById(int id) {
        List<TripEntity> tripEntities = tripRepository.findById(id);

        Trip trip =  modelMapper.map(tripEntities.get(0),Trip.class);
        User driver = userService.findUserbyId(trip.getUserCarId());
        trip.setDriver(driver);
        return trip;
    }

    public Trip convert(TripEntity tripEntity){
        return modelMapper.map(tripEntity,Trip.class);
    }
    public PTrip convert(PassengersTripEntity passengersTripEntity){
        return modelMapper.map(passengersTripEntity,PTrip.class);
    }


    public void saveTrip(Trip trip) {
        TripEntity tripEntity = modelMapper.map(trip,TripEntity.class);
        tripRepository.save(tripEntity);
    }

    public List<Trip> getDriverTrips(int driverId) {
        List<TripEntity> tripEntityList = tripRepository.findByUserCarId(driverId);


        List<Trip> trips = tripEntityList.stream().map(tripEntity -> {

                Trip trip = convert(tripEntity);
                trip.setPassengerList(pTripService.findPassengersByTripId(trip.getTripId()));
                return trip;
            }
        ).collect(Collectors.toList());
        return trips;
    }

//    public List<Trip> getBuyerTrips(int passengerId) {
//
//        List<PassengersTripEntity> passengersTripEntities = pTripRepository.findByUserId(passengerId);
//
//        List<PTrip> pTrips = passengersTripEntities.stream().map(passengersTripEntity -> convert(passengersTripEntity)
//        ).collect(Collectors.toList());
//
//        List<Trip> trips = pTrips.stream().map( pTrip ->findTripById(pTrip.getTripId())).collect(Collectors.toList());
//        return trips;
//    }
}
