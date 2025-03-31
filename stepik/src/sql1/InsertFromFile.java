package sql1;

import java.sql.*;

import java.io.*;

public class InsertFromFile {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:books.db";
        String filePath = "queries.sql";  // Путь к вашему файлу с запросами

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;

                while ((line = reader.readLine()) != null) {
                    stmt.executeUpdate(line);
                }
                reader.close();
                System.out.println("Записи успешно добавлены из файла.");
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


