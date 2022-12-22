import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {
    final String url = "jdbc:mysql://localhost:3306/newdb";
    final String user = "developer";
    final String password = "passwordhere";

    public void createTableMenu() throws SQLException {

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String createMenuTableQuery = ""
                + "CREATE TABLE `menu` ( "
                + "  `menu_id` int NOT NULL AUTO_INCREMENT, "
                + "  `name` varchar(30) DEFAULT NULL, "
                + "  `tipo` varchar(30) DEFAULT NULL, "
                + "  PRIMARY KEY (`menu_id`) "
                + ")";
        statement.executeUpdate(createMenuTableQuery);
        System.out.println("Table Menu created!");
        statement.close();
    }
}
