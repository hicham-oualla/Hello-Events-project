package com.HH.Hello_Events.Controller;

import com.HH.Hello_Events.Model.Entity.Event;
import com.HH.Hello_Events.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public Event addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping("/get")
    public Event getCompte(int id) {
        return this.eventService.getEvent(id);
    }
     @GetMapping("/getAll")
    public List<Event>getEvent(){
        return eventService.getEvent();
    }

    @DeleteMapping("/{id}")
    public void  deleteEvent(@PathVariable int id ){
        eventService.deleteEvent(id);
    }

    @PutMapping("/modify/{id}")
    public Event editEvent(@RequestBody Event event, @PathVariable("id") int id) {
        return eventService.editEvent(event, id);
    }


}
