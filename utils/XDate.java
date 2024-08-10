/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndhlt
 */
public class XDate {

    private static Thread clock;
    public static Date currTime;
    static{
        clock = new Thread() {
            @Override
            public void run() {
                while (true) {
                    currTime = new Date();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(XDate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.setDaemon(true);
        clock.start();
    }

    static SimpleDateFormat formater = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static boolean validate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            formater.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

}
