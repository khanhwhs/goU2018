package com.home.gou.controller;

import com.home.gou.model.Request;
import com.home.gou.model.Trip;
import com.home.gou.model.User;
import com.home.gou.service.RequestService;
import com.home.gou.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping(value="/getRequestsByUserId")
    public List<Request> getAllTrips(@RequestParam int userId){
        return requestService.findByUserId(userId);
    }

    @GetMapping(value="/createRequest")
    public void createRequest(@RequestBody Request request){
        requestService.createRequest(request);
    }
}
