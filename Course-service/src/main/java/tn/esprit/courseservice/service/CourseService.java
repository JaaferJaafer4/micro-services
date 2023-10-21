package tn.esprit.courseservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tn.esprit.courseservice.dto.CourseDescription;
import tn.esprit.courseservice.dto.Event;
import tn.esprit.courseservice.dto.User;
import tn.esprit.courseservice.model.Course;
import tn.esprit.courseservice.repository.CourseRepository;

import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class CourseService {
    private CourseRepository courseRepository;

    private WebClient.Builder webClientBuilder;

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


    public List<Course> getCoursesbyCalendar(long calendarId)
    {
        return courseRepository.findCourseByCalendarId(calendarId);
    }


    public CourseDescription getDescription(long courseId)
    {
        Course course = courseRepository.findById(courseId).orElse(null);
        if( course != null)
        {
            if(course.getIdCourse() != 0)
            {
                Event event = getEventById(course.getCalendarId());
                String[] organiser_data = getOrganiser(event.getOrganizer());
                log.info(event.toString());
                if(event != null)
                {
                  return CourseDescription.builder()
                          .description(course.getDescription())
                          .title(course.getTitle())
                          .startDate(event.getStartDate())
                          .endDate(event.getEndDate())
                          .organiser_name(organiser_data[0])
                          .organiser_email(organiser_data[1])
                          .participants(getParticipants(event.getParticipants()))
                          .build();
                }
            }
        }
            return null;
    }

    public boolean addCourseToCalendar(long courseId,long calendarId)
    {
        Course course = courseRepository.findById(courseId).orElse(null);
        Event event = getEventById(calendarId);
        if(event != null && course != null)
        {
            course.setCalendarId(event.getEventId());
            courseRepository.save(course);
            return true;
        }
        return false;
    }

    private Event getEventById(long eventId)
    {
        return webClientBuilder.build().get()
            .uri("http://calendar-service/calendar/"+eventId)
            .retrieve()
            .bodyToMono(Event.class)
            .block();
    }

    private List<String> getParticipants(Set<Long> participantsId)
    {
      List<String> users = new ArrayList<>();
      for(Long id : participantsId)
      {
          User user = webClientBuilder.build().get()
                  .uri("http://user-service/user/"+id)
                  .retrieve()
                  .bodyToMono(User.class)
                  .block();
          if(user != null)
              users.add(user.getUsername());
      }
      return users;
    }

    private String[] getOrganiser(long organiserId)
    {

        User user = webClientBuilder.build().get()
                .uri("http://user-service/user/"+organiserId)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        if(user != null)
            return new String[]{user.getUsername(),user.getEmail()};
      return null;
    }


  /*  public List<Event> calendars()
    {
        Event[] events = webClientBuilder.build().get()
                .uri("http://calendar-service/calendar")
                .retrieve()
                .bodyToMono(Event[].class)
                .block();
        return new ArrayList<>(Arrays.asList(events));
    }*/
}
