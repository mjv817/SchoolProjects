/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 *
 * @author Matt
 */
import java.util.Scanner;
public class TeamPersonClass extends PersonClass {
    private int teamNumber;
    private String physicalAddress;
    private int hoursWorked;
    private int hoursWorkedSeason;
    private Scanner input = new Scanner(System.in);
    private AddressClass addressInfo = new AddressClass();

    public TeamPersonClass() {
        super();
        setTeamNumber(teamNumber); // Asks for Team Number
        setHoursWorked(hoursWorked); // Asks for Hours worked
        setHoursSeason(hoursWorked); // Asks for Total Hours Worked
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        System.out.println();
        System.out.println("Please enter your Team Number: (Integer Value)");
        teamNumber = input.nextInt();
        this.teamNumber = teamNumber;
        input = new Scanner(System.in);
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        System.out.println();
        System.out.println("Enter the hours you worked this week: (Integer Value)");
        hoursWorked = input.nextInt();
        this.hoursWorked = hoursWorked;
        input = new Scanner(System.in);
    }
    
    public void setHoursSeason(int hoursWorked)
    {
        System.out.println();
        System.out.println("Enter the total hours you have worked so far this season: (Integer Value)");
        hoursWorkedSeason = input.nextInt();
        this.hoursWorkedSeason = hoursWorkedSeason;
        input = new Scanner(System.in);
    }
    
    public String toString()
    {
        return String.format(super.toString() + "\n" +"Hours Worked this Season: " + hoursWorkedSeason +"\n");
    }
    
}
