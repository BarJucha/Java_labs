import java.sql.*;
import java.io.File;

public class z1 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Podaj nazwę pliku bazy danych jako argument.");
            return;
        }

        String dbName = args[0];

        String url = "E:/Java/Programy Java/lab12/";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Błąd podczas wczytywania sterownika JDBC: " + e.getMessage());
            return;
        }


        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + url + dbName)) {
            System.out.println("Połączenie z bazą danych zostało ustanowione.");

        } catch (SQLException e) {
            System.err.println("Błąd podczas nawiązywania połączenia z bazą danych: " + e.getMessage());
        }
    }
    
}

