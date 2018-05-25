package com.clickray.browserspot.statisticsystem.controller.service;

import com.clickray.browserspot.statisticsystem.model.UserStatistic;
import com.clickray.browserspot.statisticsystem.sqlite.UserStatisticRepository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateOperations {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String START_HOUR = "00:00:00";
    private static final String END_HOUR = "23:59:59";

    private static String getDayBefore(){
        DateTime dateTime = new DateTime();
        DateTime beforeDay = dateTime.minusDays(0);
        DateTimeFormatter fmt = DateTimeFormat.forPattern(DATE_FORMAT);
        String str = fmt.print(beforeDay);
        return str;
    }

    public static String getStartDayDate(){
        String dayBefore = getDayBefore();
        StringBuilder startTime =  new StringBuilder();
        startTime.append(dayBefore).append(" " + START_HOUR);
        return startTime.toString();
    }

    public static  String getEndDayDate(){
        String dayBefore = getDayBefore();
        StringBuilder endTime =  new StringBuilder();
        endTime.append(dayBefore).append(" " + END_HOUR);
        return endTime.toString();
    }

    public static Timestamp convertDate(String time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:s");
        try {
            Date parsedTime = dateFormat.parse(time);
            Timestamp timeStampTime = new Timestamp(parsedTime.getTime());
            return timeStampTime;
        } catch (ParseException ex) {
            Logger.getLogger(DataProxyOperationStatisticController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Timestamp(0);
    }
}
