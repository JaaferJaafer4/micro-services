package tn.esprit.calendarservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tn.esprit.calendarservice.dto.Course;
import tn.esprit.calendarservice.dto.User;
import tn.esprit.calendarservice.model.Event;
import tn.esprit.calendarservice.repository.EventRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EventService {
    private EventRepository eventRepository;

    private WebClient.Builder webClientBuilder;

    public Event add_event(Event event)
    {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents()
    {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);
        return events;
    }

    public Event getbyId(long id)
    {
        return eventRepository.findById(id).orElse(null);
    }

    public void deleteEvent(long id)
    {
        eventRepository.deleteById(id);
    }


    public List<Event> getByUser(long userId)
    {
        User user = getById(userId);
        if(user != null)
        {
            if(user.getRole() == "SUPERVISOR")
            {
                return eventRepository.findAllByOrganizer(userId);
            }
            else
            {
                List<Event> events = new ArrayList<>();
                for (Event event : eventRepository.findAll())
                {
                    for (Long id :event.getParticipants())
                    {
                        if(id == userId)
                            events.add(event);
                    }
                }
                return events;
            }
        }
        return new ArrayList<>();
    }


   /* public List<Course> getCoursesForEvent(long eventId)
    {
        Course[] courses = webClientBuilder.build().get()
                .uri("http://course-service/byCal/"+eventId)
                .retrieve()
                .bodyToMono(Course[].class)
                .block();
        return new ArrayList<>(Arrays.asList(courses));
    }*/
    private User getById(long userId)
    {
        return webClientBuilder.build().get()
                .uri("http://user-service/user/"+userId)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
