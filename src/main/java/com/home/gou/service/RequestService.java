package com.home.gou.service;

import com.home.gou.entity.RequestEntity;
import com.home.gou.model.Request;
import com.home.gou.repository.RequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Request> findByUserId(int id){
        List<RequestEntity> entityList = new ArrayList<>();
        entityList = requestRepository.findByRequesterId(id);

        List<Request> requests = entityList.stream().map(userEntity -> convert(userEntity)
        ).collect(Collectors.toList());
        return requests;
    }

    public Request convert(RequestEntity requestEntity ){
        return modelMapper.map(requestEntity,Request.class);
    }

    public void createRequest(Request request){
        RequestEntity requestEntity= modelMapper.map(request,RequestEntity.class);
        requestRepository.save(requestEntity);
    }
}
