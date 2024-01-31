package de.ait.apirestevent.repository;

import de.ait.apirestevent.entity.Event;


public interface EventRepository extends CrudRepository <Event> {
    Event findByName(String name);
}
