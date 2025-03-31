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
            String url = "https://www.krylatskoye.ru/content/ratings/2021/09/0928.html";
            Document doc = Jsoup.connect(url).get();

            List<String> cities = new ArrayList<>();

            Elements rows = doc.select("table.table_free tr");

            for (Element row : rows) {
                Elements cols = row.select("td");
                if (cols.size() > 1) {
                    String city = cols.get(1).text().trim();
                    cities.add(city);
                }
            }

            cities.sort(String::compareToIgnoreCase);

            cities.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
