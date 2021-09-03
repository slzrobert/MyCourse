package com.mycourse.backend.models.services;

import com.mycourse.backend.models.dto.UserDTO;
import com.mycourse.backend.models.entities.User;
import com.mycourse.backend.models.repositories.UserRepository;
import com.mycourse.backend.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAllUser(){
        return mapper.mapCollection(this.userRepository.findAll(), UserDTO.class);
    }

    @Transactional
    public UserDTO saveUser(UserDTO user){
        return mapper.generalMapper(
                this.userRepository.save(
                        mapper.generalMapper(user, User.class)
                ),
                UserDTO.class
        );
    }
}
