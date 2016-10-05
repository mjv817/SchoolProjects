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
 * This class created objects for visitors
 * @author Matt
 */
public class Visitor extends PersonClass {
    private boolean relatedMember;
    private boolean firstVisit;
    private boolean pDoner;
    private boolean pVol;
    private Scanner userInput = new Scanner(System.in);

    /**
     *
     */
    public Visitor() {
        super();
        setRealatedMember();
        setFirstVisit();
        setpDoner();
        setpVol();
    }

    /**
     *
     * @return
     */
    public boolean isRelatedMember() {
        return relatedMember;
    }

    /**
     *
     */
    public void setRealatedMember() {
        int userChoice;
        System.out.println();
        System.out.println("Are you related to a team member?");
        System.out.println("Enter (1) for Yes or (2) for No  (INTEGER VALUES ONLY)");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.relatedMember = true;
           System.out.println("You are a family member");
        }
        else if(userChoice == 2)
        {
            this.relatedMember = false;
            System.out.println("You are NOT a family member");
        }
        else
        {
            this.relatedMember = false;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE false");
        }
    }

    /**
     *
     * @return
     */
    public boolean isFirstVisit() {
        return firstVisit;
    }

    /**
     *
     */
    public void setFirstVisit() {
        int userChoice;
        System.out.println();
        System.out.println("Is this your first time visiting a tournament?");
        System.out.println("Enter (1) for Yes or (2) for No  (INTEGER VALUES ONLY)");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.firstVisit = true;
           System.out.println("You have completed the in person training to be a referee");
        }
        else if(userChoice == 2)
        {
            this.firstVisit = false;
            System.out.println("You have not completed the in person training to be a referee");
        }
        else
        {
            this.firstVisit = false;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE false");
        }
    }

    /**
     *
     * @return
     */
    public boolean ispDoner() {
        return pDoner;
    }

    /**
     *
     */
    public void setpDoner() {
        int userChoice;
        System.out.println();
        System.out.println("Would you  be a potential donor?");
        System.out.println("Enter (1) for Yes or (2) for No  (INTEGER VALUES ONLY)");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.pDoner = true;
           System.out.println("Thanks for considering donating to the tournament");
        }
        else if(userChoice == 2)
        {
            this.pDoner = false;
            System.out.println("Way to be a cheap!");
        }
        else
        {
            this.pDoner = false;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE false");
        }
    }

    /**
     *
     * @return
     */
    public boolean ispVol() {
        return pVol;
    }

    /**
     *
     */
    public void setpVol() {
        int userChoice;
        System.out.println();
        System.out.println("would you like to volunter to work here?");
        System.out.println("Enter (1) for Yes or (2) for No  (INTEGER VALUES ONLY)");
        userChoice = userInput.nextInt();
        
        if(userChoice == 1)
        {
           this.pVol = true;
           System.out.println("Thanks please fill out an application for next year");
        }
        else if(userChoice == 2)
        {
            this.pVol = false;
            System.out.println("Hopefully you reconsider ");
        }
        else
        {
            this.pVol = false;
            System.out.println("You did not enter a correct value. DEFAULT WILL BE false");
        }
    }
    
    @Override
    public String toString()
    {
        return String.format(super.toString() + "\n" + "Family Member: " + relatedMember + "\n" + "First Time Visiting: " + firstVisit + "\n"+ "Possible Donor: " + pDoner + "\n" + "Possible Volunteer: " + pVol );
    }
    
    
}
