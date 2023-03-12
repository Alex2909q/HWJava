package Connection;

import java.util.List;

public interface GoodDao {


    void createTableGood();

    void addGood(int article, String name, int price) ;

    List<Good> getAllGoods();
}