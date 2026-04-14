import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
CREATE TABLE inputs (
id INT NOT NULL AUTO_INCREMET,
input TEXT
);
*/

public class db {
    public db() {
        String url = "jdbc:mysql://140.238.172.216:3306/elternabend";
        String user = "ubuntu";
        String password = "Dildodo64!";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Erfolgreich mit der Datenbank verbunden!");
            }
        } catch (SQLException e) {
            System.err.println("Verbindungsfehler: " + e.getMessage());
        }
    }

    public class void 
}