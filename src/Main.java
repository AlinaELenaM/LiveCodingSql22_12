import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(null,"Menu1","Carne");
        Portata portata = new Portata(1,"Pasta",23);

        try {
        /// menu.createTableMenu();
            // portata.createTablePortata();
           // portata.alterTableFk();
          //  menu.insertIntoTable();
          //  portata.genericAlterTable("ALTER TABLE newdb.portata MODIFY COLUMN menu_id int NULL;");
                  //  portata.insertIntoTable();
                portata.addPortataIntoMenu("Menu1");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
