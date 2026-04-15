import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
CREATE TABLE inputs (
id INT NOT NULL AUTO_INCREMENT,
input TEXT
);
*/

public class db {
    String url = "jdbc:mysql://140.238.172.216:3306/elternabend";
    String user = "ubuntu";
    String password = "dildodo64";

    public void upload(String input) {
        try {
            // Treiber explizit laden
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Try-with-resources für automatisches Schließen
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO inputs (input) VALUES (?)")) {
                stmt.setString(1, input);
                stmt.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL-Treiber nicht gefunden: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Fehler beim Hochladen: " + e.getMessage());
        }
    }

    public String[] download() {
        try {
                // Treiber explizit laden
                Class.forName("com.mysql.cj.jdbc.Driver");
                String[] ablage = new String[10];
                // Try-with-resources für automatisches Schließen
                try (Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmt = conn.prepareStatement("SELECT input FROM inputs ORDER BY id DESC LIMIT 10")) {
                    var rs = stmt.executeQuery();
                    int i = 0;
                    while (rs.next() && i < 10) {
                        String input = rs.getString("input");
                        ablage[i] = input;
                        i++;
                    }
                    return ablage;
                }
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL-Treiber nicht gefunden: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Fehler beim Herunterladen: " + e.getMessage());
            }
        return null;
    }
}