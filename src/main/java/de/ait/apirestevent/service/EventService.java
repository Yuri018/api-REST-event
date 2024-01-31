package de.ait.apirestevent.service;

import de.ait.apirestevent.dto.EventDto;
import de.ait.apirestevent.dto.NewEventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    List<EventDto> getAllEvents();
    EventDto addEvent(NewEventDto newEvent);
}
