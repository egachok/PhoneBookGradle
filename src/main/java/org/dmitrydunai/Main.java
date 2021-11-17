package org.dmitrydunai;

//import jdk.incubator.foreign.Addressable;
import org.dmitrydunai.menu.actions.*;
import org.dmitrydunai.services.*;
import org.dmitrydunai.services.ApiServices.ApiContactService;
import org.dmitrydunai.ui.ContactView;

//import java.awt.*;
//import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LoginMenuAction loginMenuAction = new LoginMenuAction("Login");
        Menu authMenu = new Menu(scanner, List.of(loginMenuAction, new ExitMenuAction("Exit")));
        authMenu.run();

        if (loginMenuAction.exit()) {
            ContactService contactService = new ApiContactService(loginMenuAction.getLogin(), loginMenuAction.getPassword());
            ContactView contactView = new ContactView(scanner);

            List<MenuAction> menuActionListList = List.of(new ShowAllContactMenuAction(contactService, contactView),
                    new AddContactMenuAction(contactService, contactView),
                    new SearchContactMenuAction(contactService, contactView),
                    new SearchByValueMenuAction(contactService, contactView, scanner),
                    new ExitMenuAction("Exit")
            );
            Menu menu = new Menu(scanner, menuActionListList);
            menu.run();
        }
    }
}
//        ContactView contactView = new ContactView(scanner);
//        ContactService contactService = new ByteSerialization();
//        ContactService contactService = new CSVSerialization();
//        ContactService contactService = new JSonSerialisation();
//        ContactService contactService = new XmlSerialization();
//        ContactService contactService = new InMemoryContactService();
//        List<Object> menuActions = Arrays.asList(
//                new ShowAllContactMenuAction(contactService, contactView),
//                new AddContactMenuAction(contactService, contactView),
//                new DeleteContactMenuAction(contactService, contactView),
//                new SearchContactMenuAction(contactService, contactView)
//        );

//        Menu menu = new Menu(menuActions, scanner);
//        menu.run();
//    }
//}