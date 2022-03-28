package com.galvanize.flights;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class FlightController {
    @PostMapping("/flights/tickets/total")
    public HashMap<String, Integer> getTicketTotal (@RequestBody Flight flight){

   //     List<Ticket> tickets;
        System.out.println(flight.toString());
        flight.getTickets();

   int sum = 0;
        for (Ticket ticket : flight.getTickets())
        {
            sum += ticket.getPrice();
//            int sumTotal = ticket.getPrice() + sum;
//                sum = sumTotal;
        }

        HashMap<String, Integer> responseMap = new HashMap<>();
        responseMap.put("result",sum);
        return responseMap;
    }
}
