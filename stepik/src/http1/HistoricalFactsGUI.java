package http1;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class HistoricalFactsGUI {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Этот день в истории");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        panel.add(new JLabel("Выберите дату:"));
        panel.add(datePicker);

        JButton fetchButton = new JButton("Получить факт");
        panel.add(fetchButton);

        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        panel.add(new JScrollPane(resultArea));

        frame.add(panel);
        frame.setVisible(true);

        fetchButton.addActionListener(e -> {
            Date selectedDate = (Date) datePicker.getModel().getValue();
            if (selectedDate != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
                String dateStr = sdf.format(selectedDate);
                try {
                    String fact = fetchFact(dateStr);
                    resultArea.setText(fact);
                } catch (Exception ex) {
                    resultArea.setText("Ошибка при извлечении данных.");
                }
            } else {
                resultArea.setText("Пожалуйста, выберите дату.");
            }
        });
    }

    public static String fetchFact(String dateStr) throws Exception {
        String urlString = "http://numbersapi.com/" + dateStr + "/date?json=true";

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
