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
import java.util.Random;


public class Team  {
    private int teamNumber;
    private String teamName;
    private int numberOfTeamMembers;
    private String schoolSponsor;
    private String financialSponsor;
    private int judgingTime;
    private String judgingLocation;
    private int maxNumberofTeams;
    TeamGameStatus gameStatus;  // ENUM Type
    TeamJudgingStatus judgeStatus; // ENUM Type
    private Scanner input = new Scanner(System.in);
    private ArrayList<String> newTeamsList = new ArrayList();
    private  Random rndm = new Random(1);
    private int rankingPoints;
    private int judgingPoints;
    private int qualifyingPoints;
    private int maxTeamSize = 10;
    private int randomNumber = 1;
    RobotStatus  currentRobotStatus;
    
    
    private Robot  teamRobot;
    private TeamMemberClass[] teamMembers = new TeamMemberClass [maxTeamSize];
    
    public Team(TeamGameStatus gameStatus, TeamJudgingStatus judgeStatus, int numberOfTeams, int randomNumber) {
        setTeamName(); // Ask for user for Team name
        setFinancialSponsor(); // Ask for nameof financial sponsor
        setNumberOfTeamMembers(); // Asks for the number of team Members
        //setSchoolSponsor();
        this.randomNumber = randomNumber;
        setTeamRobot(teamRobot, randomNumber); // Creats Robot Object and ask for Robot Info
        setTeamMembers(teamMembers);  // Creates Person Objects and Asks for team member info    
        currentRobotStatus = teamRobot.getCurrentRobotStatus();
        setJudgeStatus(judgeStatus); // Sets original judging status
        this.maxNumberofTeams = numberOfTeams;
        setRankingPoints(); // Sets the ranking points randomly
        setQualifyingPoints(); // Sets the qualifying points randomly
        setJudgingPoints(); // Sets the judging points randomly
        this.teamNumber = teamNumber;
        setGameStatus(gameStatus); // Sets the game Status
        
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName() {
        System.out.println();
        System.out.println("Please enter the team name (String Value)");
        teamName = input.nextLine();
        this.teamName = teamName;
        newTeamsList.add(teamName);
    }
    

    public int getNumberOfTeamMembers() {
        return numberOfTeamMembers;
    }

    public void setNumberOfTeamMembers(){
        System.out.println();
        System.out.println("Please enter the number of team Members(Integer Value)");
        numberOfTeamMembers = input.nextInt();
        this.numberOfTeamMembers = numberOfTeamMembers;
    }

    public String getSchoolSponsor() {
        return schoolSponsor;
    }

    public void setSchoolSponsor() {
        System.out.println();
        System.out.println("Please enter the name of the school sponsoring your team(String Value)");
        schoolSponsor = input.nextLine();
        this.schoolSponsor = schoolSponsor;
    }

    public String getFinancialSponsor() {
        return financialSponsor;
    }

    public void setFinancialSponsor() {
        System.out.println();
        System.out.println("Please enter the name of the financial sponsor sponsoring your team(String Value)");
        financialSponsor = input.nextLine();
        this.financialSponsor = financialSponsor;
    }

    public int getJudgingTime() {
        return judgingTime;
    }

    public void setJudgingTime(int judgingTime) {
        this.judgingTime = judgingTime;
    }

    public String getJudgingLocation() {
        return judgingLocation;
    }

    public void setJudgingLocation(String judgingLocation) {
        this.judgingLocation = judgingLocation;
    }

    public Robot getTeamRobot() {
        return teamRobot;
    }

    public void setTeamRobot(Robot teamRobot, int randomNumber) {
        teamRobot = new Robot(RobotStatus.READY, randomNumber);
        this.teamRobot = teamRobot;
    }

    public PersonClass[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(PersonClass[] teamMembers) {
        int teamMemberCount = numberOfTeamMembers;
        
        for(int i = 0; i < numberOfTeamMembers; i++)
        {
            teamMembers[i] = new TeamMemberClass(teamNumber);
        }
    }

    public TeamGameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(TeamGameStatus gameStatus) {
        if(teamRobot.getCurrentRobotStatus() == RobotStatus.FIELD_TEST_PASED)
        {
            this.gameStatus = TeamGameStatus.PASS_SINPECTION;
        }
        else
            this.gameStatus = gameStatus;
    }

    public TeamJudgingStatus getJudgeStatus() {
        return judgeStatus;
    }

    public void setJudgeStatus(TeamJudgingStatus judgeStatus) {
        if(this.currentRobotStatus == RobotStatus.FIELD_TEST_PASED)
        {
            this.judgeStatus = TeamJudgingStatus.COMPLETED;
        }
        else
            this.judgeStatus = judgeStatus;
    }

    public RobotStatus getCurrentRobotStatus() {
        return currentRobotStatus;
    }

    public void setCurrentRobotStatus(RobotStatus currentRobotStatus) {
        this.currentRobotStatus = currentRobotStatus;
    }

    public int getRankingPoints() {
        return rankingPoints;
    }

    public void setRankingPoints() {    
        this.rankingPoints = rndm.nextInt(1576);
    }

    public int getJudgingPoints() {
        return judgingPoints;
    }

    public void setJudgingPoints() {
        this.judgingPoints = rndm.nextInt(maxNumberofTeams);
    }

    public int getQualifyingPoints() {
        return qualifyingPoints;
    }

    public void setQualifyingPoints() {
        this.qualifyingPoints = rndm.nextInt(10);
    }

    
    @Override public String toString()
    {
        return String.format("Team Name: " + teamName);
    }
}
