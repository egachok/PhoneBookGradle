package org.dmitrydunai.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dmitrydunai.contacts.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class JSonSerialisation implements ContactService{

    private final File file = new File("Contacts.json");
    List<Contact> contacts = new ArrayList<>();


    @Override
    public List<Contact> getAll() {
        openFile();
        return contacts;
    }

    @Override
    public void removeContact(int index) {
        openFile();
        contacts.remove(index);

    }

    @Override
    public void addContact(Contact contact) {
//        openFile();
        contacts.add(contact);
        writeFile();
    }

    @Override
    public List<Contact> searchContact(String search) {
        openFile();
        List<Contact> searches = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith(search)) {
                searches.add(contact);
            }
        }
        return searches;
    }

    private void openFile() {
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                contacts.add(objectMapper.readValue(new FileReader(file), Contact.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (Contact contact : contacts) {
                objectMapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValue(new FileWriter(file), contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}