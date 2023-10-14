package tn.esprit.courseservice.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.courseservice.model.Course;

public interface CourseRepository extends CrudRepository<Course,Long> {
}
