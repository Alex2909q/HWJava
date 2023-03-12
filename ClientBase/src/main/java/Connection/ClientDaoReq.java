package Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoReq implements ClentDao {

    private final Connection conn;

    public ClientDaoReq(Connection conn) {
        this.conn = conn;
    }

    public void createTableClient() {
        try (
                Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Clients");
            st.execute("CREATE TABLE  Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,name VARCHAR(100) NOT NULL, sName VARCHAR(100) NOT NULL ,phone INT NOT NULL, city VARCHAR(100) NOT NULL ) ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(String name, String sName, int phone, String city) {
        try (PreparedStatement pr = conn.prepareStatement("INSERT INTO Clients (name, sName, phone, city) VALUES (?, ?, ?, ?)")) {
            pr.setString(1, name);
            pr.setString(2, sName);
            pr.setInt(3, phone);
            pr.setString(4, city);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAllClients() {
        List<Client> listC = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Clients")){
                    while (rs.next()){
                        Client client = new Client();
                        client.setId(rs.getInt(1));
                        client.setName(rs.getString(2));
                        client.setsName(rs.getString(3));
                        client.setPhone(rs.getInt(4));
                        client.setCity(rs.getString(5));

                        listC.add(client);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listC;
    }

    ;


}
