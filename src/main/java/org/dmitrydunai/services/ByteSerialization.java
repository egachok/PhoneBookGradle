package org.dmitrydunai.services;

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
public class ByteSerialization implements ContactService {
    private final File file = new File("Contacts.obj");
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
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                contacts = (List<Contact>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFile() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(file, true))) {
            for (Contact contact : contacts) {
                out.writeObject(contact);
            }
            out.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Error file not found");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error with I/O processes");
            ex.printStackTrace();
        }
    }
}