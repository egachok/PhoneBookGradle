package org.dmitrydunai;

import org.dmitrydunai.menu.Menu;
import org.dmitrydunai.menu.actions.*;
import org.dmitrydunai.services.ContactService;
import org.dmitrydunai.services.InMemoryContactService;
import org.dmitrydunai.ui.ContactView;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactView contactView = new ContactView(scanner);
        ContactService contactService = new InMemoryContactService();
        List<MenuAction> menuActions = Arrays.asList(
                new ShowAllContactMenuAction(contactService, contactView),
                new AddContactMenuAction(contactService, contactView),
                new DeleteContactMenuAction(contactService, contactView),
                new SearchContactMenuAction(contactService, contactView)
        );

        Menu menu = new Menu(menuActions, scanner);
        menu.run();
    }
}