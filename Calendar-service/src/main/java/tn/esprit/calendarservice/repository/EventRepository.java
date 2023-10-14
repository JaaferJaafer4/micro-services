package tn.esprit.calendarservice.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.calendarservice.model.Event;

public interface EventRepository extends CrudRepository<Event,Long> {
}
