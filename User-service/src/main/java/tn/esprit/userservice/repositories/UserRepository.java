package tn.esprit.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.userservice.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
