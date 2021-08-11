package org.dmitrydunai.services;

import org.dmitrydunai.contacts.Contact;

import java.util.List;
import java.util.ArrayList;

public class InMemoryContactService implements ContactService{

    List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> getAll() {
        return contacts;
    }

    @Override
    public void removeContact(int index) {
        contacts.remove(index);
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public List<Contact> searchContact(String search) {
        List<Contact> searches = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith(search)) {
                searches.add(contact);
            }
        }
        return searches;
    }
}