package tn.esprit.calendarservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.calendarservice.model.Event;
import tn.esprit.calendarservice.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EventService {
    private EventRepository eventRepository;

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


}
