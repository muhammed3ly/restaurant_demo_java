import java.util.Vector;

public class Branch {
    private static int branchesCount = 0;
    private int blockNumber;
    private int id;
    private Vector<Order> orders;

    public int getBlockNumber() {
        return blockNumber;
    }

    public int getId() {
        return id;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Order getOrder(int id) throws IllegalAccessException
    {
        for(int i = 0 ; i < orders.size() ; i++)
        {
            if(orders.elementAt(i).getId() == id)
                return orders.elementAt(i);
        }
        throw new IllegalAccessException("This branch doesn't has this order id.");
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    public Branch(int blockNumber)
    {
        branchesCount++;
        id = branchesCount;
        this.blockNumber = blockNumber;
        orders = new Vector<Order>();
    }
}
