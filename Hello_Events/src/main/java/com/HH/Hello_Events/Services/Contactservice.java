package com.HH.Hello_Events.Services;

import com.HH.Hello_Events.Model.Entity.Contact;

import java.util.List;

public interface Contactservice {
    Contact createContact(Contact contact);
    Contact getContactById(int id);
    List<Contact> getAllContacts();
    Contact updateContact(int id, Contact contact);
    void deleteContact(int  id);
    Long countContact();
}
