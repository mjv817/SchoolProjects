/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * COACH CLASS HOLDS SPECIFIC DATA FOR COACHES ONLY
 * @author Matt
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * COACH CLASS HOLDS SPECIFIC DATA FOR COACHES ONLY
 * @author Matt
 */
public class CoachClass extends TeamPersonClass{
    private int firstYearCoached;
    private String coachEmployer;
    private Boolean teachingStatus;
    private Scanner input = new Scanner(System.in);
    private int coachValue;

    /**
     *
     */
    public CoachClass() {
        super();
        System.out.println("Are you a coach ? (1) for Yes (2) for No");
        coachValue = input.nextInt();
        if(coachValue == 1)
        {
            setFirstYearCoached(firstYearCoached);
            setCoachEmployer(coachEmployer);
            setTeachingStatus(teachingStatus);
        }
        else
            System.out.println("Coach Values left null");
        
        input = new Scanner(System.in);
        
    }
    
    /**
     *
     * @param coachInfo
     */
    public CoachClass(String[] coachInfo)
    {
        super(coachInfo);
        this.firstYearCoached = Integer.parseInt(coachInfo[14]);
        this.coachEmployer = coachInfo[15];
        if(Integer.parseInt(coachInfo[16]) == 1)
        {
            this.teachingStatus = true;
        }
        else
            this.teachingStatus = false;
        
    }

    /**
     *
     * @return
     */
    public int getFirstYearCoached() {
        return firstYearCoached;
    }

    /**
     *
     * @param firstYearCoached
     */
    public void setFirstYearCoached(int firstYearCoached) {
        System.out.println();
        System.out.println("Please enter the first year you starting coaching(EX: 2005) ");
        firstYearCoached = input.nextInt();
        this.firstYearCoached = firstYearCoached;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public String getCoachEmployer() {
        return coachEmployer;
    }

    /**
     *
     * @param coachEmployer
     */
    public void setCoachEmployer(String coachEmployer) {
        System.out.println();
        System.out.println("Please enter your employer name");
        coachEmployer = input.nextLine();
        this.coachEmployer = coachEmployer;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public Boolean getTeachingStatus() {
        return teachingStatus;
    }

    /**
     *
     * @param teachingStatus
     */
    public void setTeachingStatus(Boolean teachingStatus) {
        int userInput;
        System.out.println();
        System.out.println("Are you currently a teacher? ");
        System.out.println("(1) for True and (0) for false ");
        userInput = input.nextInt();
        
        if(userInput == 1)
        {
            this.teachingStatus = true;
        }
        else
            this.teachingStatus = false; 
        System.out.println();
        
    }
    
    
    @Override
    
    public String toString()
    {
        return String.format(super.toString() + "Year Started: " + firstYearCoached + "\n" +"Teacher: " + teachingStatus +"\n" + "Employer: " + coachEmployer);
    }
    
    
    
    
    
}
