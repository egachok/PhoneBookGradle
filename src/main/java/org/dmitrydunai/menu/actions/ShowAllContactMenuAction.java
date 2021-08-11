package org.dmitrydunai.menu.actions;

import lombok.RequiredArgsConstructor;
import org.dmitrydunai.services.ContactService;
import org.dmitrydunai.ui.ContactView;

@RequiredArgsConstructor
public class ShowAllContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public void doAction() {
        contactView.writeContacts(contactService.getAll());
    }

    @Override
    public String getName() {
        return "Show all contacts";
    }
}
