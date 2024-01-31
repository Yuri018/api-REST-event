package de.ait.apirestevent.repository;

import de.ait.apirestevent.entity.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository <Event> {
    Event findByName(String name);
}
