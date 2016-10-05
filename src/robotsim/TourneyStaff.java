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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class TourneyStaff extends PersonClass {
    private String tournamentName;
    private int yearsOfExperience;
    private ArrayList<String> tournamentRoles;
    private boolean training;
    Compensation typeOfComp;
    private Scanner userInput = new Scanner(System.in);
    
    /**
     *
     * @param tournamentName
     */
    public TourneyStaff(String tournamentName) {
        super();
        setTournamentName(tournamentName);
        setTypeOfComp();
        setYearsOfExperience();
        setTraining();
    }

    /**
     *
     * @return
     */
    public String getTournamentName() {
        return tournamentName;
    }

    /**
     *
     * @param tournamentName
     */
    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    /**
     *
     * @return
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     *
     */
    public void setYearsOfExperience() {
        int userChoice;
        System.out.println();
        System.out.println("Please enter the number of years you have been staffing tournaments");
        userChoice = userInput.nextInt();
        this.yearsOfExperience = userChoice;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getTournamentRoles() {
        return tournamentRoles;
    }

    /**
     *
     * @param tournamentRoles
     */
    public void setTournamentRoles(ArrayList<String> tournamentRoles) {
        this.tournamentRoles = tournamentRoles;
    }

    /**
     *
     * @return
     */
    public boolean isTraining() {
        return training;
    }

    /**
     *
     */
    public void setTraining() {
        int userChoice;
        System.out.println();
        System.out.println("Enter either 1 or 2 for the following Question");
        System.out.println("Have you completed the required training to be on STAFF? (1) for Yes or (2) for No");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
            this.training = true;
            System.out.println("Congrats you have completed the training");
        }
        else if (userChoice == 2)
        {
            this.training = false;
            System.out.println("Sorry you have not completed the required training");
        }
        else
        {
            System.out.println("You have entered an invalid INTEGER VALUE. Defualt will be selection 2");
            this.training = false;
        }
        
    }

    /**
     *
     * @return
     */
    public Compensation getTypeOfComp() {
        return typeOfComp;
    }

    /**
     *
     */
    public void setTypeOfComp() {
        int userChoice;
        System.out.println();
        System.out.println("Enter either 1 or 2 for the available selections(Integer value)");
        System.out.println("(1) for Paid or (2) for Volunteer");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.typeOfComp = Compensation.PAID;
           System.out.println("Your comensation has been set to PAID");
        }
        else if(userChoice == 2)
        {
            this.typeOfComp = Compensation.VOLUNTEER;
            System.out.println("Your Compensation has been set to volunteer");
        }
        else
        {
            this.typeOfComp = Compensation.VOLUNTEER;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE VOLUNTEER");
        }
        
        
        
    }
    
    @Override 
    
    public String toString()
    {
        return String.format(super.toString() + "\n" + "Tournament Name: " + tournamentName + "\n" + "Experience: " +  yearsOfExperience + "\n" + "Compensation: " +  typeOfComp + "\n" + "Completed Training: " +  training );
    }
    
    
    
}
