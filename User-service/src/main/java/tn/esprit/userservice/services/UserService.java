package tn.esprit.userservice.services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.userservice.dto.AuthenticationRequest;
import tn.esprit.userservice.models.User;
import tn.esprit.userservice.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService{
    private final UserRepository userRepository;
    public User add_or_update(User user) {
        return userRepository.save(user);
    }


    public boolean delete(long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }


    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }




    public boolean authenticate(AuthenticationRequest authenticationRequest) {
        if(userRepository.findByEmailAndPassword(authenticationRequest.getEmail(), authenticationRequest.getPassword()).orElse(null) != null)
            return true;
        return false;
    }
}
