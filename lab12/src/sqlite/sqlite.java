package sqlite;

import java.sql.*;

public class sqlite {
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:E:/Java/Programy Java/lab12/baza.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            // tworzenie tabeli
            String sql = "CREATE TABLE IF NOT EXISTS dane (\n"
                    + "	id integer PRIMARY KEY,\n"
                    + "	tekst text NOT NULL,\n"
                    + "	liczba real\n"
                    + ");";

            // uruchomienie zapytania
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            // dodanie rekordu
            try {
                sql = "INSERT INTO dane (id, tekst, liczba) VALUES (1, 'abc', 12.4)";
                stmt.execute(sql);
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }
            // dodanie rekoru - kolumna id ma autoincrement
            try {
                sql = "INSERT INTO dane (tekst, liczba) VALUES ('abc', 12.4)";
                stmt.execute(sql);
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }

            sql = "SELECT id, tekst, liczba FROM dane";

            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Kolumny zaczynają się od 1 (?!)
            for (int i = 1; i <= columnCount; i++ ) {
                if (i > 1) System.out.print(",");
                String name = rsmd.getColumnName(i);
                System.out.print(name);
            }
            System.out.println("");
            // wypisanie wszystkich rekordów
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++ ) {
                    if (i > 1) System.out.print(",");
                    System.out.print(rs.getString(i));
                }
                System.out.println("");
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        connect();
    }
}
