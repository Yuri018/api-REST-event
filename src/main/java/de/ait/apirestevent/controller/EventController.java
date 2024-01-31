package de.ait.apirestevent.controller;

import de.ait.apirestevent.dto.EventDto;
import de.ait.apirestevent.dto.NewEventDto;
import de.ait.apirestevent.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all events", description = "For admin only ")
    @GetMapping("/events")
    @ResponseBody
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Operation(summary = "Add new event", description = "For Admin only")
    @PostMapping("/events")
    @ResponseBody
    public EventDto add(@RequestBody NewEventDto newEvent) {
        return eventService.addEvent(newEvent);
    }

}
