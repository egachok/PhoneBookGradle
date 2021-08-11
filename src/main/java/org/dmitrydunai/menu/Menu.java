package org.dmitrydunai.menu;

import org.dmitrydunai.menu.actions.MenuAction;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<MenuAction> menuActions;
    Scanner scanner;
    public Menu(List menuActions , Scanner scanner){
        this.menuActions = menuActions;
        this.scanner = scanner;
    }
    public void run(){
        while (true) {
            System.out.println("Phone book menu:");
            for (int i = 0; i <= menuActions.size(); i++) {
                if (i < menuActions.size()) System.out.printf("%d - %s\n", i+1, menuActions.get(i).getName());
                else {
                    System.out.printf("%d - Exit\n", i+1);
                }
            }

            System.out.println("\nEnter your choice: ");
            int choice =scanner.nextInt() ;
            scanner.nextLine();
            if(--choice < menuActions.size()){
                menuActions.get(choice).doAction();
            }
            else break;

        }
    }
}