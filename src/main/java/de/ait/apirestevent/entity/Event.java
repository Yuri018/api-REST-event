package de.ait.apirestevent.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Event {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
}
