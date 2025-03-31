package http1;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    @Override
    public Object stringToValue(String text) throws java.text.ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd");
        return format.parse(text);
    }

    @Override
    public String valueToString(Object value) {
        if (value != null) {
            Calendar calendar = (Calendar) value;  // Преобразуем в Calendar
            SimpleDateFormat format = new SimpleDateFormat("MM/dd");
            return format.format(calendar.getTime()); // Преобразуем в Date и форматируем
        }
        return "";
    }
}
