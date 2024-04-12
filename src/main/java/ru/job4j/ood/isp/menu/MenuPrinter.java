package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public interface MenuPrinter {

    void print(Menu menu);

    class SimpleMenuPrinter implements MenuPrinter {

        @Override
        public void print(Menu menu) {
            Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
            while (iterator.hasNext()) {
                StringBuilder result = new StringBuilder();
                Menu.MenuItemInfo itemInfo = iterator.next();
                String number = itemInfo.getNumber();
                for (int i = 0; i < number.length() - 2; i++) {
                    result.append(" ");
                }
                System.out.println(result.append(number).append(itemInfo.getName()));
            }
        }
    }
}