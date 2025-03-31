package sql1;

import java.sql.*;

public class SimpleDatabase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:books.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();

                String createTableSQL = "CREATE TABLE IF NOT EXISTS books (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "title TEXT NOT NULL," +
                        "year INTEGER NOT NULL," +
                        "author TEXT NOT NULL" +
                        ");";

                stmt.execute(createTableSQL);

                String insertBookSQL = "INSERT INTO books (title, year, author) VALUES" +
                        "('1984', 1949, 'George Orwell')," +
                        "('To Kill a Mockingbird', 1960, 'Harper Lee')," +
                        "('Moby-Dick', 1851, 'Herman Melville');";

                stmt.executeUpdate(insertBookSQL);

                System.out.println("Таблица и данные успешно созданы.");

                String selectSQL = "SELECT * FROM books";
                ResultSet rs = stmt.executeQuery(selectSQL);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                    String author = rs.getString("author");
                    System.out.println(id + ": " + title + " (" + year + ") by " + author);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

