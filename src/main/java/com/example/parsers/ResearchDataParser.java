package com.example.parsers;

/*import com.example.entities.DiscoveryItem;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;*/

public class ResearchDataParser {
    /*private static final String AERONET_DATE_FORMAT_PETTERN = "MM:dd:yyyy";
    private static final String AERONET_TIME_FORMAT_PETTERN = "hh:mm:ss";

    public ArrayList<DiscoveryItem> parseXmlDataFile(FileInputStream xmlData) {
        HSSFWorkbook dataWorkBook = null;
        
        try {
            dataWorkBook = new HSSFWorkbook(xmlData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HSSFSheet firstSheet = dataWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();

        ArrayList<DiscoveryItem> discoveryItems = new ArrayList<DiscoveryItem>();

        while (rowIterator.hasNext()) {
            Cell currentCell = rowIterator.next().cellIterator().next();
            DiscoveryItem newItem = new DiscoveryItem();
            String[] currentData = currentCell.getStringCellValue().split(",");

            newItem.setDate(parseAeronetDate(currentData[0]));
            newItem.setTime(parseAeronetTime(currentData[1]));
            newItem.setDayOfYear(Integer.valueOf(currentData[2]));
            newItem.setDayOfYearFraction(Double.valueOf(currentData[3]));

            discoveryItems.add(newItem);
        }

        System.out.println("here - ");



        return discoveryItems;
    }

    private Date parseAeronetDate(String date) {
        DateFormat df = new SimpleDateFormat(AERONET_DATE_FORMAT_PETTERN, Locale.ENGLISH);
        Date result = null;

        try {
            result = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    private LocalTime parseAeronetTime(String time) {
        LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern(AERONET_TIME_FORMAT_PETTERN));

        return localTime;
    }

    public static void main(String[] args) {
        *//*String myDateString = "13:24:40";
        LocalTime localTime = LocalTime.parse(myDateString, DateTimeFormatter.ofPattern("HH:mm:ss"));
        int hour = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);
        int minute = localTime.get(ChronoField.MINUTE_OF_HOUR);
        int second = localTime.get(ChronoField.SECOND_OF_MINUTE);

        //prints "hour: 13, minute: 24, second: 40":
        Sytem.out.println(String.format("hour: %d, minute: %d, second: %d", hour, minute, second));*//*

    }*/
}
