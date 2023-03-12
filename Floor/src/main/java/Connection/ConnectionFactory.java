package Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final ComboPooledDataSource dataF= new ComboPooledDataSource();
    private static boolean inited;
    public static Connection getConnection() throws SQLException {
        initialize();
        return dataF.getConnection();
    }

    private static void initialize(){
        if(inited) return;

        Properties props = new Properties();
        try {
            props.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
            dataF.setDriverClass(props.getProperty("db.driver"));
            dataF.setJdbcUrl(props.getProperty("db.url"));
            dataF.setUser(props.getProperty("db.user"));
            dataF.setPassword(props.getProperty("db.password"));
            inited = true;
        } catch (IOException e) {
           e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}
