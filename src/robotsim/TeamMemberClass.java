/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * TEAM MEMBER CLASS EXTENDS FROM TEAM PERSON CLASS
 * @author Matt
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * TEAM MEMBER CLASS EXTENDS FROM TEAM PERSON CLASS
 * @author Matt
 */
public class TeamMemberClass extends TeamPersonClass{
        private int age;
        private int currentGrade;
        private Scanner input = new Scanner(System.in);
        //private PDateClass newDate = new PDateClass();
        private int teamNumber;
        private File memberInfoFile;
        TeamExperience teamExperience;
        TeamRole teamRole;
        
    /**
     *
     * @param teamNumber
     */
    public TeamMemberClass(int teamNumber) {
        super();
        System.out.println("THE QUESTIONS BELOW ARE FORE AGE AND EXPEREINCE");
        System.out.println();
        setAge(age);  // Asks for User Age
        setCurrentGrade(currentGrade); // Asks for User Grade
        setTeamRole(teamRole);  // Asks for team Role
        setTeamExperience(teamExperience); // Asks for Team Expereince
        

        
    }

    /**
     *
     * @param teamNumber
     * @param teamMemberInfo
     * 
     */
    
        public TeamMemberClass(int teamNumber, String[] teamMemberInfo) {
        super(teamMemberInfo);
        //System.out.println("THE QUESTIONS BELOW ARE FORE AGE AND EXPEREINCE");
        System.out.println();
        
        this.age = Integer.parseInt(stringClean(teamMemberInfo[10]));
        this.currentGrade = Integer.parseInt(stringClean(teamMemberInfo[11]));
        setTeamRole(teamRole, Integer.parseInt(stringClean(teamMemberInfo[12])));
        setTeamExperience(teamExperience, Integer.parseInt(stringClean(teamMemberInfo[13])));
        
        

        
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        System.out.println();
        System.out.println("Please enter your current age: (Integer Value)");
        age = input.nextInt();
        this.age = age;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getCurrentGrade() {
        return currentGrade;
    }

    /**
     *
     * @param currentGrade
     */
    public void setCurrentGrade(int currentGrade) {
        System.out.println();
        System.out.println("Please Enter your current Grade between 7 THRU 12 (Integer Value)");
        currentGrade = input.nextInt();
        this.currentGrade = currentGrade;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public TeamExperience getTeamExperience() {
        return teamExperience;
    }

    /**
     *
     * @param teamExperience
     */
    public void setTeamExperience(TeamExperience teamExperience) {
        System.out.println();
        int userChoice;
        System.out.println("Please Enter a number 1 THRU 3 for the following for team Experience");
        System.out.println("Enter (1) for Novice");
        System.out.println("Enter (2) for Peer Mentor");
        System.out.println("Enter (3) for Experienced");
        userChoice = input.nextInt();
        input = new Scanner(System.in);
        if(userChoice == 1)
        {
            this.teamExperience = TeamExperience.NOVICE;
        }
        else if (userChoice == 2)
        {
            this.teamExperience = TeamExperience.PEER_MENTOR;
        }
        else if (userChoice == 3)
        {
            this.teamExperience = TeamExperience.EXPERIENCED;
        }
        else
        {
            System.out.println("Enter an incorrect value: Default will be novice");
            this.teamExperience = TeamExperience.NOVICE;
        }
        
        
    }

    /**
     *
     * @param teamExperience
     * @param userChoice2
     */
    public void setTeamExperience(TeamExperience teamExperience, int userChoice2) {
        System.out.println();
        int userChoice = userChoice2;

        if(userChoice == 1)
        {
            this.teamExperience = TeamExperience.NOVICE;
            
        }
        else if (userChoice == 2)
        {
            this.teamExperience = TeamExperience.PEER_MENTOR;
        }
        else if (userChoice == 3)
        {
            this.teamExperience = TeamExperience.EXPERIENCED;
        }
        else
        {
            System.out.println("Enter an incorrect value: Default will be novice");
            this.teamExperience = TeamExperience.NOVICE;
        }
        
        
    }

    /**
     *
     * @return
     */
    public TeamRole getTeamRole() {
        return teamRole;
    }

    /**
     *
     * @param teamRole
     */
    public void setTeamRole(TeamRole teamRole) {
        int userChoice;
        System.out.println();
        System.out.println("PICK YOUR TEAM ROLE!!!!");
        System.out.println("Please Enter a number 1 Thru 6 for the following choices");
        System.out.println("(1) for Coding");
        System.out.println("(2) for Design");
        System.out.println("(3) for Contstuction");
        System.out.println("(4) for Tester");
        System.out.println("(5) for Captain");
        System.out.println("(6) for Driver");
        userChoice = input.nextInt();
        input = new Scanner(System.in);
        
        if(userChoice == 1)
        {
            this.teamRole = TeamRole.CODING;
        }
        else if (userChoice == 2)
        {
            this.teamRole = TeamRole.DESIGN;
        }
        else if (userChoice == 3)
        {
            this.teamRole = TeamRole.CONSTRUCTION;
        }
        else if (userChoice == 4)
        {
            this.teamRole = TeamRole.TESTER;
        }
        else if (userChoice == 5)
        {
            this.teamRole = TeamRole.CAPTAIN;
        }
        else if (userChoice == 6)
        {
            this.teamRole = TeamRole.DRIVER;
        }
        else
        {
            System.out.println("Entered an incorrect value: Default will be tester");
            this.teamRole = TeamRole.TESTER;
        }
        
        
        
        
        
    }
    
    /**
     *
     * @param teamRole
     * @param userChoice2
     */
    public void setTeamRole(TeamRole teamRole, int userChoice2) {
        int userChoice = userChoice2;
        System.out.println();
        
        if(userChoice == 1)
        {
            this.teamRole = TeamRole.CODING;
            //System.out.println("(1) for Coding");
            
        }
        else if (userChoice == 2)
        {
            this.teamRole = TeamRole.DESIGN;
            //System.out.println("(2) for Design");
        }
        else if (userChoice == 3)
        {
            this.teamRole = TeamRole.CONSTRUCTION;
            //System.out.println("(3) for Contstuction");
        }
        else if (userChoice == 4)
        {
            this.teamRole = TeamRole.TESTER;
            //System.out.println("(4) for Tester");
        }
        else if (userChoice == 5)
        {
            this.teamRole = TeamRole.CAPTAIN;
            //System.out.println("(5) for Captain");
        }
        else if (userChoice == 6)
        {
            this.teamRole = TeamRole.DRIVER;
            //System.out.println("(6) for Driver");
        }
        else
        {
            //System.out.println("Entered an incorrect value: Default will be tester");
            this.teamRole = TeamRole.TESTER;
        }
        
        
        
        
        
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
    @Override
    public String toString()
    {
        return String.format(super.toString() + "Current Grade: " + currentGrade + "\n" + "Age: " + age+ "\n"+"Current Role: " +teamRole+"\n"+"Current Expereince: " +teamExperience+"\n");
    }
    
    
        
}
