package tn.esprit.courseservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courseservice.model.Course;
import tn.esprit.courseservice.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("course")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;

    @PutMapping
    public Course addEvent(@RequestBody Course course)
    {
        return  courseService.add_course(course);
    }

    @GetMapping
    public List<Course> getAllEvents()
    {
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public Course getbyId(@PathVariable long id)
    {
        return  courseService.getbyId(id);
    }

    @DeleteMapping("{id}")
    public void deleteEvent(@PathVariable long id)
    {
        courseService.deleteCourse(id);
    }
}
