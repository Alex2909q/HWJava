package Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderDaoReq implements OrderDao{
    private final Connection conn;

    public OrderDaoReq(Connection conn) {
        this.conn = conn;
    }

    public void createTableOrder() {
        try (
                Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Orders");
            st.execute("CREATE TABLE  Orders (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,nameGood VARCHAR(100) NOT NULL, articleGood INT NOT NULL,quantity INT NOT NULL, phoneClient INT NOT NULL,nameClient VARCHAR(100) NOT NULL ) ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(String nameGood, int articleGood, int quantity, int phoneClient, String nameClient) {
        try (PreparedStatement pr = conn.prepareStatement("INSERT INTO Orders (nameGood,articleGood, quantity, phoneClient, nameClient) VALUES (?, ?, ?, ?,?)")) {
            pr.setString(1, nameGood);
            pr.setInt(2, articleGood);
            pr.setInt(3, quantity);
            pr.setInt(4, phoneClient);
            pr.setString(5, nameClient);

            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> listO = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Orders")){
                    while (rs.next()){
                        Order order = new Order();
                        order.setId(rs.getInt(1));
                        order.setNameGood(rs.getString(2));
                        order.setArticleGood(rs.getInt(3));
                        order.setQuantity(rs.getInt(4));
                        order.setPhoneClient(rs.getInt(5));
                        order.setNameClient(rs.getString(6));

                        listO.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listO;
    }


}
