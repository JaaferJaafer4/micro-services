package tn.esprit.courseservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.courseservice.model.Course;
import tn.esprit.courseservice.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CourseService {
    private CourseRepository courseRepository;

    public Course add_course(Course course)
    {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses()
    {
        List<Course> events = new ArrayList<>();
        courseRepository.findAll().forEach(events::add);
        return events;
    }

    public Course getbyId(long id)
    {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(long id)
    {
        courseRepository.deleteById(id);
    }
}
