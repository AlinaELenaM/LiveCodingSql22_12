import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Portata {
    final String url = "jdbc:mysql://localhost:3306/newdb";
    final String user = "developer";
    final String password = "passwordhere";
    private String name;
    private Integer price;
    private Integer portataId;

    public Portata(Integer portataId, String name, Integer price){
        this.portataId = portataId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPortataId() {
        return portataId;
    }

    public void setPortataId(Integer portataId) {
        this.portataId = portataId;
    }

    public void createTablePortata() throws SQLException {

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String createTableQuery = ""
                + "CREATE TABLE `portata` ( "
                + "  `portata_id` int NOT NULL AUTO_INCREMENT, "
                + "  `name` varchar(30) DEFAULT NULL, "
                + "  `price` int DEFAULT NULL, "
                + "  PRIMARY KEY (`portata_id`) "
                + ")";
        statement.executeUpdate(createTableQuery);
        System.out.println("Table Portata created!");
        statement.close();
    }
    public void alterTableFk() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String alterTableAddColumnQuery = ""
                + "ALTER TABLE newdb.portata ADD menu_id INT NOT NULL;";


        String alterTableAddForeignKey = ""
                + "ALTER TABLE newdb.portata ADD CONSTRAINT portata_FK FOREIGN KEY (menu_id) REFERENCES newdb.menu(menu_id);";

        statement.executeUpdate(alterTableAddColumnQuery);
        statement.executeUpdate(alterTableAddForeignKey);

        System.out.println("Alter table done!");
        statement.close();
    }
}
