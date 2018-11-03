package com.home.gou.service;

import com.home.gou.entity.UserEntity;
import com.home.gou.model.Trip;
import com.home.gou.model.User;
import com.home.gou.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Cacheable("Users")
    public List<User> findAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();


        List<User> users = userEntityList.stream().map(userEntity -> convert(userEntity)
        ).collect(Collectors.toList());
        return users;
    }

    public User convert(UserEntity userEntity ){
        return modelMapper.map(userEntity,User.class);
    }


    public void saveUser( User user){
        UserEntity userEntity = modelMapper.map(user,UserEntity.class);
        userRepository.save(userEntity);
    }

    public boolean isUser(String userName, String userPassword){
        List<UserEntity> userEntityList = userRepository
                .findByUserNameAndUserPassword(userName,userPassword);

        return (userEntityList.size() >= 1);

    }

    public User findUserbyUserName(String userName, String userPassword){
        List<UserEntity> userEntityList = userRepository
                .findByUserNameAndUserPassword(userName,userPassword);

        if (userEntityList.size() == 1){
            return modelMapper.map(userEntityList.get(0),User.class);
        }
        return null;
    }

    public User findUserbyId(int id){
        UserEntity userEntity= userRepository.findByUserId(id);

        return modelMapper.map(userEntity,User.class);
    }
}
