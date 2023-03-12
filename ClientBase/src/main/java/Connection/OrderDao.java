package Connection;

import java.util.List;

public interface OrderDao {
    void createTableOrder();

    void addOrder(String nameGood, int articleGood, int quantity, int phoneClient, String nameClient) ;

    List<Order> getAllOrders();
}
