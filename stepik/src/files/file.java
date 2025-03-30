package files;

import java.io.*;
import java.util.*;

public class file {
    public static void main(String[] args) {
        List<String> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String result = evaluateExpression(line);
                results.add(line + " = " + result);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка при чтении: " + ex.getMessage());
        }

        // Запись в output.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String res : results) {
                writer.write(res);
                writer.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка при записи: " + ex.getMessage());
        }
    }

    // Метод, который пытается вычислить выражение
    private static String evaluateExpression(String line) {
        try {
            String[] parts = line.trim().split(" ");
            if (parts.length != 3) return "ERROR";

            int a = Integer.parseInt(parts[0]);
            String op = parts[1];
            int b = Integer.parseInt(parts[2]);

            return switch (op) {
                case "+" -> String.valueOf(a + b);
                case "-" -> String.valueOf(a - b);
                case "*" -> String.valueOf(a * b);
                case "/" -> (b == 0) ? "ERROR" : String.valueOf(a / b);
                default -> "ERROR";
            };
        } catch (Exception e) {
            return "ERROR";
        }
    }
}
