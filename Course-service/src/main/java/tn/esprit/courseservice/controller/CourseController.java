package tn.esprit.courseservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courseservice.dto.CourseDescription;
import tn.esprit.courseservice.dto.Event;
import tn.esprit.courseservice.model.Course;
import tn.esprit.courseservice.service.CourseService;

import java.util.Calendar;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins ="*")
public class CourseController {

    private CourseService courseService;

    @PutMapping("add")
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

    @GetMapping("byCal/{calendarId}")
    public List<Course> getCoursebyCalendar(@PathVariable("calendarId") long calendarId)
    {
        return courseService.getCoursesbyCalendar(calendarId);
    }
    @GetMapping("desc/{courseId}")
    public CourseDescription getDescription(@PathVariable("courseId") long courseId){
        return courseService.getDescription(courseId);
    }

    @PutMapping("addToCalendar/{courseId}/{calendarId}")
    public boolean addCourseToCalendar(@PathVariable("courseId") long courseId,@PathVariable("calendarId") long calendarId)
    {
        return courseService.addCourseToCalendar(courseId,calendarId);
    }
}
