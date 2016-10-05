/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * TEAM PERSON CLASS EXTENDS FROM PERSON CLASS AND HAS ADDITIONAL DATA FOR EACH INDIVIDUAL MEMBER
 * @author Matt
 */
import java.util.Scanner;

/**
 * TEAM PERSON CLASS EXTENDS FROM PERSON CLASS AND HAS ADDITIONAL DATA FOR EACH INDIVIDUAL MEMBER
 * @author Matt
 */
public class TeamPersonClass extends PersonClass {
    private int teamNumber;
    private String physicalAddress;
    private int hoursWorked;
    private int hoursWorkedSeason;
    private Scanner input = new Scanner(System.in);
    private AddressClass addressInfo;

    /**
     *
     */
    public TeamPersonClass() {
        super();
        addressInfo = new AddressClass();
        setTeamNumber(teamNumber); // Asks for Team Number
        setHoursWorked(hoursWorked); // Asks for Hours worked
        setHoursSeason(hoursWorked); // Asks for Total Hours Worked
        
    }

    /**
     *
     * @param memberInformation
     */
    
    public TeamPersonClass(String[] memberInformation) {
        super(memberInformation);
        addressInfo = new AddressClass(memberInformation);
        this.teamNumber = Integer.parseInt(stringClean(memberInformation[7]));
        this.hoursWorked = Integer.parseInt(stringClean(memberInformation[8]));
        this.hoursWorkedSeason = Integer.parseInt(stringClean(memberInformation[9]));
        
    }

    /**
     *
     * @return
     */
    public int getTeamNumber() {
        return teamNumber;
    }

    /**
     *
     * @param teamNumber
     */
    public void setTeamNumber(int teamNumber) {
        System.out.println();
        System.out.println("Please enter your Team Number: (Integer Value)");
        teamNumber = input.nextInt();
        this.teamNumber = teamNumber;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    /**
     *
     * @param physicalAddress
     */
    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    /**
     *
     * @return
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     *
     * @param hoursWorked
     */
    public void setHoursWorked(int hoursWorked) {
        System.out.println();
        System.out.println("Enter the hours you worked this week: (Integer Value)");
        hoursWorked = input.nextInt();
        this.hoursWorked = hoursWorked;
        input = new Scanner(System.in);
    }
    
    /**
     *
     * @param hoursWorked
     */
    public void setHoursSeason(int hoursWorked)
    {
        System.out.println();
        System.out.println("Enter the total hours you have worked so far this season: (Integer Value)");
        hoursWorkedSeason = input.nextInt();
        this.hoursWorkedSeason = hoursWorkedSeason;
        input = new Scanner(System.in);
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static String stringClean(String s)
    {
        String blank = new String(" ");

        while (s.startsWith(blank))
        {
            s = s.substring(1);
        }
        return s;
    }
    
    
    
    public String toString()
    {
        return String.format(super.toString() + "\n" +"Hours Worked this Season: " + hoursWorkedSeason +"\n");
    }
    
}
