package com.HH.Hello_Events.Services;

import com.HH.Hello_Events.Model.Entity.Billet;
import com.HH.Hello_Events.Model.Entity.Client;
import com.HH.Hello_Events.Model.Entity.Event;
import com.HH.Hello_Events.Repository.BilletsRepository;
import com.HH.Hello_Events.Repository.ClientRepository;
import com.HH.Hello_Events.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BilletServiceImpl implements BilletService {

    @Autowired
    private BilletsRepository billetsRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EventRepository eventRepository;

    public Billet addBillet(Billet billet) {
        Client client = clientRepository.findById(billet.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Event event = eventRepository.findById(billet.getEvent().getId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        billet.setClient(client);
        billet.setEvent(event);

        return billetsRepository.save(billet);
    }
}



