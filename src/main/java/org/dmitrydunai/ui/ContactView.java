package org.dmitrydunai.ui;

import lombok.RequiredArgsConstructor;
import org.dmitrydunai.contacts.Contact;
import org.dmitrydunai.contacts.ContactType;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class ContactView implements ContactViewInterface {
    private final Scanner scanner;

    @Override
    public void view(List<Contact> contactList) {
        for (Contact c : contactList) {
            System.out.printf("%d - %s [%s] : %s\n", c.getId(), c.getName(), c.getContactType().getName(), c.getValue());
        }
    }

    public Contact readContact(){
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the type of contact: ");
        ContactType type = null;
        while (type == null) {
            ContactType[] types = ContactType.values();
            for (int i = 0; i < types.length; i++) {
                System.out.printf("\t%d - %s \n", i + 1, types[i].getName());
            }
            System.out.print("-> ");
            int ch = scanner.nextInt() - 1;
            scanner.nextLine();
            if (ch < 0 || ch > types.length) {
                System.out.println("Try again");
                continue;
            }
            type = types[ch];
        }
        System.out.println("Enter the contact: ");
        String value = scanner.nextLine();
        return new Contact().setName(name).setContactType(type).setValue(value);
    }

    public void writeContact(Contact contact){
        System.out.printf("%-20s - %13s\n", contact.getName(), contact.getValue());
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