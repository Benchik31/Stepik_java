package sql1;

import java.sql.*;

public class MultipleInsert {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:books.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();

                String insertBooksSQL = "INSERT INTO books (title, year, author, genre_id) VALUES " +
                        "('The Fellowship of the Ring', 1954, 'J.R.R. Tolkien', 1), " +
                        "('Dune', 1965, 'Frank Herbert', 2), " +
                        "('The Da Vinci Code', 2003, 'Dan Brown', 3), " +
                        "('Pride and Prejudice', 1813, 'Jane Austen', 4);";

                stmt.executeUpdate(insertBooksSQL);

                System.out.println("Множественные записи успешно добавлены.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

