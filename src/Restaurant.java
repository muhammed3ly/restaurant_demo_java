import java.util.Vector;

public class Restaurant {
    private Vector<User> users;
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
                return users.elementAt(i);

        throw new IllegalAccessException("User Not Found!");
    }
    Restaurant()
    {
        users = new Vector<User>();
    }
}
