package de.ait.apirestevent.dto;

import de.ait.apirestevent.entity.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Event", description = "Event info")
public class EventDto {
    @Schema(description = "Event ID", example = "1")
    private Long id;
    @Schema(description = "Event name", example = "Event 1")
    private String name;
    @Schema(description = "Event description", example = "This is a new event")
    private String description;
    @Schema(description = "Event date", example = "01.01.2024")
    private LocalDate date;

    public static EventDto from(Event event){
        return new EventDto(event.getId(), event.getName(), event.getDescription(), event.getDate());
    }

    public static List<EventDto> from(List<Event> events){
        return events.stream()
                .map(EventDto::from)
                .collect(Collectors.toList());
    }
}
