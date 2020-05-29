public abstract class User {
    protected String mobileNumber;
    protected String name;
    protected String password;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword() {
        return password;
    }

    abstract public void setPassword(String password);

    abstract public void setName(String name);
    User(String mobileNumber, String name, String password)
    {
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.password = password;
    }
}
