package org.dmitrydunai.menu.actions;

import lombok.RequiredArgsConstructor;
import org.dmitrydunai.services.ContactService;
import org.dmitrydunai.ui.ContactView;

@RequiredArgsConstructor
public class AddContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public void doAction() {
        System.out.println("Create a new contact:");
        contactService.addContact(contactView.readContact());
        System.out.println("\nAdded...\n");
    }

    @Override
    public String getName() {
        return "Add contact";
    }
}