package sql1;

import java.sql.*;

public class SecondTable {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:books.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();

                String createGenresTableSQL = "CREATE TABLE IF NOT EXISTS genres (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "genre TEXT NOT NULL" +
                        ");";
                stmt.execute(createGenresTableSQL);

                String insertGenresSQL = "INSERT INTO genres (genre) VALUES" +
                        "('Fantasy')," +
                        "('Science Fiction')," +
                        "('Mystery')," +
                        "('Romance');";
                stmt.executeUpdate(insertGenresSQL);

                String alterBooksTableSQL = "ALTER TABLE books ADD COLUMN genre_id INTEGER;";
                stmt.executeUpdate(alterBooksTableSQL);

                String foreignKeySQL = "PRAGMA foreign_keys = ON;";
                stmt.executeUpdate(foreignKeySQL);

                String addForeignKeySQL = "PRAGMA foreign_keys = ON;";
                stmt.executeUpdate(addForeignKeySQL);

                String selectGenresSQL = "SELECT * FROM genres";
                ResultSet rs = stmt.executeQuery(selectGenresSQL);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String genre = rs.getString("genre");
                    System.out.println(id + ": " + genre);
                }

                String selectBooksSQL = "SELECT * FROM books";
                rs = stmt.executeQuery(selectBooksSQL);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                    String author = rs.getString("author");
                    int genreId = rs.getInt("genre_id");
                    System.out.println(id + ": " + title + " (" + year + ") by " + author + ", Genre ID: " + genreId);
                }

                System.out.println("Таблицы и данные успешно обновлены.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

