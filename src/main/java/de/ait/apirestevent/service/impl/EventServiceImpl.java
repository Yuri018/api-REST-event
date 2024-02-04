package de.ait.apirestevent.service.impl;

import de.ait.apirestevent.dto.EventDto;
import de.ait.apirestevent.dto.NewEventDto;
import de.ait.apirestevent.dto.UpdateEventDto;
import de.ait.apirestevent.entity.Event;
import de.ait.apirestevent.repository.EventRepository;
import de.ait.apirestevent.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.apirestevent.dto.EventDto.from;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<EventDto> getAllEvents() {
        return from(eventRepository.findAll());
    }

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .name(newEvent.getName())
                .description(newEvent.getDescription())
                .date(newEvent.getDate())
                .build();
        eventRepository.save(event);
        return from(event);
    }

    @Override
    public EventDto getEvent(Long id) {
        return from(eventRepository.findById(id));
    }

    @Override
    public EventDto updateEvent(Long id, UpdateEventDto updateEvent) {
        Event eventForUpdate = eventRepository.findById(id);
        eventForUpdate.setName(updateEvent.getName());
        eventForUpdate.setDescription(updateEvent.getDescription());
        eventForUpdate.setDate(updateEvent.getDate());

        return from(eventForUpdate);
    }

    @Override
    public EventDto deleteEvent(Long id) {
        Event eventForDelete = eventRepository.findById(id);

        eventRepository.deleteById(id);

        return from(eventForDelete);
    }
}