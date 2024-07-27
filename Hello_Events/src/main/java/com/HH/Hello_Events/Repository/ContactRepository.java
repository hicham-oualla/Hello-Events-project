package com.HH.Hello_Events.Repository;
import com.HH.Hello_Events.Model.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}