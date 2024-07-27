package com.HH.Hello_Events.Controller;

import com.HH.Hello_Events.Services.ClientService;
import com.HH.Hello_Events.Services.Contactservice;
import com.HH.Hello_Events.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashbord")
public class DashbordController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private EventService eventService;
    @Autowired
    private Contactservice contactservice;


    @GetMapping("/clients")
    public Long countClients (){
        return clientService.countClients();
    }

    @GetMapping("/contacts")
    public Long countContacts(){
        return contactservice.countContact();
    }

    @GetMapping("/events")
    public Long countEvents(){
        return eventService.countEvents();
    }
}