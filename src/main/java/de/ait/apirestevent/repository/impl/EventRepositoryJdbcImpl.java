package de.ait.apirestevent.repository.impl;

import de.ait.apirestevent.entity.Event;
import de.ait.apirestevent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class EventRepositoryJdbcImpl implements EventRepository {

    private static final String SQL_UPDATE_BY_ID = "update events set name = ?, set description = ?, set date = ?";
    private static final String SQL_SELECT_BY_ID = "select * from events where id = ?";
    private static final String SQL_SELECT_ALL = "select * from events";
    private static final String SQL_FIND_BY_NAME = "select * from events where name = ?";

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;


    private static final RowMapper<Event> EVENT_ROW_MAPPER = ((row, rowNum) -> {
        Long id = row.getLong("id");
        String name = row.getNString("name");
        String description = row.getNString("description");
        String date = String.valueOf(row.getDate("date"));

        return Event.builder()
                .id(id)
                .name(name)
                .description(description)
                .date(LocalDate.parse(date))
                .build();
    });


    @Override
    public Event findById(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, EVENT_ROW_MAPPER, id);
    }

    @Override
    public List<Event> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, EVENT_ROW_MAPPER);
    }

    @Override
    public void save(Event event) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id");

        jdbcInsert.withTableName("EVENTS");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", event.getName());
        parameters.put("description", event.getDescription());
        parameters.put("date", event.getDate());

        Long generatedId = jdbcInsert.executeAndReturnKey(parameters).longValue();
        event.setId(generatedId);

    }

    @Override
    public Event deleteById(Long id) {

        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, EVENT_ROW_MAPPER, id);
    }

    @Override
    public void update(Event event) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, event.getName(), event.getDescription(), event.getDate());
    }

    @Override
    public Event findByName(String name) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, EVENT_ROW_MAPPER, name);
    }
}
