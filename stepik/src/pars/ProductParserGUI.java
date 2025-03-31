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
        JFrame frame = new JFrame("Парсер товаров с сайта Ozon");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField urlField = new JTextField();
        urlField.setText("https://www.ozon.ru/category/smartfony-15502/");
        frame.add(urlField, BorderLayout.NORTH);

        JButton fetchButton = new JButton("Извлечь данные");
        frame.add(fetchButton, BorderLayout.SOUTH);

        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Название", "Цена"}, 0);
        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

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

        frame.setVisible(true);
    }

    public static List<String[]> fetchProductData(String url) throws IOException {
        List<String[]> products = new ArrayList<>();

        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                .get();

        Elements productElements = doc.select("div[data-widget='product']");
        for (Element productElement : productElements) {
            String name = productElement.select("a[data-widget='product-title']").text();
            String price = productElement.select("span[data-widget='price']").text();
            products.add(new String[]{name, price});
        }
        return products;
    }
}
