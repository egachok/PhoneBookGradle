package org.dmitrydunai.services;

import org.dmitrydunai.contacts.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();
    void removeContact(int index);
    void addContact(Contact contact);
    List<Contact> searchContact(String search);
    List<Contact> searchByName(String name);
    List<Contact> searchByValue(String value);
}