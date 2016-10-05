/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * PDATE CLASS HOLDS INFORMATION FOR STORING THE DATE AND TIME
 * @author Matt
 */
import java.util.Scanner;

/**
 * PDATE CLASS HOLDS INFORMATION FOR STORING THE DATE AND TIME
 * @author Matt
 */
public class PDateClass {
    private String monthName = "January";
    private int monthNumber = 1;
    private int dayNumber = 1;
    private int year = 2015;
    private String dayString = "Sunday";
    
    private int timeByHour = 00;
    private int timeByMinute = 00;
    private String morning = "AM";
    private String evening = "PM";
    private Scanner input = new Scanner(System.in);

    /**
     *
     */
    public PDateClass() {
        System.out.println();
        System.out.println("PLEAE ENTER THE DATE AND HOURS WORKED");
        setMonthName(monthName);  // Asks for Month Name from User
        setMonthNumber(monthNumber);  // Aks for Month Number from user
        setDayString(dayString);  // Asks for Day of week w/ String
        setYear(year);  // Asks user for year
        
        setTimeByHour(timeByHour);  // Asks user for time by hour
        setTimeByMinute(timeByMinute); // Asks user for time by minute
        setMorning(morning,evening); // Asks user if it is AM OR PM
        
        //printMonthString(monthName, dayNumber, year);    // Prints Date by String
        //printMonthNumber(monthNumber,dayNumber,year);    // Prints Date by Number
        //printTime(timeByHour,timeByMinute);              // Prints Time
    }

    /**
     *
     * @return
     */
    public String getMonthName() {
        return monthName;
    }

    /**
     *
     * @param monthName
     */
    public void setMonthName(String monthName) {
        System.out.println();
        System.out.println();
        System.out.println("The following questions wil be fore entering the date");
        System.out.println("Please enter the name of the Month:(EX: March)");
        monthName = input.nextLine();
        this.monthName = monthName;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getMonthNumber() {
        return monthNumber;
    }

    /**
     *
     * @param monthNumber
     */
    public void setMonthNumber(int monthNumber) {
        System.out.println();
        System.out.println("Please enter the Month by number (EX: 09 or 12) ");
        monthNumber = input.nextInt();
        this.monthNumber = monthNumber;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getDayNumber() {
        return dayNumber;
    }

    /**
     *
     * @param dayNumber
     */
    public void setDayNumber(int dayNumber) {
        System.out.println();
        System.out.println("Please enter the day by number(EX: 01 or 31)");
        dayNumber = input.nextInt();
        this.dayNumber = dayNumber;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(int year) {
        System.out.println();
        System.out.println("Please enter the full  year(EX: 2015)");
        year = input.nextInt();
        this.year = year;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public String getDayString() {
        return dayString;
    }

    /**
     *
     * @param dayString
     */
    public void setDayString(String dayString) {
        System.out.println();
        System.out.println("Please enter the day by name(EX: Tuesday)");
        dayString = input.nextLine();
        this.dayString = dayString;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getTimeByHour() {
        return timeByHour;
    }

    /**
     *
     * @param timeByHour
     */
    public void setTimeByHour(int timeByHour) {
        System.out.println();
        System.out.println("Please enter the time of Hour: (Integer Value)");
        timeByHour = input.nextInt();
        this.timeByHour = timeByHour;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getTimeByMinute() {
        return timeByMinute;
    }

    /**
     *
     * @param timeByMinute
     */
    public void setTimeByMinute(int timeByMinute) {
        System.out.println();
        System.out.println("Please enter the time of minute: (Integer Value)");
        timeByMinute = input.nextInt();
        this.timeByMinute = timeByMinute;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public String getMorning() {
        return morning;
    }

    /**
     *
     * @param morning
     * @param evening
     */
    public void setMorning(String morning, String evening) {
        System.out.println();
        int userInput;
        System.out.println("What time of day is it (1) for Morning or (2) for Evening?");
        userInput = input.nextInt();
        if(userInput == 1)
        {
            this.morning = morning;
        }
        else if (userInput == 2)
        {
            this.evening = evening;
        }
        
    }

    /**
     *
     * @return
     */
    public String getEvening() {
        return evening;
    }

    /**
     *
     * @param evening
     */
    public void setEvening(String evening) {
        this.evening = evening;
    }
    
    /**
     *
     * @param monthName
     * @param dayNumber
     * @param year
     */
    public void printMonthString(String monthName, int dayNumber, int year)
    {
        System.out.println();
        System.out.println(monthName + " " + dayNumber + ", " + year);
    }
    
    /**
     *
     * @param monthNumber
     * @param dayNumber
     * @param year
     */
    public void printMonthNumber(int monthNumber, int dayNumber, int year)
    {
        System.out.println();
        System.out.println("DATE: "+monthNumber+"-"+dayNumber+"-"+year);
    }
    
    /**
     *
     * @param timeByHour
     * @param timeByMinute
     */
    public void printTime(int timeByHour, int timeByMinute)
    {
        System.out.println();
        System.out.println("TIME: "+timeByHour+":"+timeByMinute);
    }
    
    
    @Override
    public String toString()
    {
        return String.format(monthName + " " + dayNumber + ", " + year);
    }
}
