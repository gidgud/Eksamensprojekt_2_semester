package com.example.eksamensprojekt_2_semester.service;

import com.example.eksamensprojekt_2_semester.model.User;
import com.example.eksamensprojekt_2_semester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

	public User getUserById(int id) {
		return userRepository.getUserById(id);
	}

}
