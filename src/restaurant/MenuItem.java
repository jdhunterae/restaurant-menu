package restaurant;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MenuItem {
    public static final String MAIN_COURSE = "Main Course", APPETIZER = "Appetizer", DESSERT = "Dessert";
    public static final ArrayList<String> CATEGORIES = new ArrayList<>(Arrays.asList(APPETIZER, MAIN_COURSE, DESSERT));
    private static final DecimalFormat DF = new DecimalFormat("0.00");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
    private static final long DAY_IN_MS = 1000 * 60 * 60 * 24;
    private String name, description, category;
    private double price;
    private final Date created;
    private Date updated;


    public MenuItem() {
        this("Name", "Description", MAIN_COURSE, 0.00);
    }

    public MenuItem(String name, String description, String category, double price) {
        this.name = name;
        this.description = description;
        setCategory(category);
        this.price = price;

        created = getToday();
        updated = getToday();
    }

    @Override
    public String toString() {
        String text = String.format("%s : %s\n  ($%s)", name, description, DF.format(price));

        if (isNew()) {
            text = String.format("(NEW) %s", text);
        }
        return text;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        if (!CATEGORIES.contains(category)) {
            return;
        }

        this.category = category;
        this.updated = getToday();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updated = getToday();
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updated = getToday();
    }

    public boolean isNew() {
        Date cutoff = oneWeekBefore(getToday());
        return created.after(cutoff) || updated.after(cutoff);
    }

    private static Date parseDate(String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static Date oneWeekBefore(Date date) {
        return new Date(date.getTime() - (7 * DAY_IN_MS));
    }

    private static Date getToday() {
        try {
            return DATE_FORMAT.parse(String.format(
                    "%2d-%2d-%4d",
                    LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth(),
                    LocalDate.now().getYear()
            ));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
