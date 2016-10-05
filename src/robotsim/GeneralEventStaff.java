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

/**
 * Class for general event staffers
 * @author Matt
 */
public class GeneralEventStaff extends TourneyStaff{
    private String currentRole;
    private Scanner userInput = new Scanner(System.in);

    /**
     *
     * @param tournamentName
     */
    public GeneralEventStaff(String tournamentName) {
        super(tournamentName);
        setCurrentRole();
    }

    /**
     *
     * @return
     */
    public String getCurrentRole() {
        return currentRole;
    }

    /**
     *
     */
    public void setCurrentRole() {
        System.out.println();
        System.out.println("Type in your current role for the tournament");
        this.currentRole = userInput.nextLine();
    }
    
    @Override
    public String toString()
    {
        return String.format(super.toString() + "\n" + "Current Role: " + currentRole);
    }
}
