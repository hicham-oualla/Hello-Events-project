package com.HH.Hello_Events.Services;

import com.HH.Hello_Events.Model.Entity.Event;
import com.HH.Hello_Events.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;
    @Override
    public Event addEvent(Event event) {
        Event event1 = new Event();
        event1.setTitre(event.getTitre());
        event1.setLieu(event.getLieu());
        event1.setDate(event.getDate());
        event1.setCategorie(event.getCategorie());
        return eventRepository.save(event1);
    }



    public Event getEvent(int id) {
        return this.eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<Event> getEvent() {
        return eventRepository.findAll();
    }

}
