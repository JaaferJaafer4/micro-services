package tn.esprit.userservice.services;

import tn.esprit.userservice.dto.AuthenticationRequest;
import tn.esprit.userservice.models.User;

import java.util.List;

public interface IUserService {
    User add_or_update(User user);
    boolean delete(long id);
    List<User> getAll();
    User getById(long id);
    String authenticate(AuthenticationRequest authenticationRequest);
}
