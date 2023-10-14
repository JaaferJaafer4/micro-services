package tn.esprit.userservice.services;

import lombok.AccessLevel;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserService implements IUserService{
    final UserRepository userRepository;

    @Override
    public User add_or_update(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String authenticate(AuthenticationRequest authenticationRequest) {
        return null;
    }
}
