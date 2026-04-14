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

    public static void main(String[] args) {
        db database = new db();
        database.download();
    }

    public void upload(String input) {
        try {
            // Treiber explizit laden
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Try-with-resources für automatisches Schließen
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO inputs (input) VALUES (?)")) {
                stmt.setString(1, input);
                stmt.executeUpdate();
                System.out.println("Eingabe erfolgreich hochgeladen!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL-Treiber nicht gefunden: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Fehler beim Hochladen: " + e.getMessage());
        }
    }

    public void download() {
        try {
                // Treiber explizit laden
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Try-with-resources für automatisches Schließen
                try (Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement stmt = conn.prepareStatement("SELECT input FROM inputs")) {
                    var rs = stmt.executeQuery();
                    while (rs.next()) {
                        String input = rs.getString("input");
                        System.out.println("Eingabe: " + input);
                    }
                }
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL-Treiber nicht gefunden: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Fehler beim Herunterladen: " + e.getMessage());
            }
    }
}