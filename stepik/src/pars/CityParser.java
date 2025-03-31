package pars;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityParser {
    public static void main(String[] args) {
        try {
            // Загружаем HTML-страницу с сайта
            String url = "https://www.krylatskoye.ru/content/ratings/2021/09/0928.html";
            Document doc = Jsoup.connect(url).get();

            // Список для хранения городов
            List<String> cities = new ArrayList<>();

            // Извлекаем все строки таблицы, содержащие города
            Elements rows = doc.select("table.table_free tr");

            // Пропускаем первую строку с заголовками и извлекаем города
            for (Element row : rows) {
                Elements cols = row.select("td");
                if (cols.size() > 1) { // Проверяем, что это строка с городом
                    String city = cols.get(1).text().trim(); // Второй столбец содержит город
                    cities.add(city);
                }
            }

            // Сортируем города по алфавиту
            cities.sort(String::compareToIgnoreCase);

            // Выводим города в консоль
            cities.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
