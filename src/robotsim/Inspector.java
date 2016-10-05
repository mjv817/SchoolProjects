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
 * Class for creating inspectors
 * @author Matt
 */
public class Inspector extends TourneyStaff{
    private InspectorRoles typeOfInpector;
    private int stationNumber = 0;
    private Scanner userInput = new Scanner(System.in);
    private String tournamentNameCheck;
    
    /**
     *
     * @param tournamentName
     */
    public Inspector(String tournamentName) {
        super(tournamentName);
        this.tournamentNameCheck = tournamentName;
        setTypeOfInpector();
        setStationNumber();
        
        
    }

    /**
     *
     * @return
     */
    public InspectorRoles getTypeOfInpector() {
        return typeOfInpector;
    }

    /**
     *
     */
    public void setTypeOfInpector() {
        int userChoice;
        System.out.println();
        System.out.println("Choose the type the type of Inspections you perform");
        System.out.println("Enter (1) , (2),  or (3) for the following selections (INTEGER VALUES ONLY)");
        System.out.println("(1) Hardware Inspector");
        System.out.println("(2) Software Inspector");
        System.out.println("(3) Field test Inspector");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.typeOfInpector = InspectorRoles.HARDWARE;
           System.out.println("You are now a hardware inspector for Tournament: " + tournamentNameCheck);
        }
        else if(userChoice == 2)
        {
            this.typeOfInpector = InspectorRoles.SOFTWARE;
            System.out.println("You are not a softare inspector for Tournament: " + tournamentNameCheck);
        }
        else if (userChoice == 3)
        {
            this.typeOfInpector = InspectorRoles.FIELD_TEST;
            System.out.println("You are now a field test inspector for Tournament: " + tournamentNameCheck);
        }
        else
            System.out.println("You did not enter a correct value. No changes were made");
    }

    /**
     *
     * @return
     */
    public int getStationNumber() {
        return stationNumber;
    }

    /**
     *
     */
    public void setStationNumber() {
        System.out.println();
        System.out.println("Please enter the station number (BETWEEN 1 and 3 ) that you will be working at");
        this.stationNumber = userInput.nextInt();
        
    }
    
    @Override
    public String toString()
    {
        return String.format(super.toString() + "\n" + "Inspector Type: " + typeOfInpector + "\n" + "Statoin Number: " + stationNumber);
    }
    
}
