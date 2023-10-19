package tn.esprit.calendarservice.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.calendarservice.model.Event;

import java.util.List;

public interface EventRepository extends CrudRepository<Event,Long> {

    List<Event> findAllByOrganizer(long organiserId);
}
