package com.home.gou.controller;

import com.home.gou.model.Car;
import com.home.gou.model.Trip;
import com.home.gou.model.User;
import com.home.gou.service.PTripService;
import com.home.gou.service.TripService;
import com.home.gou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class TripController {

    @Autowired
    TripService tripService;

    @Autowired
    PTripService pTripService;

    @GetMapping(value="/getAllTrips")
    public List<Trip> getAllTrips(){
        return tripService.findAllTrips();
    }

    @GetMapping(value="/getTrip")
    public Trip getTrip(@RequestParam int tripId){
        return tripService.findTripById(tripId);
    }

    @PostMapping(value="/addTrip")
    public void addTrip(@RequestBody Trip trip
    ){
        tripService.saveTrip(trip);
    }

    @GetMapping(value="/getDriverTrips")
    public List<Trip> getDriverTrips(@RequestParam int driverId){
        return tripService.getDriverTrips(driverId);
    }

    @GetMapping(value="/getPassengerTrips")
    public List<Trip> getPassengerTrips(@RequestParam int passId){
        return pTripService.findTripByUserId(passId);
    }

}
