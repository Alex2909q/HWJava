package Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodDaoReq implements GoodDao {

        private final Connection conn;

        public GoodDaoReq(Connection conn) {
            this.conn = conn;
        }

        public void createTableGood() {
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS Goods");
                st.execute("CREATE TABLE  Goods (article INT NOT NULL PRIMARY KEY, name VARCHAR(100) NOT NULL ,price INT NOT NULL ) ");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void addGood (int article, String name, int price) {
            try (PreparedStatement pr = conn.prepareStatement("INSERT INTO Goods (article, name, price) VALUES (?, ?, ?)")) {
                pr.setInt(1, article);
                pr.setString(2, name);
                pr.setInt(3, price);
                pr.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Good> getAllGoods() {
            List<Good> listG = new ArrayList<>();

            try {
                try (Statement st = conn.createStatement()) {
                    try (ResultSet rs = st.executeQuery("SELECT * FROM Goods")){
                        while (rs.next()){
                           Good good = new Good();
                            good.setArticle(rs.getInt(1));
                            good.setName(rs.getString(2));
                            good.setPrice(rs.getInt(3));

                            listG.add(good);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return listG;
        }

        ;


    }


