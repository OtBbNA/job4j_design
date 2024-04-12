package ru.job4j.ood.isp.menu;

import java.util.Optional;
import java.util.Scanner;

public class TodoApp {

    public static final String MENU = """
                Enter 1 to add a root element
                Enter 2 to add a sub-item
                Enter 3 to trigger action
                Enter 4 to list
                Enter any other number for withdrawal
            """;

    public static final ActionDelegate STUB_ACTION = () -> System.out.println("ACTION IS TRIGGERED");
    public static final String MENU_ENTER_NAME = "Enter name";
    public static final String MENU_ENTER_ROOT_NAME = "Enter a name for the root element";
    public static final String MENU_ENTER_CHILD_NAME = "Enter the name of the sub-element";

    public static void main(String[] args) {
        MenuPrinter menuPrinter = new MenuPrinter.SimpleMenuPrinter();
        Menu menu = new SimpleMenu();
        boolean switcher = true;
        Scanner scanner = new Scanner(System.in);
        while (switcher) {
            System.out.println(MENU);
            String nextScan = scanner.nextLine();
            if (nextScan.equals("1")) {
                System.out.println(MENU_ENTER_NAME);
                String name = scanner.nextLine();
                menu.add(Menu.ROOT, name, STUB_ACTION);
            } else if (nextScan.equals("2")) {
                System.out.println(MENU_ENTER_ROOT_NAME);
                String name = scanner.nextLine();
                System.out.println(MENU_ENTER_CHILD_NAME);
                String childName = scanner.nextLine();
                menu.add(name, childName, STUB_ACTION);
            } else if (nextScan.equals("3")) {
                System.out.println(MENU_ENTER_NAME);
                String name = scanner.nextLine();
                Optional<Menu.MenuItemInfo> item = menu.select(name);
                item.get().getActionDelegate().delegate();
            } else if (nextScan.equals("4")) {
                menuPrinter.print(menu);
            } else {
                switcher = false;
            }
            System.out.println();
        }
    }
}
