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
public class TeamMemberClass extends TeamPersonClass{
        private int age;
        private int currentGrade;
        private Scanner input = new Scanner(System.in);
        private PDateClass newDate = new PDateClass();
        private int teamNumber;
        TeamExperience teamExperience;
        TeamRole teamRole;
        

    public TeamMemberClass(int teamNumber) {
        super();
        System.out.println("THE QUESTIONS BELOW ARE FORE AGE AND EXPEREINCE");
        System.out.println();
        setAge(age);  // Asks for User Age
        setCurrentGrade(currentGrade); // Asks for User Grade
        setTeamRole(teamRole);  // Asks for team Role
        setTeamExperience(teamExperience); // Asks for Team Expereince
        
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println();
        System.out.println("Please enter your current age: (Integer Value)");
        age = input.nextInt();
        this.age = age;
        input = new Scanner(System.in);
    }

    public int getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(int currentGrade) {
        System.out.println();
        System.out.println("Please Enter your current Grade between 7 THRU 12 (Integer Value)");
        currentGrade = input.nextInt();
        this.currentGrade = currentGrade;
        input = new Scanner(System.in);
    }

    public TeamExperience getTeamExperience() {
        return teamExperience;
    }

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

    public TeamRole getTeamRole() {
        return teamRole;
    }

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
    
    
    
    @Override
    public String toString()
    {
        return String.format(super.toString() + "Current Grade: " + currentGrade + "\n" + "Age: " + age+ "\n"+"Current Role: " +teamRole+"\n"+"Current Expereince: " +teamExperience+"\n");
    }
    
    
        
}
