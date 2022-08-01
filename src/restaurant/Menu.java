package restaurant;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public Menu(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public Menu(MenuItem[] items) {
        this.items = new ArrayList<>(Arrays.asList(items));
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("::: MENU :::\n");

        for (String cat : MenuItem.CATEGORIES) {
            text.append(String.format("::: %s :::\n", cat));

            for (MenuItem item : items) {
                if (item.getCategory().equals(cat)) {
                    text.append(String.format("%s\n", item));
                }
            }
        }

        return text.toString();
    }

    public static Menu getSampleMenu() {
        Menu menu = new Menu();

        menu.addItem(new MenuItem("Potato Skins", "Baked Potato Skins topped with cheese, bacon crumbles, and chives. Served with Sour Cream.", MenuItem.APPETIZER, 7.99));
        menu.addItem(new MenuItem("Mozzarella Sticks", "Breaded and fried mozzarella sticks. Served with Marinara dipping sauce.", MenuItem.APPETIZER, 8.99));

        menu.addItem(new MenuItem("Chicken Pesto", "Angel hair pasta topped with basil pesto sauce and grilled chicken.", MenuItem.MAIN_COURSE, 12.99));
        menu.addItem(new MenuItem("Cowboy Burger", "Quarter pound hamburger with provolone cheese, bacon and house barbeque sauce.", MenuItem.MAIN_COURSE, 9.99));

        menu.addItem(new MenuItem("Chocolate Cake", "Dark chocolate cake with buttercream frosting.", MenuItem.DESSERT, 4.99));
        menu.addItem(new MenuItem("Strawberry Shortcake", "Fluffy shortcake topped with whipped cream and strawberries.", MenuItem.DESSERT, 5.99));

        return menu;
    }
}
