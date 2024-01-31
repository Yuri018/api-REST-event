package de.ait.apirestevent.repository.impl;

import de.ait.apirestevent.entity.Event;
import de.ait.apirestevent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class EventRepositoryImpl implements EventRepository {

    private final DataSource dataSource;
    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return null;
    }

    @Override
    public void save(Event model) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Event model) {

    }

    @Override
    public Event findByName(String name) {
        return null;
    }
}
