package pars;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductParserGUI {
    public static void main(String[] args) {
        // Создаем окно
        JFrame frame = new JFrame("Парсер товаров с сайта Ozon");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Поле ввода URL
        JTextField urlField = new JTextField();
        urlField.setText("https://www.ozon.ru/category/smartfony-15502/");
        frame.add(urlField, BorderLayout.NORTH);

        // Кнопка для извлечения данных
        JButton fetchButton = new JButton("Извлечь данные");
        frame.add(fetchButton, BorderLayout.SOUTH);

        // Таблица для отображения товаров
        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Название", "Цена"}, 0);
        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Действие по нажатию на кнопку
        fetchButton.addActionListener(e -> {
            String url = urlField.getText();
            try {
                List<String[]> products = fetchProductData(url);
                for (String[] product : products) {
                    tableModel.addRow(product);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Ошибка при извлечении данных: " + ex.getMessage());
            }
        });

        // Отображаем окно
        frame.setVisible(true);
    }

    // Метод для извлечения данных о товарах
    public static List<String[]> fetchProductData(String url) throws IOException {
        List<String[]> products = new ArrayList<>();

        // Добавляем заголовок User-Agent, чтобы запрос выглядел как запрос от обычного браузера
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                .get();

        // Извлекаем название и цену товаров
        Elements productElements = doc.select("div[data-widget='product']");  // Используем правильный селектор для товаров
        for (Element productElement : productElements) {
            String name = productElement.select("a[data-widget='product-title']").text(); // Извлекаем название
            String price = productElement.select("span[data-widget='price']").text();   // Извлекаем цену
            products.add(new String[]{name, price});
        }
        return products;
    }
}
