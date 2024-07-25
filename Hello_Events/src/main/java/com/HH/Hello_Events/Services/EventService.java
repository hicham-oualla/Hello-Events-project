package com.HH.Hello_Events.Services;

import com.HH.Hello_Events.Model.Entity.Event;

import java.util.List;

public interface EventService {
    Event addEvent(Event event);
    Event getEvent(int id);
    List<Event> getEvent();
}
