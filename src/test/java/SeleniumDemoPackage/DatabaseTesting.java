package SeleniumDemoPackage;

import com.mongodb.connection.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DatabaseTesting {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.dbschema.MongoDbJdbcDriver");
        String URL = "jdbc:mongo://localhost:27017/student3";
        Connection jdbcConn = (Connection) DriverManager.getConnection(URL,"user","pass");
    }
}
