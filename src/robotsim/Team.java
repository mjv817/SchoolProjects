/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * THE TEAM CLASS HOLDS ALL TEAM SPECIFIC INFORMATION
 * HOLDS ARRAY FOR TEAM MEMBER ARRAY LIST 
 * @author Matt
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * THE TEAM CLASS HOLDS ALL TEAM SPECIFIC INFORMATION
 * HOLDS ARRAY FOR TEAM MEMBER ARRAY LIST
 * @author Matt
 */
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
    private ArrayList<Robot> teamRobots = new ArrayList();
    private Robot robotSignIn;
    private Scanner inFile2;
    
    
    private Robot  teamRobot;
    //private TeamMemberClass[] teamMembers = new TeamMemberClass [maxTeamSize];
    private ArrayList<PersonClass> teamMembers = new ArrayList();
    private File memberInfoFile;
    
    
    /**
     *
     * @param gameStatus
     * @param judgeStatus
     * @param numberOfTeams
     * @param randomNumber
     */
    public Team(TeamGameStatus gameStatus, TeamJudgingStatus judgeStatus, int numberOfTeams, int randomNumber) {
        setTeamName(); // Ask for user for Team name
        setFinancialSponsor(); // Ask for nameof financial sponsor
        setNumberOfTeamMembers(); // Asks for the number of team Members
        //setSchoolSponsor();
        this.randomNumber = randomNumber;
        setTeamRobot(teamRobot, randomNumber); // Creats Robot Object and ask for Robot Info
        //setTeamMembers(teamMembers);  // Creates Person Objects and Asks for team member info    
        currentRobotStatus = teamRobot.getCurrentRobotStatus();
        setJudgeStatus(judgeStatus); // Sets original judging status
        this.maxNumberofTeams = numberOfTeams;
        //setRankingPoints(); // Sets the ranking points randomly
        //setQualifyingPoints(); // Sets the qualifying points randomly
        //setJudgingPoints(); // Sets the judging points randomly
        this.teamNumber = teamNumber;
        setGameStatus(gameStatus); // Sets the game Status
        
    }
    
    /**
     *
     * @param teamNumber
     * @param maxNumberOfTeams
     */
    public Team(int teamNumber , int maxNumberOfTeams)
    {
        int counter = teamNumber;
        System.out.println();
        //System.out.println("This Construcer is being used");
        System.out.println("You are Team Number: "+ counter + "!!!!!!!! PLEASE REMEMBER YOU TEMEMBER NUMBER");
        System.out.println("-------------------------------------------------");
        setTeamName();
        setFinancialSponsor();
        setNumberOfTeamMembers();
        setTeamNumber(teamNumber);
        setTeamMembers(teamNumber);
        this.maxNumberofTeams = maxNumberOfTeams;
       
    }

    /**
     *
     * @param teamNumber
     * @param maxNumberOfTeams
     * @param teamFileInput
     * @param inFile
     * @param memberInfo
     * 
     */
    
    public Team(int teamNumber , int maxNumberOfTeams , String[] teamFileInput,File memberInfo, Scanner inFile)
    {
        int counter = teamNumber;
        System.out.println();
        //System.out.println("You are Team Number: "+ counter + "!!!!!!!! PLEASE REMEMBER YOU TEMEMBER NUMBER");
        //System.out.println("-------------------------------------------------");

        this.maxNumberofTeams = maxNumberOfTeams;
       
        

        
        //String teamInfo = inFile.nextLine();
        //String[] teamInformation = teamInfo.split(",");
        
        
        String teamNameFile = teamFileInput[0];
        String teamSponsorFile = teamFileInput[1];
        int maxTeamMembersFile = Integer.parseInt(teamFileInput[2]);
        
        setTeamName(teamNameFile);
        setFinancialSponsor(teamSponsorFile);
        setNumberOfTeamMembers(maxTeamMembersFile);
        setTeamNumber(teamNumber);
        
        setTeamMembers(teamNumber, memberInfo,inFile);
    }
        
    /**
     *
     * @return
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     *
     */
    public void setTeamName() {
        System.out.println();
        System.out.println("Please enter the team name (String Value)");
        teamName = input.nextLine();
        this.teamName = teamName;
        newTeamsList.add(teamName);
    }
    
    /**
     *
     * @return
     */
    public int getNumberOfTeamMembers() {
        return numberOfTeamMembers;
    }

    /**
     *
     */
    public void setNumberOfTeamMembers(){
        System.out.println();
        System.out.println("Please enter the number of team Members(Integer Value)");
        numberOfTeamMembers = input.nextInt();
        this.numberOfTeamMembers = numberOfTeamMembers;
    }

    /**
     *
     * @return
     */
    
    public String getSchoolSponsor() {
        return schoolSponsor;
    }

    /**
     *
     */
    public void setSchoolSponsor() {
        System.out.println();
        System.out.println("Please enter the name of the school sponsoring your team(String Value)");
        schoolSponsor = input.nextLine();
        this.schoolSponsor = schoolSponsor;
    }

    /**
     *
     * @return
     */
    public String getFinancialSponsor() {
        return financialSponsor;
    }

    /**
     *
     */
    public void setFinancialSponsor() {
        System.out.println();
        System.out.println("Please enter the name of the financial sponsor sponsoring your team(String Value)");
        financialSponsor = input.nextLine();
        this.financialSponsor = financialSponsor;
    }

    /**
     *
     * @return
     */
    public int getJudgingTime() {
        return judgingTime;
    }

    /**
     *
     * @param judgingTime
     */
    public void setJudgingTime(int judgingTime) {
        this.judgingTime = judgingTime;
    }

    /**
     *
     * @return
     */
    public String getJudgingLocation() {
        return judgingLocation;
    }

    /**
     *
     * @param judgingLocation
     */
    public void setJudgingLocation(String judgingLocation) {
        this.judgingLocation = judgingLocation;
    }

    /**
     *
     * @return
     */
    public Robot getTeamRobot() {
        return teamRobot;
    }

    /**
     *
     * @param teamRobot
     * @param randomNumber
     */
    public void setTeamRobot(Robot teamRobot, int randomNumber) {
        teamRobot = new Robot(RobotStatus.READY, randomNumber);
        this.teamRobot = teamRobot;
    }
    
    /**
     *
     * @param teamNumber
     */
    public void setTeamRobot(int teamNumber) {
        System.out.println("========================================================\n");
        teamRobot = new Robot(teamNumber);
        this.teamRobot = teamRobot;
    }

    /**
     *
     * @return
     */
    
    /*
    public ArrayList getTeamMembers() {
        return teamMembers;
    }
    */
    

    /**
     *
     * @param teamNumber
     */
    public void setTeamMembers(int teamNumber) {
        int teamMemberCount = numberOfTeamMembers;
        
        for(int i = 0; i < numberOfTeamMembers; i++)
        {
            teamMembers.add(new TeamMemberClass(teamNumber));
        }
    }
    
    /**
     *
     * @param teamNumber
     * @param memberInfoFromFile
     * @param inFile3
     */
    public void setTeamMembers(int teamNumber, File memberInfoFromFile,Scanner inFile3)
    {
        /*
        Scanner inFile3;
        try
        {
            inFile3 = new Scanner(memberInfoFromFile);
        }
        catch ( FileNotFoundException f)
        {
            inFile3 = new Scanner(System.in);
            System.out.println("Team Member Information file not found");
        }
        
        */
        
        for(int i = 0; i < numberOfTeamMembers; i++)
        {
           String memberStringFile = inFile3.nextLine();
           
           String[] memberInfoArray = memberStringFile.split(",");
           teamMembers.add(new TeamMemberClass(teamNumber,memberInfoArray));
        }
        
        
    }

    /**
     *
     * @return
     */
    public TeamGameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     *
     * @param gameStatus
     */
    public void setGameStatus(TeamGameStatus gameStatus) {
            this.gameStatus = gameStatus;
    }

    /**
     *
     * @return
     */
    public TeamJudgingStatus getJudgeStatus() {
        return judgeStatus;
    }

    /**
     *
     * @param judgeStatus
     */
    public void setJudgeStatus(TeamJudgingStatus judgeStatus) {

            this.judgeStatus = judgeStatus;
            System.out.println("Your Judging Status has been changed to " + judgeStatus);
    }

    /**
     *
     * @return
     */
    public RobotStatus getCurrentRobotStatus() {
        return currentRobotStatus;
    }

    /**
     *
     * @param currentRobotStatus
     */
    public void setCurrentRobotStatus(RobotStatus currentRobotStatus) {
        this.currentRobotStatus = currentRobotStatus;
    }

    /**
     *
     * @return
     */
    public int getRankingPoints() {
        return rankingPoints;
    }

    /**
     *
     * @param randomNumber
     */
    public void setRankingPoints(int randomNumber) { 
        rndm = new Random(randomNumber);
        int test;        
        test = rndm.nextInt(1576);
        test += 1;
        this.rankingPoints = test;
    }

    /**
     *
     * @return
     */
    public int getJudgingPoints() {
        return judgingPoints;
    }

    /**
     *
     * @param randomNumber
     */
    public void setJudgingPoints(int randomNumber) {
        rndm = new Random(randomNumber);
        int test;
        test = rndm.nextInt(maxNumberofTeams + 1);
        this.judgingPoints = test;
    }

    /**
     *
     * @return
     */
    public int getQualifyingPoints() {
        return qualifyingPoints;
    }

    /**
     *
     * @param randomNumber
     */
    public void setQualifyingPoints(int randomNumber) {
        rndm = new Random(randomNumber);
        int test;
        test = rndm.nextInt(10);
        test += 1;
        this.qualifyingPoints = test;
    }

    /**
     *
     * @return
     */
    public int getTeamNumber() {
        return teamNumber;
    }

    /**
     *
     * @param teamNumber
     */
    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }
    
    /**
     *
     * @param teamNameEdit
     */
    public void setTeamName(String teamNameEdit)
    {
        this.teamName = teamNameEdit;
    }
    
    /**
     *
     * @param sponsorEdit
     */
    public void setFinancialSponsor(String sponsorEdit)
    {
        this.financialSponsor = sponsorEdit;
    }
    
    /**
     *
     * @param numTeamsEdit
     */
    public void setNumberOfTeamMembers(int numTeamsEdit)
    {
        this.numberOfTeamMembers = numTeamsEdit;
    }

    /**
     *
     * @return
     */
    public ArrayList<PersonClass> getTeamMembers() 
    {
        return teamMembers;
    }
    
    
    
    @Override public String toString()
    {
        return String.format("Team Name: " + teamName  + "\n" + "Team Number: " + teamNumber + "\n" + "# of Team Meambers : " + numberOfTeamMembers + "\n" + "Finacial Sponsor: " + financialSponsor);
    }
}
