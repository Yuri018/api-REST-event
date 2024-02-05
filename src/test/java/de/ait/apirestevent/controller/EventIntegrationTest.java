package de.ait.apirestevent.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName(("Endpoint/events is working"))
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EventIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET/events")
    public class GetEvents {

        @Test
        @Sql(scripts = {"/sql/schema.sql", "/sql/data_insert.sql"})
        public void return_list_of_events() throws Exception {
            mockMvc.perform(get("api/events"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(3)))
                    .andExpect(jsonPath("$.[0].id", is(1)))
                    .andExpect(jsonPath("$.[1].name", is("event 1")));
        }
    }

    @Nested
    @DisplayName("POST/events")
    public class PostEvents {

        @Test
        @Sql(scripts = {"/sql/schema.sql", "/sql/data_insert.sql"})
        public void return_created_event() throws Exception {
            mockMvc.perform(post("/api/events").contentType("application/json")

                            .content("{\n" +
                                    "  \"Event id\": 1,\n" +
                                    "  \"Name\": \"New Event\",\n" +
                                    "  \"description\": \"Description 1\",\n" +
                                    "  \"date\": \"2024-01-01\"\n" +
                                    "}"))
                    .andExpect(jsonPath("$.id", is(4)))
                    .andExpect(status().isCreated());
        }
    }

}