package tn.esprit.userservice.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.userservice.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
