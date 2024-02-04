package de.ait.apirestevent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Update event", description = "Fields for update")
public class UpdateEventDto {
    @Schema(description = "Event name", example = "Event 1")
    private String name;
    @Schema(description = "Event description", example = "This is a update event")
    private String description;
    @Schema(description = "Event date", example = "01.01.2024")
    private LocalDate date;
}
