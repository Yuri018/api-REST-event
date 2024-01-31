package de.ait.apirestevent.controller;

import de.ait.apirestevent.dto.EventDto;
import de.ait.apirestevent.dto.NewEventDto;
import de.ait.apirestevent.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
public class EventController {

    private final EventService eventService;

    @GetMapping("/events")
    @ResponseBody
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/events")
    @ResponseBody
    public EventDto add(@RequestBody NewEventDto newEvent) {
        return eventService.addEvent(newEvent);
    }

}
