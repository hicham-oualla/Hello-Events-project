package com.HH.Hello_Events.Repository;

import com.HH.Hello_Events.Model.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findClientByEmail(String email);

    @Query("SELECT COUNT  (*) from  Client ")
    long countClients();

}
