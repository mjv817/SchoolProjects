/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * THE ROBOT CLASS HOLDS ALL INFORMATION FOR EACH TEAMS SPECIFIC ROBOT
 * @author Matt
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * THE ROBOT CLASS HOLDS ALL INFORMATION FOR EACH TEAMS SPECIFIC ROBOT
 * @author Matt
 */
public class Robot {
    private int teamNumber;
    private String robotName;
    RobotStatus currentRobotStatus;
    private ArrayList<Integer> inspectionStations = new ArrayList();
    private int heightInInches;
    private int widthInInches;
    private int depthInInches;
    private ArrayList<String> robotActions = new ArrayList();
    private Scanner input = new Scanner(System.in);
    private  Random rndm = new Random(25);
    private int randomNumberG;
    boolean hardwarePassed;
    boolean softwarePassed = true;
    boolean fieldTestPassed = true;
    private int robotSafteyIssues;
    ScopeOfSaftey scopeSaftey;
    TypeOfViolation robotViolation;
    
    /**
     *
     * @param currentRobotStatus
     * @param randomNumber
     */
    public Robot(RobotStatus currentRobotStatus, int randomNumber) {
        
        setTeamNumber(randomNumber); // Sets the team number
        setRobotName(); // Asks for the robot name
        setCurrentRobotStatus(currentRobotStatus); // Sets the original robot status
        setInspectionStations(inspectionStations); // Randomly generators the inspection stations
        setHeightInInches(heightInInches); // Asks for Robot Height
        setWidthInInches(widthInInches);  // Asks for Robot Width
        setDepthInInches(depthInInches);  // Asks for Robot Depth
        setHardwareStatus(currentRobotStatus, randomNumber); //Test to see if it can pass Hardware Inspection
        setSoftwareStatus(currentRobotStatus, randomNumber); //Test to see if it can pass Software Inspection
        setFieldTest(currentRobotStatus, randomNumber); //Test to see if it can pass Fiedl Test Inspection
        setRobotSafteyIssues(randomNumber);
        setRobotViolation(randomNumber);
        
    }
    
    /**
     *
     * @param teamNumber
     */
    public Robot(int teamNumber)
    {
        setTeamNumber(teamNumber); // Sets the team number
        setRobotName();// Asks for the robot name
        setInspectionStations(inspectionStations); // Randomly generators the inspection stations
        setHeightInInches(heightInInches); // Asks for Robot Height
        setWidthInInches(widthInInches);  // Asks for Robot Width
        setDepthInInches(depthInInches);  // Asks for Robot Depth
        setRobotSafteyIssues(teamNumber);
       // setRobotViolation(teamNumber);
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
     * @return
     */
    public String getRobotName() {
        return robotName;
    }

    /**
     *
     */
    public void setRobotName() {
        System.out.println();
        System.out.println("Please enter your robot name (String Value)");
        robotName = input.nextLine();
        this.robotName = robotName;
    }

    /**
     *
     * @param newName
     */
    
    public void setRobotName(String newName)
    {
       this.robotName = new String(newName);
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
        System.out.println("Robot: " + robotName + " status has been changed to " + currentRobotStatus);
        this.currentRobotStatus = currentRobotStatus;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getInspectionStations() {
        return inspectionStations;
    }

    /**
     *
     * @param inspectionStations
     */
    public void setInspectionStations(ArrayList<Integer> inspectionStations) {
     
     
        for(int i = 0;i < 3; i++)
        {
            int temp = rndm.nextInt(3);
            temp += 1;
            inspectionStations.add(temp);
        }
        
        
        this.inspectionStations = inspectionStations;
    }

    /**
     *
     * @return
     */
    public int getHeightInInches() {
        return heightInInches;
    }

    /**
     *
     * @param heightInInches
     */
    public void setHeightInInches(int heightInInches) {
        System.out.println();
        System.out.println("Please enter the height in inches: (Integer Value)");
        heightInInches = input.nextInt();
        this.heightInInches = heightInInches;
    }

    /**
     *
     * @return
     */
    public int getWidthInInches() {
        return widthInInches;
    }

    /**
     *
     * @param widthInInches
     */
    public void setWidthInInches(int widthInInches) {
        System.out.println();
        System.out.println("Please enter the weidth in inches: (Integer Value) ");
        widthInInches = input.nextInt();
        this.widthInInches = widthInInches;
    }

    /**
     *
     * @return
     */
    public int getDepthInInches() {
        return depthInInches;
    }

    /**
     *
     * @param depthInInches
     */
    public void setDepthInInches(int depthInInches) {
        System.out.println();
        System.out.println("Please enter the depth in inches: (Integer Value)");
        depthInInches = input.nextInt();
        this.depthInInches = depthInInches;
    }
    
    /**
     *
     * @param currentRobotStatus
     * @param randumNumber
     */
    public void setHardwareStatus(RobotStatus currentRobotStatus, int randumNumber)
    {
        rndm = new Random(randumNumber);
        int temp = rndm.nextInt(11);
        temp += 1;
        hardwarePassed = true;
        
        for(int i = 1; i <= 3; i++)
        {
            if(i == temp)
            {
                this.currentRobotStatus = currentRobotStatus;
                hardwarePassed = false;
            }
            
        }
        if(hardwarePassed == true)
            this.currentRobotStatus = RobotStatus.HW_INSP_PASSED;
        
        if(hardwarePassed == true)
        {
            System.out.println("The Robot has passed inspection");
        }
        else
        {
            System.out.println("The Robot has failed to pass the hardware inspection");
            System.out.println("THE RANDOM NUMBER IS------------  " + temp);
        }
            
            
            
    }
    
    /**
     *
     * @param hardwareStatus
     * @param randomNumber
     */
    public void setSoftwareStatus(RobotStatus hardwareStatus, int randomNumber)
    {
        rndm = new Random(randomNumber);
        int temp = rndm.nextInt(11);
        temp += 1;
        
        if(hardwareStatus == RobotStatus.READY)
            System.out.println("!!!!!!!!!!! The Robot Hardware Status has not passed the hardware Inspection - Go Back");
        else
        {
            softwarePassed = true;
            for(int i = 1; i <= 5; i++)
            {
            if(i == temp)
                {
                    this.currentRobotStatus = RobotStatus.HW_INSP_PASSED;
                    softwarePassed = false;
                }
            
            }
            
            if(softwarePassed == true)
            {
                this.currentRobotStatus = RobotStatus.SW_INSP_PASSED;
                System.out.println("CONGRATS YOUR ROBOT PASSED SOFTWARE INSPECTION");
            }
            else
                System.out.println("!!!!!!!!!!!! ROBOT FAILED SOFTWARE INSPECTION");
            
            
            
        }
            
    }
    
    /**
     *
     * @param softwareStatus
     * @param randomNumber
     */
    public void setFieldTest(RobotStatus softwareStatus, int randomNumber)
    {
        rndm = new Random(randomNumber);
        int temp = rndm.nextInt(11);
        temp += 1;
        
        if(softwareStatus == RobotStatus.HW_INSP_PASSED)
            System.out.println("!!!!!!!!!!! The Robot Hardware Status has not passed the hardware Inspection - Go Back");
        else
        {
            fieldTestPassed = true;
            for(int i = 1; i <= 4; i++)
            {
            if(i == temp)
                {
                    this.currentRobotStatus = RobotStatus.SW_INSP_PASSED;
                    fieldTestPassed = false;
                }
            
            }
            
            if(fieldTestPassed == true)
            {
                this.currentRobotStatus = RobotStatus.FIELD_TEST_PASED;
                System.out.println("Congrats your Robot Passed the Field Test Inspection");
                System.out.println();
            }
            else
            {
                System.out.println("!!!!!!!!!!!! ROBOT FAILED SOFTWARE INSPECTION");
            }
        }
        
        
    }
            
    /**
     *
     * @param robotActions
     */
    public void createActoinArray(ArrayList robotActions)
    {
        this.robotActions.add("Autonmous forward motion");
        this.robotActions.add("Autonomous object pickup");
        this.robotActions.add("tele-op obeject scoop/pick p");
        this.robotActions.add("tele-op object hold");
        this.robotActions.add("Tele-op object drop/relese");
        this.robotActions.add("tele-op robot scoring movement");
        this.robotActions.add("tele-op game unit scoring movement");
    }

    /**
     *
     * @return
     */
    public boolean isHardwarePassed() {
        return hardwarePassed;
    }

    /**
     *
     * @param hardwarePassed
     */
    public void setHardwarePassed(boolean hardwarePassed) {
        this.hardwarePassed = hardwarePassed;
    }

    /**
     *
     * @return
     */
    public boolean isSoftwarePassed() {
        return softwarePassed;
    }

    /**
     *
     * @param softwarePassed
     */
    public void setSoftwarePassed(boolean softwarePassed) {
        this.softwarePassed = softwarePassed;
    }

    /**
     *
     * @return
     */
    public boolean isFieldTestPassed() {
        return fieldTestPassed;
    }

    /**
     *
     * @param fieldTestPassed
     */
    public void setFieldTestPassed(boolean fieldTestPassed) {
        this.fieldTestPassed = fieldTestPassed;
    }

    /**
     *
     * @return
     */
    public int getRobotSafteyIssues() {
        return robotSafteyIssues;
    }

    /**
     *
     * @param randomNum
     */
    public void setRobotSafteyIssues(int randomNum) {
        rndm =  new Random(randomNum);
        int temp = rndm.nextInt(10);
        temp += 1;
        
        this.robotSafteyIssues = temp;
    }

    /**
     *
     * @return
     */
    public ScopeOfSaftey getScopeSaftey() {
        return scopeSaftey;
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
        else 
            this.scopeSaftey = ScopeOfSaftey.ROBOT;
            
            
            

            
        
    }

    /**
     *
     * @return
     */
    public TypeOfViolation getRobotViolation() {
        return robotViolation;
    }

    /**
     *
     * @param TeamNumber
     */
    public void setRobotViolation(int TeamNumber) {
        rndm = new Random(teamNumber);
        int temp = rndm.nextInt(3);
        temp += 1;       
        
        if(temp ==1 ){
            this.robotViolation = TypeOfViolation.ACCIDENT;
            //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        else if (temp == 2){
            this.robotViolation = TypeOfViolation.PREPARATION;
            //System.out.println("33333333333333333333333333333333333333333333333333333333333");
        }
        else
        {
            this.robotViolation = TypeOfViolation.PROTECTION;
            //System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        }
                    
        
    }
    
    
    
    
    
    @Override
    public String toString()
    {
        return String.format("Team Number: " + teamNumber + "\n" +"Robot Name: "+robotName+"\n" +"Robot Status: "+currentRobotStatus +"\n" +"Robot Heighth: "+heightInInches +"\n" +"Robot Width: " + widthInInches +"\n" + "Robot Depth: "+ depthInInches);
    }
}
