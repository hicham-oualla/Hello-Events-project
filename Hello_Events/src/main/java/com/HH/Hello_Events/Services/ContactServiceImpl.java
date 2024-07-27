package com.HH.Hello_Events.Services;
import com.HH.Hello_Events.Model.Entity.Contact;
import com.HH.Hello_Events.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements Contactservice {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(int id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        return optionalContact.orElse(null);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact updateContact(int id, Contact contact) {
        if (contactRepository.existsById(id)) {
            contact.setId(id);
            // No need to fetch the old contact, just save the new one
            return contactRepository.save(contact);
        }
        return null;
    }

    @Override
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Long countContact() {
        return contactRepository.countContact();
    }
}