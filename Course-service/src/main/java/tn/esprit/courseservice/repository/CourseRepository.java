package tn.esprit.courseservice.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.courseservice.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course,Long> {

    List<Course> findCourseByCalendarId(long id);
}
