package org.dmitrydunai.services;

import org.dmitrydunai.contacts.Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CSVSerialization implements ContactService{
    private final File file = new File("Contacts.csv");
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
        openFile();
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
        if(file.exists()) {
            contacts = null;
            try (FileReader is = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(is);
                contacts = bufferedReader.lines()
                        .map(l -> l.split(","))
                        .map(a -> new Contact(a[0], a[1]))
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFile() {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter("Contacts.csv"))) {
            System.out.println(contacts);
            for (Contact contact : contacts) {
                bufferedWriter.write(contact.toString()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}