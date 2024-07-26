package com.HH.Hello_Events.Services;

import com.HH.Hello_Events.Model.Entity.Client;
import com.HH.Hello_Events.Model.Entity.Event;
import com.HH.Hello_Events.Repository.ClientRepository;
import com.HH.Hello_Events.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl  implements  ClientService{

    @Autowired
    private   ClientRepository clientRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Client> getAllclients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);

    }

    @Override
    public Long countClients() {
        return  clientRepository.countClients();
    }


}
