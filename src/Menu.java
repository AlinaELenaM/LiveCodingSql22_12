import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {
    final String url = "jdbc:mysql://localhost:3306/newdb";
    final String user = "root";
    final String password = "Hulkhugan92!";

    private Integer menuId;

    private String name;

    private String type;

    public Menu (Integer menuId, String name, String type) {
        this.menuId = menuId;
        this.name = name;
        this.type = type;
    };


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

    public void insertIntoTable () throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String insertQuery =
                """ 
                 INSERT INTO menu (name, tipo)
                 VALUES ('""" + this.name + "', '" + this.type + "');";
        statement.executeUpdate(insertQuery);
        System.out.println("Insert fields name and type!");
        statement.close();
    }


}
