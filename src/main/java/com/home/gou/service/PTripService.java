package com.home.gou.service;

import com.home.gou.entity.PtripEntity;
import com.home.gou.model.PTrip;
import com.home.gou.model.Trip;
import com.home.gou.model.User;
import com.home.gou.repository.PTripRepository;
import com.home.gou.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PTripService {
    @Autowired
    PTripRepository pTripRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    TripService tripService;

    @Autowired
    UserService userService;

    public void addTrip(PTrip trip){
        PtripEntity PtripEntity = modelMapper.map(trip,PtripEntity.class);
        pTripRepository.save(PtripEntity);

    }
    public PTrip convert(PtripEntity ptripEntity){
        PTrip pTrip = new PTrip(ptripEntity.getId(),ptripEntity.getTripId(),ptripEntity.getUserId());
//                modelMapper.map(ptripEntity,PTrip.class);
        return pTrip;
    }

    public List<Trip> findTripByUserId ( int userId){
        List<PtripEntity> ptripEntityList = pTripRepository.findByUserId(userId);
        List<PTrip> pTrips = ptripEntityList.stream().map(passengersTripEntity -> convert(passengersTripEntity)
        ).collect(Collectors.toList());

        List<Trip> trips = pTrips.stream().map(pTrip ->tripService.findTripById(pTrip.getTripId())).collect(Collectors.toList());
        return trips;
    }

    public void deleteTripById(int userId, int tripId) {
        pTripRepository.deleteByUserIdAndTripId(userId, tripId);
    }

    public List<User> findPassengersByTripId(int tripId){
        List<PtripEntity> ptripEntityList = pTripRepository.findByTripId(tripId);
        List<User> userList = ptripEntityList.stream().map( ptripEntity -> {
            User user= userService.findUserbyId(ptripEntity.getUserId());
            return user;
        }).collect(Collectors.toList());
        return userList;
    }
}
