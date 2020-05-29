public class Meal {
    private static int mealsCount = 0;
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Meal(String name, double price)
    {
        mealsCount++;
        id = mealsCount;
        this.name = name;
        this.setPrice(price);
    }
}
