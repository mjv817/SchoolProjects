/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * ALL TOURNAMNET INFORMATOIN IS RUN THROUGH THE TOURNAMENT CLASS
 * TEAM SET UP / ROBOT SET UP/ TEAM MEMBER INFORMATION
 * INCLUDES MENU OPTIONS FOR VARIOUS TASKS
 * @author Matt
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.Formatter;
import javax.swing.JFrame;
import javax.swing.*;
//import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 * ALL TOURNAMNET INFORMATOIN IS RUN THROUGH THE TOURNAMENT CLASS
 * TEAM SET UP / ROBOT SET UP/ TEAM MEMBER INFORMATION
 * INCLUDES MENU OPTIONS FOR VARIOUS TASKS
 * @author Matt
 */
public class Tournament implements PublicSaftey{
    private String tournamentName;
    private String tournamentDate;
    private String tournamentLocation;
    private String teamName;
    private int maxNumberOfTeams;
    private ArrayList<String> currentListofTeams = new ArrayList();
    private int numberOfHardwareStations;
    private int numberOfSoftwareStations;
    private int numberOfFieldtestingStations;
    private int numberOfJudgingLocations;
    private ArrayList<String> gameFieldNames = new ArrayList();
    private ArrayList<Integer> teamRankingsQP = new ArrayList();
    private Scanner input = new Scanner(System.in);
    TournamentStatus tStatus = TournamentStatus.INSPECTIONS;
    private Team[] newTeams;
    private Tournament updatedTournament;
    private int randomNumber = 1;
    private int counter = 1;
    private ArrayList<RobotStatus>  teamRobotStatus = new ArrayList();
    private ArrayList<PersonClass> teamMemberList = new ArrayList();
    private ArrayList<TeamGameStatus> gameStatus = new ArrayList();
    private int userChoice = 1;
    private ArrayList<Team> newTeamsTest = new ArrayList();
    private int teamInputNumber;
    private ArrayList<Integer> judgingScoresList = new ArrayList();
    private ArrayList<Integer> rankingScoresList = new ArrayList();
    private ArrayList<Integer> qualilifyingScoresList = new ArrayList();
    private int[] judgingScoresArray;
    private int[] rankingScoresArray;
    private int[] quallyScoresArray;
    private String[] teamNameArray;
    
    private ArrayList<Visitor> visitorAdds = new ArrayList();
    private ArrayList<TourneyStaff> tourneyStaffAdds = new ArrayList();
    private ArrayList<Inspector> inspectorAdds = new ArrayList();
    private ArrayList<GeneralEventStaff> generalStaffAdds = new ArrayList();
    private ArrayList<Referee> refereeAdds = new ArrayList();
    private ArrayList<Judge> judgeAdds  = new ArrayList();
    private ArrayList<TournamentDirector> tournDirector = new ArrayList();
    private ArrayList<CoachClass> coachArray = new ArrayList();
    private boolean fileStatus;
    private File myTeamFile;
    private File teamMemberFile = new File("memberInformation2.csv");
    //private File teamCoachFile = new File("Tourney1coaches.csv");
    private Scanner inFile2;
    private ArrayList preRegisterTeams = new ArrayList();
    private ArrayList gameMatches = new ArrayList();
    private ArrayList gameMatchScores = new ArrayList();
    private int currentMatch = 0;
    private int SafteyIssues;
    WriteToAwardFile outputdata = new WriteToAwardFile();
    private static ArrayList<Team> teamRobotInfo;
    private Random rndm = new Random();
    ScopeOfSaftey scopeSaftey;
    
    // Main Tournan Constructor that sets sets up the major components of the program    

    /**
     * Asks for User Entered Information
     */
        public Tournament()
    {
        System.out.println("TOURNAMENT SETUP PROCESS");
        System.out.println("PLEASE ANSWER ALL QUESTIONS CAREFULLY");
        System.out.println();
        //setTournamentName(); // Ask for Team Name
        //setTournamentDate(); // Gets Date of Tournament
        //setTournamentLocation(); // Gets Location of Tournament
        //setMaxNumberOfTeams(); // Gets Max Number of Teams
        //setNumberOfHardware(); // Gets the number of hardware stations
        //setNumberOfSoftware(); // Gets the number of software stations
        //setNumberOfFieldTesting(); // gets the number of fieldtesting stations
        //setNumberOfJudgingLocations(); // gets the number of judging locations

        
        setTournamentInfoFromFile();        
        addTeamsFromFile();

        System.out.println("CURRENT LIST OF TEAMS AND TEAM NUMBERS");
        showTeamNameAndNumbers();
        do{
        input = new Scanner(System.in);
        
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Enter the corresponding number to perform a task(EX Enter (1) or (2)");
        System.out.println("(1) : Have a Robot Team Sign in. Must REMEMBER Team Number from \n Tournament Set Up");
        System.out.println("(2) : Have a preparing team turn a Robot on for Inspections");
        System.out.println("(3) : Take a preparing team with a ready robot to a hardware Inspection");
        System.out.println("(4) : Take a preparing team with a passed hardware inspection to a software Inspection");
        System.out.println("(5) : Take a preparing team with a passed software inspection to a field testing Inspection");
        System.out.println("(6) : Take a team to a judgeing station to be interviewed");
        System.out.println("(7) : If Team has passed field testing then change team status to passed inspection");
        System.out.println("(8) : Change Tournament Status to Match Generation if all teams have completed judging");
        System.out.println("(9) : Check Tournament Status and Team eligiblilty");
        System.out.println("(10): Check Team Robot Status Eligibility");
        System.out.println("(11): Play Matches with all eligible teams");
        System.out.println("(12): Record Judging Results for each eligible team");
        System.out.println("(13): If all teams have completed matches and judging CHANGE tournament Status to Awards");
        System.out.println("(14): List the top ranking teams from points score by JUDGING");
        System.out.println("(15): List Top Ranking Team by Qaulifying Points");
        System.out.println("(16): Print Team Information");
        System.out.println("(17): Print Robot Informatoin");
        System.out.println("(18): Print Tournament Information");
        System.out.println("(19): Print Team Member Information");
        System.out.println("(20): Have Tournament STAFF and Visitors Sign In");
        System.out.println("(21): Print all tournament Staff Info");
        System.out.println("(22): Modify Team Information");
        System.out.println("(23): Modify Team Member Information");
        System.out.println("(24): Print Robot Saftey Issues");
        System.out.println("(25): Write Award Information to a File");
        System.out.println("(26): Have a robot perfom actions");
        System.out.println("(27): Display the type of Robot Saftey Issues");
        System.out.println("(30): To Exit the program enter a INTEGER of 30 to exit");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println();
        
        
        userChoice = input.nextInt();
        
        switch(userChoice){
            case 1: System.out.println("Please Enter your team number");
                    teamInputNumber = input.nextInt();
                    if(testInputNumber(teamInputNumber))
                    {
                        newTeamsTest.get(teamInputNumber).setTeamRobot(teamInputNumber);
                        currentListofTeams.add(newTeamsTest.get(teamInputNumber).getTeamName());
                        newTeamsTest.get(teamInputNumber).setGameStatus(TeamGameStatus.PREPARING);
                        newTeamsTest.get(teamInputNumber).setJudgeStatus(TeamJudgingStatus.BEFORE);
                        userChoice = 0;
                        break;
                    }
                    else
                    {
                        System.out.println("You Entered an invalid team number the program menu will reset");
                        userChoice = 0;
                        break;
                    }
            case 2: System.out.println("Please Enter your team number");
                    teamInputNumber = input.nextInt();
                    if(testInputNumber(teamInputNumber)) // Checks to see if number is in index range
                    {
                        if(newTeamsTest.get(teamInputNumber).getGameStatus() == TeamGameStatus.PREPARING) // Checks to see if Step 1 has been completed
                        {
                            if(newTeamsTest.get(teamInputNumber).getTeamRobot() == null)
                            {
                                System.out.println("No robot has been Signed in for this Team please go back to Step 1");
                                break;
                            }
                            else
                            {
                                newTeamsTest.get(teamInputNumber).getTeamRobot().setCurrentRobotStatus(RobotStatus.READY);
                                userChoice = 0;
                                break; 
                            }
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Your Team Status has not been set to preparing. Please go back to Step 1");
                            System.out.println("------------------------------------------------------------------------");
                            userChoice = 0;
                            break;
                        }
                        
                        
                    }
                    else
                    {
                        System.out.println("You Entered an invalid team number the program menu will reset");
                        userChoice = 0;
                        break;
                    }
                    
            case 3: System.out.println("Please Enter your team number");
                    teamInputNumber = input.nextInt();
                    if(testInputNumber(teamInputNumber)) // Checks to see if number is in index range
                    {
                        //System.out.println("Current Robot Status: " + newTeamsTest.get(teamInputNumber).getTeamRobot().getCurrentRobotStatus());
                        if(newTeamsTest.get(teamInputNumber).getTeamRobot() != null  && newTeamsTest.get(teamInputNumber).getTeamRobot().getCurrentRobotStatus() == RobotStatus.READY)
                        {
                            newTeamsTest.get(teamInputNumber).getTeamRobot().setHardwareStatus(RobotStatus.READY, randomNumber);
                            userChoice = 0;
                            randomNumber +=1;
                            break;
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("You have not completed step 2. Please go back and repeat step 2");
                            System.out.println("---------------------------------------------------------------");
                            userChoice = 0;
                            randomNumber +=1;
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("You Entered an invalid team number the program menu will reset");
                        userChoice = 0;
                        break;
                    }
            
            case 4: System.out.println("Please Enter your team number");
                    teamInputNumber = input.nextInt();
                    if(testInputNumber(teamInputNumber)) // Checks to see if number is in index range
                    {
                        if(newTeamsTest.get(teamInputNumber).getTeamRobot() != null && newTeamsTest.get(teamInputNumber).getTeamRobot().getCurrentRobotStatus() == RobotStatus.HW_INSP_PASSED)
                        {
                            newTeamsTest.get(teamInputNumber).getTeamRobot().setSoftwareStatus(newTeamsTest.get(teamInputNumber).getTeamRobot().getCurrentRobotStatus(), randomNumber);
                            userChoice = 0;
                            randomNumber +=1;
                            break;
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Your Robot has not passed hardware inspectoin. Complete Step 3 before moving on");
                            System.out.println("-------------------------------------------------------------------------------");
                            userChoice = 0;
                            randomNumber +=1;
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("You Entered an invalid team number the program menu will reset");
                        userChoice = 0;
                        break;
                    }
            case 5: System.out.println("Please Enter your team number");
                    teamInputNumber = input.nextInt();
                    if(testInputNumber(teamInputNumber)) // Checks to see if number is in index range
                    {
                        if(newTeamsTest.get(teamInputNumber).getTeamRobot() != null && newTeamsTest.get(teamInputNumber).getTeamRobot().getCurrentRobotStatus() == RobotStatus.SW_INSP_PASSED)
                        {
                            newTeamsTest.get(teamInputNumber).getTeamRobot().setFieldTest(newTeamsTest.get(teamInputNumber).getTeamRobot().getCurrentRobotStatus(), randomNumber);
                            userChoice = 0;
                            randomNumber +=1;
                            break;
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Your Robot has not passed software inspectoin. Complete Step 4 before moving on");
                            System.out.println("-------------------------------------------------------------------------------");
                            userChoice = 0;
                            randomNumber +=1;
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("You Entered an invalid team number the program menu will reset");
                        userChoice = 0;
                        break;
                    }
            case 6: System.out.println("Please Enter your team number");
                    teamInputNumber = input.nextInt();
                    if(testInputNumber(teamInputNumber)) // Checks to see if number is in index range
                    {
                        newTeamsTest.get(teamInputNumber).setJudgeStatus(TeamJudgingStatus.COMPLETED);
                        userChoice = 0;
                        randomNumber +=1;
                        break;
                    }
                    else
                    {
                        System.out.println("You Entered an invalid team number the program menu will reset");
                        userChoice = 0;
                        break;
                    }
            case 7: System.out.println("Please Enter your team number");
                    teamInputNumber = input.nextInt();
                    if(testInputNumber(teamInputNumber)) // Checks to see if number is in index range
                    {
                        if(newTeamsTest.get(teamInputNumber).getTeamRobot() != null && newTeamsTest.get(teamInputNumber).getTeamRobot().getCurrentRobotStatus() == RobotStatus.FIELD_TEST_PASED)
                        {
                            newTeamsTest.get(teamInputNumber).setGameStatus(TeamGameStatus.PASS_SINPECTION);
                            System.out.println("You Team status has been changed to PASSED INSPECTION");
                            System.out.println();
                        }
                        else
                        {
                            System.out.println("You have not completed your inspections or a robot might not have have signed in");
                        }
                        userChoice = 0;
                        randomNumber +=1;
                        break;
                    }
                    else
                    {
                        System.out.println("You Entered an invalid team number the program menu will reset");
                        userChoice = 0;
                        break;
                    }
            case 8:  settStatus(tStatus);
                     userChoice = 0;
                     randomNumber +=1;
                     break;                        
                        
                    
            case 9:  checkTeamRobotAndJudging();
                     userChoice = 0;
                     randomNumber +=1;
                     break; 
                
            case 10: checkTeamRobotStatus();
                     userChoice = 0;
                     randomNumber +=1;
                     break; 
            case 11: //generateMatchResults();
                     playMatches();
                     userChoice = 0;
                     randomNumber +=1;
                     break; 
            
            case 12: recordJudgingResults();
                     userChoice = 0;
                     randomNumber +=1;
                     break; 
            case 13: setTournamentStatusAwards();
                     userChoice = 0;
                     randomNumber +=1;
                     break; 
            
            case 14: listTopJudgedTeams();
                     userChoice = 0;
                     randomNumber +=1;
                     break;
            
            case 15: listTopQuallyTeams();
                     userChoice = 0;
                     randomNumber +=1;
                     break;
            
            case 16: printTeamInformation();
                     userChoice = 0;
                     randomNumber +=1;
                     break;
            
            case 17: {
                    try {
                          displayRobotGUIO();
                        } 
                    catch (InterruptedException ex) 
                        {
                        Logger.getLogger(Tournament.class.getName()).log(Level.SEVERE, null, ex);
                        }           
        }
                     userChoice = 0;
                     randomNumber +=1;
                     break;
            
            case 18: printTournamentInformation();
                     userChoice = 0;
                     randomNumber +=1;
                     break;
                
            case 19: printTeamMemberInfo();
                     userChoice = 0;
                     randomNumber +=1;
                     break;
                
            case 20: addTournyStaff();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
                
            case 21: printTournyStaff();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
            
            case 22: modifyTeamInfo();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
                
            case 23: modifyTeamMemberInfo();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
             
            case 24: displaySafteyIssues();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
            
                
            case 25: outputdata.openFile();
                     writeAwardsToFile();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
                
            case 26: displayComboGUIRobot();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
                
            case 27: displayTypeOfIssue();
                     userChoice = 0;
                     randomNumber += 1;
                     break;
                
            
            case 30: System.out.println("The Program will exit");
                    break;
            default: System.out.print("You enter an invalid choice. System will restart");
                    break;
        }
        }while(userChoice != 30);
        
       
        
        
        
    }

    /**
     *
     * @param updatedTournament
     */
    public Tournament(Tournament updatedTournament)
    {
        this.updatedTournament = updatedTournament;
        settStatus(TournamentStatus.MATCHES);
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
     */
    public void setTournamentName() {
        System.out.println();
        System.out.println("Please enter the name of the Tournament");
        tournamentName = input.nextLine();
        
        this.tournamentName = tournamentName;
    }

    /**
     *
     * @return
     */
    public String getTournamentDate() {
        return tournamentDate;
    }

    /**
     *
     */
    public void setTournamentDate() {
        System.out.println();
        System.out.println("Please enter the date of the competition and use the following format (XX XX XXXX Integer Value)");
        tournamentDate = input.nextLine();
        //System.out.println(tournamentDate);
        this.tournamentDate = tournamentDate;
    }

    /**
     *
     * @return
     */
    public String getTournamentLocation() {
        return tournamentLocation;
    }

    /**
     *
     */
    public void setTournamentLocation() {
        System.out.println();
        System.out.println("Please Enter the location of the Tournament (String/Char Value)");
        tournamentLocation = input.nextLine();
       // System.out.println(tournamentLocation);
    }

    /**
     *
     * @return
     */
    public int getMaxNumberOfTeams() {
        return maxNumberOfTeams;
    }

    /**
     *
     */
    public void setMaxNumberOfTeams() {
        System.out.println();
        System.out.println("Please enter the  number of teams competiting(Integer Value)");
        maxNumberOfTeams = input.nextInt();
        //System.out.println(maxNumberOfTeams);
        this.maxNumberOfTeams = maxNumberOfTeams;
    }
    
    /**
     *
     */
    public void setNumberOfHardware()
    {
        System.out.println();
        System.out.println("Please enter the number of hardware stations available(Integer Value)");
        numberOfHardwareStations = input.nextInt();
    }

    /**
     *
     */
    public void setNumberOfSoftware()
    {
        System.out.println();
        System.out.println("Please enter the number of software stations available(Integer Value)");
        numberOfSoftwareStations = input.nextInt();
    }

    /**
     *
     */
    public void setNumberOfFieldTesting()
    {
        System.out.println();
        System.out.println("Please enter the number of Field Testing stations available(Integer Value)");
        numberOfFieldtestingStations = input.nextInt();
    }

    /**
     *
     */
    public void setNumberOfJudgingLocations()
    {
        System.out.println();
        System.out.println("Please enter the number of judging locations available(Integer Value)");
        numberOfJudgingLocations = input.nextInt();
    }

    /**
     *
     * @return
     */
    public int getNumberOfHardwareStations() {
        return numberOfHardwareStations;
    }

    /**
     *
     * @return
     */
    public int getNumberOfSoftwareStations() {
        return numberOfSoftwareStations;
    }

    /**
     *
     * @return
     */
    public int getNumberOfFieldtestingStations() {
        return numberOfFieldtestingStations;
    }

    /**
     *
     * @return
     */
    public int getNumberOfJudgingLocations() {
        return numberOfJudgingLocations;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getCurrentListofTeams() {
        return currentListofTeams;
    }

    /**
     *
     * @param currentListofTeams
     */
    public void setCurrentListofTeams(ArrayList<String> currentListofTeams) {
        currentListofTeams = currentListofTeams;
    }
    
    /**
     *
     * @param currentListofTeams
     */
    public void addingToTeamNameList(ArrayList currentListofTeams)
    {
        
    }
    
    /**
     *
     */
    public void addTeam()
    {
        int i;
        int counter = 1;
        int exit = 1;
        
        while(exit > 0 && counter < maxNumberOfTeams)
        {
            System.out.println();
            System.out.println();

            System.out.println("The max number of teams is set to"+ maxNumberOfTeams);
            System.out.println("Please enter the name of team "+counter);
            teamName = input.nextLine();
            currentListofTeams.add(teamName);
            
            System.out.println("To finish entering the team names enter a -1 to exit or 1 to continue");
            counter++;
            exit = input.nextInt();
        }
        
    }

    /**
     *
     * @return
     */
    public TournamentStatus gettStatus() {
        return tStatus;
    }

    /**
     *
     * @param tStatus
     */
    public void settStatus(TournamentStatus tStatus) {
        boolean judgingCompleted = true;
        if(tStatus == TournamentStatus.INSPECTIONS)
        {
            for(int i = 0; i < maxNumberOfTeams; i++)
            {
                if(newTeamsTest.get(i).getJudgeStatus() == TeamJudgingStatus.COMPLETED)
                {
                    System.out.println("Team Number: "+ i + " has completed judging");
                }
                else
                {
                    judgingCompleted = false;
                    System.out.println("Team Number: "+ i + " has NOT comleted judging");
                }
                    
            }
        }
        if(judgingCompleted == true)
        {
          this.tStatus = TournamentStatus.MATCH_GENERATION;
          System.out.println("The tournament status has been changed to " + this.tStatus);
        }
        else
            System.out.println("A team has not completed judging");
        
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getGameFieldNames() {
        return gameFieldNames;
    }

    /**
     *
     * @param gameFieldNames
     */
    public void setGameFieldNames(ArrayList<String> gameFieldNames) {
        this.gameFieldNames = gameFieldNames;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getTeamRankingsQP() {
        return teamRankingsQP;
    }

    /**
     *
     * @param teamRankingsQP
     */
    public void setTeamRankingsQP(ArrayList<Integer> teamRankingsQP) {
        this.teamRankingsQP = teamRankingsQP;
    }

    /**
     *
     * @return
     */
    public Team[] getNewTeams() {
        return newTeams;
    }

    /**
     *
     */
    public void setNewTeams() {
     // Array for holding team objects
     this.newTeams = newTeams;
     newTeams = new Team[maxNumberOfTeams];
     System.out.println();
     System.out.println();
     System.out.println("MAX NUMBER OF TEAMS: " + maxNumberOfTeams+" !!!!!!!!!!!");
     System.out.println("IN THE FOLLOWING QUESTIONS YOU WILL BE ASKED TO ENTER TEAM AND MEMBER INFO");
     System.out.println("AS WELL AS ROBOT INFORMATION");
     System.out.println();
     // For loop for filling the team objects with Data
     for(int i = 0; i < maxNumberOfTeams; i++)
     {
        System.out.println("TEAM: "+ counter + "===================================");
        newTeams[i] = new Team(TeamGameStatus.PREPARING, TeamJudgingStatus.BEFORE, maxNumberOfTeams, randomNumber);
        currentListofTeams.add(newTeams[i].getTeamName());
        newTeams[i].getTeamMembers();
        gameStatus.add(newTeams[i].getGameStatus());
        randomNumber += 1;
        counter++;
     }
        
    }
    
    /**
     *
     * @param newTeams
     */
    public void printTeamInfo(Team[] newTeams)
    {
     System.out.println();
     this.newTeams = newTeams;
     for(int i = 0; i < maxNumberOfTeams; i++)
     {
        
        System.out.println(newTeams[i].getCurrentRobotStatus());
        System.out.println(newTeams[i].getJudgeStatus());
        System.out.println(newTeams[i].getTeamRobot());
        teamRobotStatus.add(newTeams[i].getCurrentRobotStatus());
        System.out.println();
        System.out.println("==========================================");
     }
      
    }
    
    /**
     *
     * @param currentListofTeams
     */
    public void printTeamList(ArrayList currentListofTeams)
    {
        System.out.println();
        int counter = 1;
        System.out.println("The the current list is of teams is: ");
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            
            System.out.println("Team: " + counter+" " + currentListofTeams.get(i));
            counter++;
        }
    }
    
    /**
     *
     * @param teamGameStatus
     */
    public void printGameStatus(ArrayList teamGameStatus)
    {
        System.out.println();
        int counter = 1;
        for(int i = 0; i < maxNumberOfTeams;i++)
        {
          System.out.println("Team "+counter+" Game Status is: "+teamGameStatus.get(i));

        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Team> getNewTeamsTest() {
        return newTeamsTest;
    }

    /**
     *
     * @param newTeamsTest
     */
    public void setNewTeamsTest(ArrayList<Team> newTeamsTest) {
        this.newTeamsTest = newTeamsTest;
    }
    
    /**
     *
     * @param inputNumber
     * @return
     */
    public boolean testInputNumber(int inputNumber)
    {
        boolean testVal = false;
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            if(i == inputNumber)
            {
                testVal = true;
            }
        }
        
        return testVal;
    }
    
    /**
     *
     */
    public void checkTeamRobotAndJudging()
    {
        if(this.tStatus == TournamentStatus.MATCH_GENERATION)
        {
            for(int i = 0; i < maxNumberOfTeams; i++)
            {
                if(newTeamsTest.get(i).getGameStatus() == TeamGameStatus.PASS_SINPECTION && newTeamsTest.get(i).getJudgeStatus() == TeamJudgingStatus.COMPLETED)
                {
                    System.out.println("Team Number: " + i + " has passed inspection and completed judging");
                    System.out.println("--------------------------------------------------------");
                    System.out.println();
                }
                else
                {
                    System.out.println("Team Number: " + i + " is not ready  to play");
                    System.out.println("--------------------------------------------------------");
                    System.out.println();
                }
                
                
            }
        }
        else
            System.out.println("Tournament is not in MATCH GENERATOIN mode");
    }
    
    /**
     *
     */
    public void checkTeamRobotStatus()
    {
        if(this.tStatus == TournamentStatus.MATCH_GENERATION)
        {
            for(int i = 0; i < maxNumberOfTeams; i++)
            {
                if(newTeamsTest.get(i).getTeamRobot().getCurrentRobotStatus() != RobotStatus.FIELD_TEST_PASED)
                {
                    newTeamsTest.get(i).setGameStatus(TeamGameStatus.INELIGIBLE);
                    System.out.println("Team Number: " + i + " has not passed Robot Inspection and cannot play in game mathes");
                    System.out.println("--------------------------------------------------------");
                    System.out.println();
                }
                else
                {
                    System.out.println("Team Number: " + i + " Robot is ready to play in game matches");
                    System.out.println("--------------------------------------------------------");
                    System.out.println();
                }
                
                
            }
        }
        else
            System.out.println("Tournament is not in MATCH GENERATION MODE");
    }
    
    /**
     *
     */
    public void generateMatchResults()
    {
        for(int i = 0; i < maxNumberOfTeams; i ++)
        {
            if(newTeamsTest.get(i).getJudgeStatus() == TeamJudgingStatus.COMPLETED && newTeamsTest.get(i).getTeamRobot().getCurrentRobotStatus() == RobotStatus.FIELD_TEST_PASED)
            {
            newTeamsTest.get(i).setRankingPoints(randomNumber);
            newTeamsTest.get(i).setQualifyingPoints(randomNumber);
            System.out.println();
            System.out.println("Team: "+ i + " Ranking Point Score: " + newTeamsTest.get(i).getRankingPoints());
            System.out.println("Team: "+ i + " Qualifying Point Score: " + newTeamsTest.get(i).getQualifyingPoints());         
            System.out.println("------------------------------------------------------------------------------");
            randomNumber += 1;
            } 
            else
            {
                System.out.println("Team: " + i + " is not eligible to play in matches");
            }
        }
    }
    
    /**
     *
     */
    public void recordJudgingResults()
    {
        for(int i = 0; i < maxNumberOfTeams; i ++)
        {
            if(newTeamsTest.get(i).getJudgeStatus() == TeamJudgingStatus.COMPLETED && newTeamsTest.get(i).getTeamRobot().getCurrentRobotStatus() == RobotStatus.FIELD_TEST_PASED)
            {
            newTeamsTest.get(i).setJudgingPoints(randomNumber);
            
            System.out.println();
            System.out.println("Team: "+ i + " Judging Score: " + newTeamsTest.get(i).getJudgingPoints());        
            System.out.println("------------------------------------------------------------------------------");
            randomNumber += 1;
            } 
            else
            {
                System.out.println("Team: " + i + " is not eligible to score judging");
            }
        }
    }
    
    /**
     *
     */
    public void showTeamNameAndNumbers()
    {
        for(int i = 0; i < maxNumberOfTeams; i ++)
        {
            System.out.println();
            System.out.println("---------------------------------------------------------------------");
            System.out.println("TEAM NAME: " + newTeamsTest.get(i).getTeamName() + " TEAM NUMBER: " + i);
            System.out.println("---------------------------------------------------------------------");
            
        }
    }
    
    /**
     *
     */
    public void setTournamentStatusAwards()
    {
        this.tStatus = TournamentStatus.MATCHES;
        if(tStatus == TournamentStatus.MATCHES)
        {
                   
            boolean completedJudgingAndMatches = false;
            for(int i = 0;i < maxNumberOfTeams; i++)
            {
                if(newTeamsTest.get(i).getJudgingPoints() != 0 && newTeamsTest.get(i).getJudgingPoints() != 0 && newTeamsTest.get(i).getQualifyingPoints() != 0)
                {
                    completedJudgingAndMatches = true;
                }
                else
                    completedJudgingAndMatches = false;
            }
        
            if(completedJudgingAndMatches == true)
            {
                this.tStatus = TournamentStatus.AWARDS;
                System.out.println();
                System.out.println("Tournmanet Status has been changed to " + this.tStatus);
            }
            else
                System.out.println("Not all teams have completed judging and match scoreing");
         }
        else
            System.out.println("Tournament is not in MATCH MODE please restart");
        
        
    }
    
    /**
     *
     */
    public void listTopJudgedTeams()
    {
        judgingScoresArray = new int[maxNumberOfTeams];
        teamNameArray = new String[maxNumberOfTeams];
        
        /*
        judgingScoresArray[0] = 2;
        judgingScoresArray[1] = 3;
        judgingScoresArray[2] = 1;
        */
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            judgingScoresArray[i] = newTeamsTest.get(i).getJudgingPoints();
            teamNameArray[i] = newTeamsTest.get(i).getTeamName();
        }
        
        for(int i = 0; i < judgingScoresArray.length - 1; i++)
        {
            int index = i;
            for(int j = i + 1; j < judgingScoresArray.length; j++)
            {
                if(judgingScoresArray[j] < judgingScoresArray[index])
                {
                    index = j;
                }
                
                int smallerNumber = judgingScoresArray[index];
                String smallerTeamName = teamNameArray[index];
                judgingScoresArray[index] = judgingScoresArray[i];
                judgingScoresArray[i] = smallerNumber;
                teamNameArray[index] = teamNameArray[i];
                teamNameArray[i] = smallerTeamName;                
            }
        }
        
        System.out.println("The Judging Scores Listed below from 1 to " + maxNumberOfTeams);
        for(int i = 0; i < maxNumberOfTeams; i ++)
        {
            System.out.println();
            System.out.println("TEAM NAME: " + teamNameArray[i] + " ------ Judging Score: " + judgingScoresArray[i]);
        }
    }
    
    /**
     *
     */
    public void listTopQuallyTeams()
    {
        teamNameArray = new String[maxNumberOfTeams];
        quallyScoresArray = new int[maxNumberOfTeams];
        
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            //judgingScoresArray[i] = newTeamsTest.get(i).getJudgingPoints();
            quallyScoresArray[i] = newTeamsTest.get(i).getQualifyingPoints();
            teamNameArray[i] = newTeamsTest.get(i).getTeamName();
        }
        
        for(int i = 0; i < quallyScoresArray.length - 1; i++)
        {
            int index = i;
            for(int j = i + 1; j < quallyScoresArray.length; j++)
            {
                if(quallyScoresArray[j] < quallyScoresArray[index])
                {
                    index = j;
                }
                
                int smallerNumber = quallyScoresArray[index];
                String smallerTeamName = teamNameArray[index];
                quallyScoresArray[index] = quallyScoresArray[i];
                quallyScoresArray[i] = smallerNumber;
                teamNameArray[index] = teamNameArray[i];
                teamNameArray[i] = smallerTeamName;                
            }
        }
        
        System.out.println("The qualifying Scores Ranked from Highest to Lowest:");
        for(int i = maxNumberOfTeams - 1; i >= 0; i--)
        {
            System.out.println();
            System.out.println("TEAM NAME: " + teamNameArray[i] + " ------ Qualififying Scores: " + quallyScoresArray[i]);
            System.out.println();
        }
    }
    
    /**
     *
     */
    public void printTeamInformation()
    {
        for(int i = 0;i < maxNumberOfTeams; i++)
        {
            System.out.println(newTeamsTest.get(i));
            //System.out.println(newTeamsTest.get(i).getTeamRobot());
            //System.out.println(newTeamsTest.get(i).getGameStatus());
        }
    }
    
    /**
     *
     */
    public void   printRobotInformation()
    {
        for(int i = 0;i < maxNumberOfTeams; i++)
        {
            //System.out.println(newTeamsTest.get(i));
            //System.out.println(newTeamsTest.get(i).getTeamRobot());
            if(newTeamsTest.get(i).getTeamRobot() == null)
            {
                JOptionPane.showMessageDialog(null,"No robot has been signed in for team number: " + i + ". Go to step 1");
            }
            else
            {
                JOptionPane.showMessageDialog(null, newTeamsTest.get(i).getTeamRobot());
            }
            //System.out.println(newTeamsTest.get(i).getGameStatus());
        }
        
        
    }
    
    /**
     *
     */
    public void printTournamentInformation()
    {
        System.out.println("Tournament Name: " + tournamentName + "\n" +"Tournament Date: "+tournamentDate + "\n" + "Tournament Location: "+tournamentLocation+"\n" + "Tournament Status: " + tStatus + "\n" + "Number of Teams: " + maxNumberOfTeams);
    }
    
    /**
     *
     */
    public void printTeamMemberInfo()
    {
        System.out.println();
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
           
            //System.out.println(newTeamsTest.get(i).getTeamMembers());
            JOptionPane.showMessageDialog(null, "Team Name:    " + newTeamsTest.get(i).getTeamName() + "\n\n\n" + newTeamsTest.get(i).getTeamMembers());
        }
    }
    
    /**
     *
     */
    public void addTournyStaff()
    {
        int userChoice2;
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Enter the corresponding number to sign in. (EX Enter (1) or (2)");
        System.out.println("(1) : TOURNAMENT DIRECTOR");
        System.out.println("(2) : JUDGE");
        System.out.println("(3) : REFEREE");
        System.out.println("(4) : INSPECTOR");
        System.out.println("(5) : GENERAL EVENT STAFF");
        System.out.println("(6) : VISITOR");
        System.out.println("(7) : TO EXIT THE MENU OPTION");
        userChoice2 = input.nextInt();
        
        switch(userChoice2){
            case 1: tournDirector.add(new TournamentDirector(tournamentName));
                    userChoice2 = 0;
                    break;
                
            case 2: judgeAdds.add(new Judge(tournamentName));
                    userChoice2 = 0;
                    break;
                
            case 3: refereeAdds.add(new Referee(tournamentName));
                    userChoice2 = 0;
                    break;
                
            case 4: inspectorAdds.add(new Inspector(tournamentName));
                    userChoice2 = 0;
                    break;
                
            case 5: generalStaffAdds.add(new GeneralEventStaff(tournamentName));
                    userChoice2 = 0;
                    break;
                
            case 6: visitorAdds.add( new Visitor());
                    userChoice2 = 0;
                    break;
                
            default:System.out.print("You entered an invalid choice. System will restart");
                    break;
        }
    }
    
    /**
     *
     */
    public void printTournyStaff()
    {
        System.out.println();
        System.out.println("Tournament Directors");
        for(int i = 0; i < tournDirector.size(); i ++)
        {
            
            System.out.println("--------------------");
            System.out.println(tournDirector.get(i));
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Judges");
        for(int i = 0; i < judgeAdds.size(); i ++)
        {
            
            System.out.println("--------------------");
            System.out.println(judgeAdds.get(i));
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Referees");
        for(int i = 0; i < refereeAdds.size(); i ++)
        {
            
            System.out.println("--------------------");
            System.out.println(refereeAdds.get(i));
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Inspectors");
        for(int i = 0; i < inspectorAdds.size(); i ++)
        {
            
            System.out.println("--------------------");
            System.out.println(inspectorAdds.get(i));
            System.out.println();
        }       
        
        System.out.println();
        System.out.println("General Staff");
        for(int i = 0; i < generalStaffAdds.size(); i ++)
        {
            
            System.out.println("--------------------");
            System.out.println(generalStaffAdds.get(i));
            System.out.println();
        } 
        
        System.out.println();
        System.out.println("Visitors");
        for(int i = 0; i < visitorAdds.size(); i ++)
        {
            
            System.out.println("--------------------");
            System.out.println(visitorAdds.get(i));
            System.out.println();
        }    
        
    }
    
    /**
     *
     * @param tournyName
     */
    public void setTourneyName(String tournyName)
    {
        this.tournamentName = tournyName;
    }
    
    /**
     *
     * @param tournyDate
     */
    public void setTourneyDate( String tournyDate)
    {
        this.tournamentDate = tournyDate;
    }
    
    /**
     *
     * @param tournyLoc
     */
    public void setTourneyLocation (String tournyLoc)
    {
        this.tournamentLocation = tournyLoc;
    }
    
    /**
     *
     * @param maxTeams
     */
    public void setMaxTeams (int maxTeams)
    {
        this.maxNumberOfTeams = maxTeams;
    }
    
    /**
     *
     * @param hardware
     */
    public void setHardware( int hardware)
    {
        this.numberOfHardwareStations = hardware;
    }
    
    /**
     *
     * @param software
     */
    public void setSoftware( int software)
    {
        this.numberOfSoftwareStations = software;
    }
    
    /**
     *
     * @param fieldTest
     */
    public void setFieldTest(int fieldTest)
    {
        this.numberOfFieldtestingStations = fieldTest;
    }
    
    /**
     *
     * @param judgingStations
     */
    public void setJudgingStat(int judgingStations)
    {
        this.numberOfJudgingLocations = judgingStations;
    }
    
    /**
     *
     * @return
     */
    public boolean checkTeamFile()
    {
        this.fileStatus = false;
        myTeamFile = new File("teamInfo2");
        Scanner inFile;
        try    
        {
            inFile = new Scanner(myTeamFile);
            this.fileStatus = true;
            return fileStatus;
            
        }
        catch (FileNotFoundException f)
        {
            inFile = new Scanner(System.in);
            System.out.println("Tournament Info File has not been found");
            return fileStatus;
        }
        
    }
    
    /**
     *
     */
    public void addTeamsFromFile()
    {
        
        File testMemberFile = openFileAndReturnFile(teamMemberFile);
        
        
        myTeamFile = new File("teamInfo3.csv");
        Scanner inFile;
        try    
        {
            inFile = new Scanner(myTeamFile);
            this.fileStatus = true;
            
            
        }
        catch (FileNotFoundException f)
        {
            inFile = new Scanner(System.in);
            System.out.println("Tournament Info File has not been found");
            
        }       
        
        Scanner inFile3;
        try
        {
            inFile3 = new Scanner(testMemberFile);
        }
        catch ( FileNotFoundException f)
        {
            inFile3 = new Scanner(System.in);
            System.out.println("Team Member Information file not found");
        }       

        
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
           String teamInfo = inFile.nextLine();
           String[] teamInformation = teamInfo.split(",");
           //String memberStringFile = inFile2.nextLine();
           //String[] memberInfoArray = memberStringFile.split(",");
           //System.out.println("-----------------"+memberStringFile);
           newTeamsTest.add(i,new Team(i, maxNumberOfTeams, teamInformation, testMemberFile,inFile3));
        }
        
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            preRegisterTeams.add(newTeamsTest.get(i).getTeamName());
        }
        
        //addCoachesFromFile();

    }
    
    /**
     *
     */
    public void setTournamentInfoFromFile()
    {
        File myFile = new File("testFile2.csv");
        Scanner inFile;
        try    
        {
            inFile = new Scanner(myFile);
        }
        catch (FileNotFoundException f)
        {
            inFile = new Scanner(System.in);
            System.out.println("Tournament Info File has not been found");
        }
        
        while(inFile.hasNext())
        {    
        
        String tournamentInfo = inFile.nextLine();
        String[] tournyInfo = tournamentInfo.split(",");
               
        String tournyName = tournyInfo[0];
        String tournyDate = tournyInfo[1];
        String tournyLoc = tournyInfo[2];
        int maxTeams = Integer.parseInt(tournyInfo[3]);
        int maxHardware = Integer.parseInt(tournyInfo[4]);
        int maxSoftware = Integer.parseInt(tournyInfo[5]);
        int maxField = Integer.parseInt(tournyInfo[6]);
        int maxJudge = Integer.parseInt(tournyInfo[7]);
       
        setTourneyName(tournyName);
        setTourneyDate(tournyDate);
        setTourneyLocation(tournyLoc);
        setMaxTeams(maxTeams);
        setHardware(maxHardware);
        setSoftware(maxSoftware);
        setFieldTest(maxField);
        setJudgingStat(maxJudge);
        
        }        
    }
    
    /**
     *
     */
    public void modifyTeamInfo()
    {
        
        //JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR TEAM NUMBER THAT YOU \n WOULD LIKE TO MODIFY");
        //JOptionPane.showMessageDialog(null, teamName);
        String teamNumString = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR TEAM NUMBER THAT YOU \n WOULD LIKE TO MODIFY");
        int teamNumber = Integer.parseInt(teamNumString);
        
        if(testInputNumber(teamNumber))
        {
        String teamNameEdit = JOptionPane.showInputDialog(null,"PLEASE ENTER YOUR NEW TEAM NAME: ");
        String teamSponsorEdit = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR NEW FINANCIAL SPONSOR");
        String teamMaxEdit = JOptionPane.showInputDialog(null, "PLEASE ENTER THE MAX NUMBER OF TEAM MEMBERS");
        int teamMaxNum = Integer.parseInt(teamMaxEdit);
        newTeamsTest.get(teamNumber).setTeamName(teamNameEdit);
        newTeamsTest.get(teamNumber).setFinancialSponsor(teamSponsorEdit);
        newTeamsTest.get(teamNumber).setNumberOfTeamMembers(teamMaxNum);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The team number is out of range");
        }
    }
    
    /**
     *
     */
    public void modifyTeamMemberInfo()
    {
        /*
        String teamNumString = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR TEAM NUMBER THAT YOU \n WOULD LIKE TO MODIFY");
        int teamNumber = Integer.parseInt(teamNumString);
        String teamMemberName = JOptionPane.showInputDialog(null, "PLEASE ENTER THE TEAM MEMBERS LAST NAME(CASE SENSITIVE)");
        
        ArrayList test = newTeamsTest.get(teamNumber).getTeamMembers();
        
        
        
        for(int i = 0; i < newTeamsTest.get(teamNumber).getNumberOfTeamMembers(); i++)
        {
            System.out.println(test.get(i));
        }
        
        */
       
       RadioButtonFrame radioButtonFrame = new RadioButtonFrame(newTeamsTest, maxNumberOfTeams);
       radioButtonFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
       radioButtonFrame.setSize( 300, 100 ); // set frame size
       radioButtonFrame.setVisible( true ); // display frame       
        
        
    }
    
    /**
     *
     * @param memberInfoFromFile
     * @return
     */
    public File openFileAndReturnFile(File memberInfoFromFile)
    {
        boolean workingFile = false;
        
        
        try
        {
            inFile2 = new Scanner(memberInfoFromFile);
            workingFile = true;
        }
        catch ( FileNotFoundException f)
        {
            inFile2 = new Scanner(System.in);
            System.out.println("Team Member Information file not found");
        }   
        
        
        
        
        return memberInfoFromFile;
    }
    
    /**
     *
     */
    public void printRobotSaftey()
    {
        
        System.out.println();
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            if(newTeamsTest.get(i).getTeamRobot() != null)
            {
            System.out.println("Robot Name: " + newTeamsTest.get(i).getTeamRobot().getRobotName() + "\n" + "Number of Saftey Issues: " + newTeamsTest.get(i).getTeamRobot().getRobotSafteyIssues() +"\n" + "Type of Violation: " + newTeamsTest.get(i).getTeamRobot().getRobotViolation());
            //System.out.println("Type of Violation: " + newTeamsTest.get(i).getTeamRobot().getRobotViolation());
            }
            else
            {
                System.out.println("There is not robot to read info from. Please go to step 1.");
            }
        }
        
        JOptionPane.showMessageDialog(null,newTeamsTest.get(0).getTeamRobot().getRobotViolation());
    }
        
    /**
     *
     * @param teamNumber
     */
    public void setScopeSaftey(int teamNumber) {
        rndm = new Random(teamNumber);
        int temp = rndm.nextInt(4);
        temp += 1;
        
        if(temp == 1)
            this.scopeSaftey = ScopeOfSaftey.EVENT;
        else if (temp == 2)
            this.scopeSaftey = ScopeOfSaftey.OTHER;
        else if (temp == 3)
            this.scopeSaftey = ScopeOfSaftey.PERSONAL;
        else if (temp == 4)
            this.scopeSaftey = ScopeOfSaftey.ROBOT;
           
    }
    
    /**
     *
     */
    public void playMatches()
    {
        
       for(int i = 0; i < maxNumberOfTeams; i++)
       {
           newTeamsTest.get(i).setRankingPoints(randomNumber);
           newTeamsTest.get(i).setQualifyingPoints(randomNumber);
           randomNumber += 1;
       }
       
       ArrayList<Team> redAlly = new ArrayList();
       ArrayList<Team> blueAlly = new ArrayList();
       for(int i = 0; i < (maxNumberOfTeams/2); i++)
       {
           redAlly.add(newTeamsTest.get(i));
       }
       
       for(int i = (maxNumberOfTeams/2); i < maxNumberOfTeams; i++)
       {
           blueAlly.add(newTeamsTest.get(i));
       } 
       
      GameMatchClass testMatch = new GameMatchClass(1,1,redAlly,blueAlly);  
      
      System.out.println(testMatch);
      
    }
    
    /**
     *
     */
    public void addCoachesFromFile()
    {
        //File workingCoachFile = openFileAndReturnFile(teamCoachFile);
        
        File coachFile = new File("Tourney1coachesFinal.csv");
        Scanner inFile;
        try
        {
            inFile = new Scanner(coachFile);
            
        }
        catch( FileNotFoundException f)
        {
            inFile = new Scanner(System.in);
            System.out.println("Coach file not Found");
        }
        
        String coachInfo = inFile.nextLine();
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            coachInfo = inFile.nextLine();
            String[] coachInfoArray = coachInfo.split(",");
            
            coachArray.add(i,new CoachClass(coachInfoArray));
        }
        

        
    }
    
    /**
     *
     */
    public void writeAwardsToFile()
    {
       
        
        
        outputdata.writeRecord(this);
        outputdata.closeFile();
        

        
    }
    
    /**
     *
     * @throws InterruptedException
     */
    public  void displayRobotGUIO() throws InterruptedException  {

        JFrame inFrame = new JFrame();
        

        JTextArea iFArea = new JTextArea();
        
        String teamNum = JOptionPane.showInputDialog(null, "Please Enter the Team Number to print the Robot Information");
        
        int teamNumber = Integer.parseInt(teamNum);
        RobotGUI inPanel;
        
        if(testInputNumber(teamNumber))
        {
            if(newTeamsTest.get(teamNumber).getTeamRobot() != null)
            {
                inPanel = new RobotGUI(newTeamsTest.get(teamNumber).getTeamRobot());
                inFrame.add(inPanel);
                inFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                inFrame.setSize(600,300 );     
                inFrame.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Robot: " + teamNumber + " has not been signed in");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Team number is out of range");
        }
                   
        
    }
    
    /**
     *
     */
    public void displayComboGUIRobot()
    {
        
        boolean tester = false;
      
        
      ArrayList<Robot> newRobotArray = new ArrayList();
      
      for(int i = 0; i < maxNumberOfTeams; i++)
      {
          if(newTeamsTest.get(i).getTeamRobot() != null)
          {
              newRobotArray.add(newTeamsTest.get(i).getTeamRobot());
              tester = true;
          }
          else
          {
              System.out.println("Team Robot Number: " + i+ " has not been added to the array");
          }
      }
      
      
      if (tester == true)
      {
      ComboBox2Frame comboBox2Frame = new ComboBox2Frame(newRobotArray, newRobotArray.size()); 
      comboBox2Frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
      comboBox2Frame.setSize( 350, 150 ); 
      comboBox2Frame.setLocation(500, 50);
      comboBox2Frame.setVisible( true );      
      }
      else
      {
          System.out.println("There are no robots to perform any actions on");
      }
      
 
        
        
    }
    
    /**
     *
     */
    public void displayTypeOfIssue()
    {
        String teamNum;
        int teamNumber;
        //JOptionPane.showMessageDialog(null, "Please enter the Team Number to check on robot saftey issues");
        teamNum = JOptionPane.showInputDialog(null, "Please enter the Team Number to check on robot saftey issues");
        teamNumber = Integer.parseInt(teamNum);
        
        if(testInputNumber(teamNumber))
        {
            if(newTeamsTest.get(teamNumber).getTeamRobot() != null)
            {
                newTeamsTest.get(teamNumber).getTeamRobot().setRobotViolation(teamNumber);
           
                //String safteyIssue = newTeamsTest.get(teamNumber).getTeamRobot().getRobotViolation();
                JOptionPane.showMessageDialog(null, "Type of Saftey Violation:  " + newTeamsTest.get(teamNumber).getTeamRobot().getRobotViolation());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No Robot has been signed in for that Team. Please go back to step 1");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Your Team Number is out of Range");
        }
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean countSafteyIssues()
    {
        return true;
    }
    
    /**
     *
     * @return
     */
    @Override 
    public String displaySafteyIssues()
    {
        System.out.println();
        for(int i = 0; i < maxNumberOfTeams; i++)
        {
            if(newTeamsTest.get(i).getTeamRobot() != null)
            {
            System.out.println("Robot Name: " + newTeamsTest.get(i).getTeamRobot().getRobotName() + "\n" + "Number of Saftey Issues: " + newTeamsTest.get(i).getTeamRobot().getRobotSafteyIssues());
            System.out.println("Type of Violation: " + newTeamsTest.get(i).getTeamRobot().getRobotViolation());
            System.out.println();
            }
            else
            {
                System.out.println("There is no robot info for team number: " + i + " Please go to step 1.");
            }
        } 
        
        return "Test";
    }
    
    @Override
    public String toString()
    {
        return String.format("Tournament Name: " + tournamentName + "\n" +"Tournament Date: "+tournamentDate + "\n" + "Tournament Location: "+tournamentLocation+"\n" + "Tournament Status: " + tStatus + "\n" + "Number of Teams: " + maxNumberOfTeams);
                
    }
    
}
