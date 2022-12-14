package adminUI;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataLabelFormatter extends JFormattedTextField.AbstractFormatter {
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) dateFormatter.parseObject(text));
        return cal;
    }

//    public static void main(String[] args) {
//        DataLabelFormatter dl=new DataLabelFormatter();
//        dl.stringToValue();
//    }



    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }

}
