package org.dmitrydunai.menu.actions;

import lombok.RequiredArgsConstructor;
import org.dmitrydunai.services.ContactService;
import org.dmitrydunai.ui.ContactView;

@RequiredArgsConstructor
public class SearchContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public void doAction() {
        String search = contactView.readSearch();
        contactView.writeContacts(contactService.searchContact(search));
    }

    @Override
    public String getName() {
        return "Search contact";
    }
}
