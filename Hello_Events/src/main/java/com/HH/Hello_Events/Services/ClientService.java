package com.HH.Hello_Events.Services;

import com.HH.Hello_Events.Model.Entity.Client;
import com.HH.Hello_Events.Model.Entity.Event;

import java.util.List;

public interface ClientService {
    List<Client> getAllclients();
    void deleteClient(int id);


}
