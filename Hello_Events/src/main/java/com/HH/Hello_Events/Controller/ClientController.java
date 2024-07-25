package com.HH.Hello_Events.Controller;

import com.HH.Hello_Events.Model.Entity.Client;
import com.HH.Hello_Events.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/Admin")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/allclients")
    public List<Client> getAllClients() {
        return clientService.getAllclients();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }

}