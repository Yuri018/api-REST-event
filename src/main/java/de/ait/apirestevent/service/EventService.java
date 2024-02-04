package de.ait.apirestevent.service;

import de.ait.apirestevent.dto.EventDto;
import de.ait.apirestevent.dto.NewEventDto;
import de.ait.apirestevent.dto.UpdateEventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    List<EventDto> getAllEvents();
    EventDto addEvent(NewEventDto newEvent);
    EventDto getEvent(Long id);
    EventDto updateEvent(Long id, UpdateEventDto updateEvent);
    EventDto deleteEvent(Long id);
}
