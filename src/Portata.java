import java.sql.*;

public class Portata {
    final String url = "jdbc:mysql://localhost:3306/newdb";
    final String user = "root";
    final String password = "Hulkhugan92!";
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

    public void insertIntoTable () throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String insertQuery =
                """ 
                 INSERT INTO portata (name, price)
                 VALUES ('""" + this.name + "', '" + this.price + "');";
        statement.executeUpdate(insertQuery);
        System.out.println("Insert fields name and type!");
        statement.close();
    }


   public void genericAlterTable (String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String formattedQuery = "" + query + "";
        statement.executeUpdate(formattedQuery);
        System.out.println("Altered table");
        statement.close();
    }

    public void addPortataIntoMenu (String menuName) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int menu_id =0;
        String selectMenu = "SELECT menu_id FROM menu WHERE name='" +menuName +"';";
        ResultSet result = statement.executeQuery(selectMenu);
        while (result.next()) {
            menu_id = result.getInt("menu_id");
        }

       // String selectPortata = "SELECT menu_id FROM portata WHERE portata_id= " + this.portataId;


        String addMenuIntoPortata = "UPDATE portata SET menu_id = " +  menu_id + " WHERE portata_id=" +this.portataId +";";
        statement.executeUpdate(addMenuIntoPortata);
        System.out.println("YEEEEEE");
        connection.close();
    }
}
