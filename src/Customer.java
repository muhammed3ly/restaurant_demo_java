public class Customer extends User {
    private int blockNumber;
    private int ordersCount;

    public int getBlockNumber() {
        return blockNumber;
    }

    @Override
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    Customer(String mobileNumber, String name, String password, int blockNumber)
    {
        super(mobileNumber, name, password);
        ordersCount = 0;
        this.blockNumber = blockNumber;
    }
}
