package de.ait.apirestevent.repository.impl;

import de.ait.apirestevent.entity.Event;
import de.ait.apirestevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepositoryFileImpl implements EventRepository {

    public final String fileName;

    public EventRepositoryFileImpl(@Value("C:/Users/AIT TR Student/IdeaProjects/Backend/Spring/api-REST-event/events.txt") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(line -> line.split(","))
                    .map(parsed -> new Event (parsed[0]//преобразуем String to Long
                            , parsed[1], LocalDate.parse((parsed[2]))))
                    .collect(Collectors.toList());

        } catch (IOException e){
            throw new IllegalStateException("Problem with file.");
        }
    }

    @Override
    public void save(Event event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(event.getName() + "," + event.getDescription() + "," + event.getDate());
            writer.newLine();
        } catch (IOException e){
            throw new IllegalStateException("Can't write to file: " + e.getMessage());
        }

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Event model) {

    }

    @Override
    public Event findByName(String name) {
        return null;
    }
}
