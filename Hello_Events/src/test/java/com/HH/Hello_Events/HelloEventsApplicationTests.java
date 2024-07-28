package com.HH.Hello_Events;

import com.HH.Hello_Events.Model.Entity.Contact;
import com.HH.Hello_Events.Model.Entity.Event;
import com.HH.Hello_Events.Repository.ContactRepository;
import com.HH.Hello_Events.Repository.EventRepository;
import com.HH.Hello_Events.Services.ContactServiceImpl;
import com.HH.Hello_Events.Services.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class HelloEventsApplicationTests {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    private Contact contact;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contact = new Contact();
        contact.setId(1);
        contact.setName("John Doe");
        contact.setEmail("john.doe@example.com");
        contact.setMessage("Hello, I am interested in your events.");
    }

    @Test
    void testCreateContact() {
        when(contactRepository.save(any(Contact.class))).thenReturn(contact);
        Contact createdContact = contactService.createContact(contact);
        assertNotNull(createdContact);
        assertEquals(contact.getName(), createdContact.getName());
    }

    @Test
    void testGetContactById() {
        when(contactRepository.findById(1)).thenReturn(Optional.of(contact));
        Contact fetchedContact = contactService.getContactById(1);
        assertNotNull(fetchedContact);
        assertEquals(contact.getName(), fetchedContact.getName());
    }

    @Test
    void testGetAllContacts() {
        List<Contact> contacts = Arrays.asList(contact, new Contact());
        when(contactRepository.findAll()).thenReturn(contacts);
        List<Contact> fetchedContacts = contactService.getAllContacts();
        assertEquals(2, fetchedContacts.size());
    }

//    @Test
//    void testUpdateContact() {
//        when(contactRepository.existsById(1)).thenReturn(true);
//        when(contactRepository.save(any(Contact.class))).thenReturn(contact);
//
//        Contact updatedContact = new Contact();
//        updatedContact.setName("Jane Doe");
//        updatedContact.setEmail("jane.doe@example.com");
//        updatedContact.setMessage("Updated message");
//
//        Contact editedContact = contactService.updateContact(1, updatedContact);
//        assertNotNull(editedContact);
//        assertEquals("Jane Doe", editedContact.getName());
//    }

    @Test
    void testDeleteContact() {
        doNothing().when(contactRepository).deleteById(1);
        contactService.deleteContact(1);
        verify(contactRepository, times(1)).deleteById(1);
    }

    @Test
    void testCountContact() {
        when(contactRepository.countContact()).thenReturn(2L);
        Long contactCount = contactService.countContact();
        assertEquals(2L, contactCount);
    }
}



