package com.HH.Hello_Events.Services;

import com.HH.Hello_Events.Model.Entity.Client;
import com.HH.Hello_Events.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl  implements  ClientService{

    @Autowired
    private   ClientRepository clientRepository;
    @Override
    public List<Client> getAllclients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);

    }
}
