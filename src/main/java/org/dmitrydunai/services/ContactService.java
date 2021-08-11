package org.dmitrydunai.services;

import org.dmitrydunai.contacts.Contact;

import java.util.List;

public interface ContactService {
    List getAll();
    void removeContact(int index);
    void addContact(Contact contact);
    List searchContact(String search);
}