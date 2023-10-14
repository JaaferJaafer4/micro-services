package tn.esprit.userservice.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import tn.esprit.userservice.models.User;
import tn.esprit.userservice.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserController {
    final IUserService userService;

    @PutMapping
    public User add_or_update(@RequestBody User user){
       return userService.add_or_update(user);
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") long id)
    {
        return userService.delete(id);
    }

    @GetMapping
    public List<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") long id)
    {
        return userService.getById(id);
    }
}
