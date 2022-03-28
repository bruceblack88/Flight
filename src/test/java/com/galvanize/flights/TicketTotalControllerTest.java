package com.galvanize.flights;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TicketTotalControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void getTestTotal() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        HashMap<Passenger, Ticket> body = new HashMap<>();
        Passenger joe = new Passenger("Joe", "Star");
        Ticket joeTicket = new Ticket(joe, 200);
        Passenger bruce = new Passenger("Bruce", "Black");
        Ticket bruceTicket = new Ticket(bruce, 150);

        body.put(joe,joeTicket);
        body.put(bruce, bruceTicket);
        String jsonString = mapper.writeValueAsString(body);
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.TEXT_PLAIN)
                .content(jsonString);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("result: 350"));

    }
}
