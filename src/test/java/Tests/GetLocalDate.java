package Tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class GetLocalDate {

    String getDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        String dateNow = localDate.format(dateTimeFormatter);
        //System.out.println(dateNow);
        return dateNow;
    }

     String getDateForInput() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        String dateNow = localDate.format(dateTimeFormatter);
        //System.out.println(dateNow);

         return dateNow;
     }
}
