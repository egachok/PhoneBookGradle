package org.dmitrydunai.ui;

import lombok.RequiredArgsConstructor;
import org.dmitrydunai.contacts.Contact;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class ContactView {
    private final Scanner scanner;

    public Contact readContact(){
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the number: ");
        String phone = scanner.nextLine();
        return new Contact().setName(name).setPhone(phone);
    }

    public void writeContact(Contact contact){
        System.out.printf("%-20s - %13s\n", contact.getName(), contact.getPhone());
    }

    public void writeContacts(List<Contact> contacts){
        System.out.println("Contacts");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. ",i+1);
            writeContact(contacts.get(i));
        }
        System.out.println("---------------------------------------");
    }

    public int readIndex(){
        System.out.print("Enter the number of the entry: ");
        int iter = scanner.nextInt();
        scanner.nextLine();
        return --iter;
    }

    public String readSearch(){
        System.out.print("Enter the beginning of the contact:");
        return scanner.nextLine();
    }
}