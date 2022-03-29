package com.azeem.demo.services;

import com.azeem.demo.dto.EventsDTO;
import com.azeem.demo.entity.Events;

import java.util.List;

public interface EventsService {
    List<Events> listEvents();
    Events getEventById(int id);
    Events saveEvent(Events event);
    void deleteEvent(int id);
    List<EventsDTO> getAllEvents();
}
