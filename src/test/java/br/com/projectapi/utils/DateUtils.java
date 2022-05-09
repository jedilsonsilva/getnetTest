package br.com.projectapi.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateDifferenceDays(Integer qtdDias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, qtdDias);
        return getDateFormated(cal.getTime());
    }

    public static String getDateFormated(Date data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }


    public static String getDateFormatedUnavailability(Date data) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return format.format(data);
        //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")

    }

    public static String getDateUnavailability(Integer qtdDias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, qtdDias);
        return getDateFormatedUnavailability(cal.getTime());
    }

    public static Object getDataHoraAtual() {
        // data/hora atual
        LocalDateTime agora = LocalDateTime.now();


// formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        String dataFormatada = formatterData.format(agora);

/* formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(agora);*/
        return null;
    }

}
