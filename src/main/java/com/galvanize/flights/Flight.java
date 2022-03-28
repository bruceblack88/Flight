package com.galvanize.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public class Flight {
    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Flight() {
    }

    @Override
    public String toString() {
        return "Flight{" +
                "tickets=" + tickets +
                '}';
    }
}
