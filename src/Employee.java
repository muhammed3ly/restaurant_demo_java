public class Employee extends User {
    private double salary;

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setPassword(String password){
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    Employee(String mobileNumber, String name, String password, double salary)
    {
        super(mobileNumber, name, password);
        this.salary = salary;
    }
}
