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
 * class for creating inspectors
 * @author Matt
 */
public class Judge extends TourneyStaff{
    private boolean judgeTraining;
    private int yearsJudge;
    private Scanner userInput = new Scanner(System.in);

    /**
     *
     * @param tournamentName
     */
    public Judge(String tournamentName) {
        super(tournamentName);
        setYearsJudge();
        setJudgeTraining();
    }

    /**
     *
     * @return
     */
    public boolean isJudgeTraining() {
        return judgeTraining;
    }

    /**
     *
     */
    public void setJudgeTraining() {
        int userChoice;
        System.out.println();
        System.out.println("Have you completed the required training to be a judge?");
        System.out.println("Enter (1) for Yes or (2) for No  (INTEGER VALUES ONLY)");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.judgeTraining = true;
           System.out.println("You have completed the Training");
        }
        else if(userChoice == 2)
        {
            this.judgeTraining = false;
            System.out.println("You have not completed the required training to be a judge");
        }
        else
        {
            this.judgeTraining = false;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE false");
        }        
        
    }

    /**
     *
     * @return
     */
    public int getYearsJudge() {
        return yearsJudge;
    }

    /**
     *
     */
    public void setYearsJudge() {
        System.out.println();
        System.out.println("Enter the number of years you have been a judge");
        this.yearsJudge = userInput.nextInt();
        
    }
    
    @Override
    public String toString()
    {
        return String.format(super.toString() + "\n" + "Years Judging: " + yearsJudge + "\n" + "Comleted Training: " + judgeTraining);
    }
    
}
