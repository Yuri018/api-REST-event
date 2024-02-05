package de.ait.apirestevent.controller;

import de.ait.apirestevent.dto.EventDto;
import de.ait.apirestevent.dto.NewEventDto;
import de.ait.apirestevent.dto.UpdateEventDto;
import de.ait.apirestevent.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
//@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Operation(summary = "Get all events", description = "For admin only ")
    @GetMapping()
//    @ResponseBody
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Operation(summary = "Add new event", description = "For Admin only")
    @PostMapping()
//    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto add(@RequestBody NewEventDto newEvent) {
        return eventService.addEvent(newEvent);
    }

    @Operation(summary = "Get event by ID", description = "Availeble for all events")
    @GetMapping("/{event-id}")
    public EventDto getEventById(@Parameter(description = "event id", example = "2")
                                 @PathVariable("event-id") Long id) {
        return eventService.getEvent(id);
    }

    @Operation(summary = "Delete event", description = "For Admin only")
    @DeleteMapping("/{event-id}")
    public EventDto deleteEvent(@Parameter(description = "event id", example = "3")
                                @PathVariable("event-id") Long id) {
        return eventService.deleteEvent(id);
    }

    @Operation(summary = "Update event", description = "For Admin only")
    @PutMapping("/{event-id}")
    public EventDto updateEvent(@Parameter(description = "event id", example = "3")
                                @PathVariable("event-id") Long id,
                                @RequestBody UpdateEventDto updateEvent) {

        return eventService.updateEvent(id, updateEvent);
    }

}
