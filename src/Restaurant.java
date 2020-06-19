import java.util.Vector;

public class Restaurant {
    DataLoader dataLoader;
    private static Restaurant ourRestaurant = null;
    private Vector<Meal> meals;
    private Vector<User> users;
    private User currentUser;
    private City city;
    public void addUser(User user) throws IllegalArgumentException
    {
        try {
            checkUser(user.getMobileNumber());
            users.add(user);
        }
        catch (Exception e)
        {
           throw new IllegalArgumentException("You can't be added!");
        }
    }

    private void checkUser(String mobileNumber){
        for(int i = 0 ; i < users.size() ; i++)
        {
            if(users.elementAt(i).getMobileNumber().equals(mobileNumber))
                throw new IllegalArgumentException("User found");
        }
    }

    public User login(String mobileNumber, String password) throws IllegalAccessException
    {
        for(int i = 0 ; i < users.size() ; i++)
            if(users.elementAt(i).getMobileNumber().equals(mobileNumber) && users.elementAt(i).getPassword().equals(password))
            {
                currentUser = users.elementAt(i);
                return users.elementAt(i);
            }

        throw new IllegalAccessException("User Not Found!");
    }

    public void addOrder(Vector<Meal> orderdMeals)
    {
        boolean discount = ((Customer)currentUser).hasDiscount();
        Order newOrder = new Order(currentUser.mobileNumber, orderdMeals, discount);
        int nearestBranchId = this.city.findNearestBranch(((Customer)currentUser).getBlockNumber());
        Vector<Branch>branches = city.getBranches();
        for(int i = 0 ; i < branches.size() ; i++)
        {
            if(nearestBranchId == branches.elementAt(i).getId())
            {
                branches.elementAt(i).addOrder(newOrder);
                ((Customer)currentUser).ordersCount++;
            }
        }
    }


    public static Restaurant getOurRestaurant() {
        if(ourRestaurant == null)
        {
            ourRestaurant = new Restaurant();
        }
        return ourRestaurant;
    }

    public Vector<Meal> getMeals(){
        return this.meals;
    }



    private Restaurant()
    {
        dataLoader = new DataLoader();
        this.meals = dataLoader.loadMeals();
        this.city = dataLoader.loadCity();
        users = new Vector<User>();
    }
}
