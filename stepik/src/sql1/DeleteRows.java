package sql1;

import java.sql.*;

public class DeleteRows {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:books.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();

                String insertGenreSQL = "INSERT INTO genres (genre) VALUES ('Horror');";
                stmt.executeUpdate(insertGenreSQL);

                String deleteGenreSQL = "DELETE FROM genres WHERE genre = 'Horror';";
                stmt.executeUpdate(deleteGenreSQL);

                String insertBookSQL = "INSERT INTO books (title, year, author, genre_id) VALUES ('The Shining', 1977, 'Stephen King', (SELECT id FROM genres WHERE genre = 'Horror'));";
                stmt.executeUpdate(insertBookSQL);

                String deleteGenreWithBookSQL = "DELETE FROM genres WHERE genre = 'Horror';";
                try {
                    stmt.executeUpdate(deleteGenreWithBookSQL);
                } catch (SQLException e) {
                    System.out.println("Ошибка при удалении жанра: " + e.getMessage());
                }

                System.out.println("Записи были добавлены и удалены.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

