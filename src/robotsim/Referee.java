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
 * Class that creates referees for the tournament
 * @author Matt
 */
public class Referee extends TourneyStaff {
    private boolean refereeTrainingOnline;
    private boolean inPersonTraning;
    private Scanner userInput = new Scanner(System.in);

    /**
     *
     * @param tournamentName
     */
    public Referee(String tournamentName) {
        super(tournamentName);
        setRefereeTrainingOnline();
        setInPersonTraning();
    }

    /**
     *
     * @return
     */
    public boolean isRefereeTrainingOnline() {
        return refereeTrainingOnline;
    }

    /**
     *
     */
    public void setRefereeTrainingOnline() {
        int userChoice;
        System.out.println();
        System.out.println("Have you completed the ONLINE referee training?");
        System.out.println("Enter (1) for Yes or (2) for No  (INTEGER VALUES ONLY)");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.refereeTrainingOnline = true;
           System.out.println("You have completed the Online Referee Training");
        }
        else if(userChoice == 2)
        {
            this.refereeTrainingOnline = false;
            System.out.println("You have not completed the online training to be a referee");
        }
        else
        {
            this.refereeTrainingOnline = false;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE false");
        }         
    }

    /**
     *
     * @return
     */
    public boolean isInPersonTraning() {
        return inPersonTraning;
    }

    /**
     *
     */
    public void setInPersonTraning() {
        int userChoice;
        System.out.println();
        System.out.println("Have you completed the in person training to be a referee?");
        System.out.println("Enter (1) for Yes or (2) for No  (INTEGER VALUES ONLY)");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.inPersonTraning = true;
           System.out.println("You have completed the in person training to be a referee");
        }
        else if(userChoice == 2)
        {
            this.inPersonTraning = false;
            System.out.println("You have not completed the in person training to be a referee");
        }
        else
        {
            this.inPersonTraning = false;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE false");
        }        
    }
    

    @Override
    public String toString()
    {
        return String.format(super.toString() + "\n" + "Completed Online Training: " + refereeTrainingOnline + " \n" + "Completed In Person Training: " + inPersonTraning);
    }
    
}
