package com.home.gou.controller;

import com.home.gou.model.PTrip;
import com.home.gou.model.User;
import com.home.gou.service.PTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class PTripController {

    @Autowired
    PTripService pTripService;

    @PostMapping(value="/addPTrip")
    public void addTrip(@RequestBody PTrip trip
    ){
        pTripService.addTrip(trip);
    }

    @DeleteMapping(value="/deletePtrip")
    public void deleteTip(@RequestParam int userId, @RequestParam int tripId){
        pTripService.deleteTripById(userId, tripId);
    }
}
