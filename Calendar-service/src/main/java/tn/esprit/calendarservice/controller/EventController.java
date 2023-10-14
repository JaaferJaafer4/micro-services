package tn.esprit.calendarservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.calendarservice.model.Event;
import tn.esprit.calendarservice.service.EventService;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("calendar")
@AllArgsConstructor
public class EventController {
    private EventService eventService;
    @PostMapping("/add")
  public Event addEvent(@RequestBody Event event)
  {
      return  eventService.add_event(event);
  }
  @GetMapping("/all")
   public List<Event> getAllEvents()
  {
      return eventService.getAllEvents();
  }
  @GetMapping("get/id")

  public Event getbyId(@PathVariable long id)
  {
      return  eventService.getbyId(id);
  }
  @DeleteMapping("delete/id")

  public void deleteEvent(@PathVariable long id)
  {
      eventService.deleteEvent(id);
  }
  @PutMapping("/update")
    public Event updateEvent(@RequestBody Event event)
  {
    return  eventService.add_event(event);
  }

}