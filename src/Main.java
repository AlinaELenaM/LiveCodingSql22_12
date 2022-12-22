import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Portata portata = new Portata();

        try {
//            menu.createTableMenu();
//            portata.createTablePortata();
            portata.alterTableFk();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
