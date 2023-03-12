package Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoreq implements FlatDao {
    private final Connection conn;

    public ClientDaoreq(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createTable() {
        try (Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Flat");
            st.execute("CREATE TABLE  Flat (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,region VARCHAR(100) NOT NULL, square INT NOT NULL ,adress VARCHAR(100) NOT NULL,rooms INT NOT NULL, price INT NOT NULL ) ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addFlats(String region, int square, String adress, int rooms, int price) throws SQLException {
        try (PreparedStatement pr = conn.prepareStatement("INSERT INTO Flat (region, square, adress, rooms, price) VALUES (?, ?, ?, ?, ?)")) {
            pr.setString(1, region);
            pr.setInt(2, square);
            pr.setString(3, adress);
            pr.setInt(4, rooms);
            pr.setInt(5, price);
            pr.executeUpdate();
        }
    }

    @Override
    public List<Flat> getAll() {
        List<Flat> list = new ArrayList<>();
        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT  * FROM Flat")) {
                    while (rs.next()) {
                        Flat flat = new Flat();
                        flat.setId(rs.getInt(1));
                        flat.setRegion(rs.getString(2));
                        flat.setSquare(rs.getInt(3));
                        flat.setAdress(rs.getString(4));
                        flat.setRooms(rs.getInt(5));
                        flat.setPrice(rs.getInt(6));

                        list.add(flat);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
