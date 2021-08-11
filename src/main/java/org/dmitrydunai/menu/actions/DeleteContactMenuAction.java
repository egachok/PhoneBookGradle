package org.dmitrydunai.menu.actions;

import lombok.RequiredArgsConstructor;
import org.dmitrydunai.services.ContactService;
import org.dmitrydunai.ui.ContactView;

@RequiredArgsConstructor
public class DeleteContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public void doAction() {
        contactService.removeContact(contactView.readIndex());
        System.out.println("\nDeleted...\n");
    }

    @Override
    public String getName() {
        return "Remove contact";
    }
}
