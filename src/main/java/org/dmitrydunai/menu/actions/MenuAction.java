package org.dmitrydunai.menu.actions;

public interface MenuAction {
    void doAction();
    String getName();
    default boolean exit(){
        return false;
    }
}