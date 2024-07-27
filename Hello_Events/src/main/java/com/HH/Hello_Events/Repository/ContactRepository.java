package com.HH.Hello_Events.Repository;
import com.HH.Hello_Events.Model.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("SELECT COUNT  (*) from      Contact ")
    long countContact();
}