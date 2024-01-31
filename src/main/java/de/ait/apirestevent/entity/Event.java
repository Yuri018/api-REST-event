package de.ait.apirestevent.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Event {
    private String name;
    private String description;
    private LocalDate date;
}
