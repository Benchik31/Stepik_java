package http1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HistoricalFacts {

    public static void main(String[] args) {
        System.out.println("Enter the day (1-31): ");
        int day = Integer.parseInt(System.console().readLine());

        System.out.println("Enter the month (1-12): ");
        int month = Integer.parseInt(System.console().readLine());

        if (day < 1 || day > 31 || month < 1 || month > 12) {
            System.out.println("Error: Invalid date.");
            return;
        }

        String urlString = "http://numbersapi.com/" + month + "/" + day + "/date?json=true";

        try {
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

            String fact = response.toString();
            System.out.println("Interesting fact: " + fact);

        } catch (Exception e) {
            System.out.println("Error: Could not fetch the fact. Please try again.");
            e.printStackTrace();
        }
    }
}

