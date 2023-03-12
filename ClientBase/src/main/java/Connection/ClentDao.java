package Connection;

import java.util.List;

public interface ClentDao {

    void createTableClient();

    void addClient(String name, String sName, int phone, String city) ;

    List<Client> getAllClients();
}
