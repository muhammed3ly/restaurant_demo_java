import java.util.Vector;

public class Order {
    private static int ordersCount = 0;
    private int id;
    private String customerId;
    private Vector<Meal> meals;
    private double price;
    private boolean discount;

    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Vector<Meal> getMeals() {
        return meals;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public Order(String customerId, Vector<Meal> meals, boolean discount)
    {
        ordersCount++;
        id = ordersCount;
        this.customerId = customerId;
        this.meals = meals;
        this.discount = discount;
        price = 0.0;
        for(int i = 0 ; i < meals.size() ; i++)
            price += meals.elementAt(i).getPrice();
        if(discount == true)
            price *= 0.5;
    }
}
