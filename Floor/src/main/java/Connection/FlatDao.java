package Connection;
import java.sql.SQLException;
import java.util.List;

public interface FlatDao {
    void createTable();

    void addFlats(String region, int square, String adress, int rooms, int price) throws SQLException;

    List <Flat> getAll();
}
