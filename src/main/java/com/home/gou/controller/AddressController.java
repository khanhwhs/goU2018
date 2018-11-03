package com.home.gou.controller;

import com.home.gou.model.Address;

import com.home.gou.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value="findAddressById")
    public List<Address> findAddressById(int id){
        return addressService.findById(id);
    }
}
