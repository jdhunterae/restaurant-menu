package restaurant;

public class Restaurant {
    public static void main(String[] args) {
        Menu menu = Menu.getSampleMenu();
        MenuItem item = new MenuItem("Chicken Ceasar Salad", "A simple tossed salad with either Grilled or Crispy Chicken.", MenuItem.MAIN_COURSE, 11.99);
        menu.addItem(item);

        System.out.println(menu);
        System.out.println(item);

        menu.removeItem(item);
        System.out.println(menu);
    }
}
