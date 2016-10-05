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
import java.util.Arrays;
import java.util.Scanner;

public class Tournament {
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
    
    // Main Tournan Constructor that sets sets up the major components of the program
    public Tournament(TournamentStatus tStatus) {
        System.out.println("TOURNAMENT SETUP PROCESS");
        System.out.println("PLEASE ANSWER ALL QUESTIONS CAREFULLY");
        System.out.println();
        setTournamentName(); // Ask for Team Name
        setTournamentDate(); // Gets Date of Tournament
        setTournamentLocation(); // Gets Location of Tournament
        setMaxNumberOfTeams(); // Gets Max Number of Teams
        setNumberOfHardware(); // Gets the number of hardware stations
        setNumberOfSoftware(); // Gets the number of software stations
        setNumberOfFieldTesting(); // gets the number of fieldtesting stations
        setNumberOfJudgingLocations(); // gets the number of judging locations
        settStatus( tStatus);  // sets the original tournament status
        setNewTeams();
        
        do{
        input = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the corresponding number to perform a task(EX Enter (1) or (2)");
        System.out.println("(1) : Print Team Info from Tournament");
        System.out.println("(2) : Print Team Members from each Team");
        System.out.println("(3) : Print Team Game Status from each Team");
        System.out.println("(4) : Print Team List from Tournament");
        System.out.println("(5) To Exit the program enter a INTEGER of 5 to exit");
        userChoice = input.nextInt();
        
        switch(userChoice){
            case 1: printTeamInfo(newTeams);
                    userChoice = 0;
                    break;
            case 2: printTeamMembers(newTeams);
                    userChoice = 0;
                    break;
            case 3: printGameStatus(gameStatus);
                    userChoice = 0;
                    break;
            case 4: printTeamList(currentListofTeams);
                    userChoice = 0;
                    break;
            case 5: System.out.println("The Program will exit");
                    break;
            default: System.out.print("You enter an invalid choice. System will restart");
                    break;
        }
        }while(userChoice != 5);
            
        //setNewTeams();
        //printTeamInfo(newTeams);
        //printTeamMembers(newTeams);
        //printTeamList(currentListofTeams);
        //printGameStatus(gameStatus);
    

    }
    
    
    
    public Tournament(Tournament updatedTournament)
    {
        this.updatedTournament = updatedTournament;
        settStatus(TournamentStatus.MATCHES);
    }
    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName() {
        System.out.println();
        System.out.println("Please enter the name of the Tournament");
        tournamentName = input.nextLine();
        
        this.tournamentName = tournamentName;
    }

    public String getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate() {
        System.out.println();
        System.out.println("Please enter the date of the competition and use the following format (XX XX XXXX Integer Value)");
        tournamentDate = input.nextLine();
        //System.out.println(tournamentDate);
        this.tournamentDate = tournamentDate;
    }

    public String getTournamentLocation() {
        return tournamentLocation;
    }

    public void setTournamentLocation() {
        System.out.println();
        System.out.println("Please Enter the location of the Tournament (String/Char Value)");
        tournamentLocation = input.nextLine();
       // System.out.println(tournamentLocation);
    }

    public int getMaxNumberOfTeams() {
        return maxNumberOfTeams;
    }

    public void setMaxNumberOfTeams() {
        System.out.println();
        System.out.println("Please enter the  number of teams competiting(Integer Value)");
        maxNumberOfTeams = input.nextInt();
        //System.out.println(maxNumberOfTeams);
        this.maxNumberOfTeams = maxNumberOfTeams;
    }
    
    public void setNumberOfHardware()
    {
        System.out.println();
        System.out.println("Please enter the number of hardware stations available(Integer Value)");
        numberOfHardwareStations = input.nextInt();
    }
     public void setNumberOfSoftware()
    {
        System.out.println();
        System.out.println("Please enter the number of software stations available(Integer Value)");
        numberOfSoftwareStations = input.nextInt();
    }
    public void setNumberOfFieldTesting()
    {
        System.out.println();
        System.out.println("Please enter the number of Field Testing stations available(Integer Value)");
        numberOfFieldtestingStations = input.nextInt();
    }
    public void setNumberOfJudgingLocations()
    {
        System.out.println();
        System.out.println("Please enter the number of judging locations available(Integer Value)");
        numberOfJudgingLocations = input.nextInt();
    }

    public int getNumberOfHardwareStations() {
        return numberOfHardwareStations;
    }

    public int getNumberOfSoftwareStations() {
        return numberOfSoftwareStations;
    }

    public int getNumberOfFieldtestingStations() {
        return numberOfFieldtestingStations;
    }

    public int getNumberOfJudgingLocations() {
        return numberOfJudgingLocations;
    }


    public ArrayList<String> getCurrentListofTeams() {
        return currentListofTeams;
    }

    public void setCurrentListofTeams(ArrayList<String> currentListofTeams) {
        currentListofTeams = currentListofTeams;
    }
    
    public void addingToTeamNameList(ArrayList currentListofTeams)
    {
        
    }
    
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

    public TournamentStatus gettStatus() {
        return tStatus;
    }

    public void settStatus(TournamentStatus tStatus) {
        this.tStatus = tStatus;
    }

    public ArrayList<String> getGameFieldNames() {
        return gameFieldNames;
    }

    public void setGameFieldNames(ArrayList<String> gameFieldNames) {
        this.gameFieldNames = gameFieldNames;
    }

    public ArrayList<Integer> getTeamRankingsQP() {
        return teamRankingsQP;
    }

    public void setTeamRankingsQP(ArrayList<Integer> teamRankingsQP) {
        this.teamRankingsQP = teamRankingsQP;
    }

    public Team[] getNewTeams() {
        return newTeams;
    }

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
    
    public void printTeamMembers(Team[] newTeams)
    {
       System.out.println();
       this.newTeams = newTeams;
       int counter = 1;
       for(int i = 0; i < maxNumberOfTeams; i++)
       {
           System.out.println("Team Members from Team: "+counter+ Arrays.toString(newTeams[i].getTeamMembers()));
           System.out.println();
           System.out.println();
       }
    }
    
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
    
    public void printGameStatus(ArrayList teamGameStatus)
    {
        System.out.println();
        int counter = 1;
        for(int i = 0; i < maxNumberOfTeams;i++)
        {
          System.out.println("Team "+counter+" Game Status is: "+teamGameStatus.get(i));

        }
    }
    @Override
    public String toString()
    {
        return String.format("Tournament Name: " + tournamentName + "\n" +"Tournament Date: "+tournamentDate + "\n" + "Tournament Location: "+tournamentLocation+"\n");
                
    }
    
}
