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
    boolean hardwarePassed = true;
    boolean softwarePassed = true;
    boolean fieldTestPassed = true;
    

    public Robot(RobotStatus currentRobotStatus, int randomNumber) {
        
        setTeamNumber(randomNumber); // Sets the team number
        setRobotName(); // Asks for the robot name
        setCurrentRobotStatus(currentRobotStatus); // Sets the original robot status
        setInspectionStations(inspectionStations); // Randomly generators the inspection stations
        setHeightInInches(heightInInches); // Asks for Robot Height
        setWidthInInches(widthInInches);  // Asks for Robot Width
        setDepthInInches(depthInInches);  // Asks for Robot Depth
        setHardwareStatus(currentRobotStatus, randomNumber); //Test to see if it can pass Hardware Inspection
        setSoftwareStatus(hardwarePassed, randomNumber); //Test to see if it can pass Software Inspection
        setFieldTest(hardwarePassed, randomNumber); //Test to see if it can pass Fiedl Test Inspection
        
        
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {

        this.teamNumber = teamNumber;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName() {
        System.out.println();
        System.out.println("Please enter your robot name (String Value)");
        robotName = input.nextLine();
        this.robotName = robotName;
    }

    public RobotStatus getCurrentRobotStatus() {
        return currentRobotStatus;
    }

    public void setCurrentRobotStatus(RobotStatus currentRobotStatus) {
        this.currentRobotStatus = currentRobotStatus;
    }

    public ArrayList<Integer> getInspectionStations() {
        return inspectionStations;
    }

    public void setInspectionStations(ArrayList<Integer> inspectionStations) {
     
     
        for(int i = 0;i < 3; i++)
        {
            int temp = rndm.nextInt(3);
            temp += 1;
            inspectionStations.add(temp);
        }
        
        
        this.inspectionStations = inspectionStations;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        System.out.println();
        System.out.println("Please enter the height in inches: (Integer Value)");
        heightInInches = input.nextInt();
        this.heightInInches = heightInInches;
    }

    public int getWidthInInches() {
        return widthInInches;
    }

    public void setWidthInInches(int widthInInches) {
        System.out.println();
        System.out.println("Please enter the weidth in inches: (Integer Value) ");
        widthInInches = input.nextInt();
        this.widthInInches = widthInInches;
    }

    public int getDepthInInches() {
        return depthInInches;
    }

    public void setDepthInInches(int depthInInches) {
        System.out.println();
        System.out.println("Please enter the depth in inches: (Integer Value)");
        depthInInches = input.nextInt();
        this.depthInInches = depthInInches;
    }
    
    public void setHardwareStatus(RobotStatus currentRobotStatus, int randumNumber)
    {
        rndm = new Random(randumNumber);
        int temp = rndm.nextInt(11);
        temp += 1;
        
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
            
    }
    
    
    public void setSoftwareStatus(boolean hardwareStatus, int randomNumber)
    {
        rndm = new Random(randomNumber);
        int temp = rndm.nextInt(11);
        temp += 1;
        
        if(hardwareStatus == false)
            this.softwarePassed = hardwareStatus;
        else
        {
            for(int i = 1; i <= 5; i++)
            {
            if(i == temp)
                {
                    this.currentRobotStatus = RobotStatus.HW_INSP_PASSED;
                    softwarePassed = false;
                }
            
            }
            
            if(softwarePassed == true)
                this.currentRobotStatus = RobotStatus.SW_INSP_PASSED;
        }
            
    }
    
    public void setFieldTest(boolean softwarePassed, int randomNumber)
    {
        rndm = new Random(randomNumber);
        int temp = rndm.nextInt(11);
        temp += 1;
        
        if(softwarePassed == false)
            this.fieldTestPassed = softwarePassed;
        else
        {
            for(int i = 1; i <= 4; i++)
            {
            if(i == temp)
                {
                    this.currentRobotStatus = RobotStatus.SW_INSP_PASSED;
                    fieldTestPassed = false;
                }
            
            }
            
            if(fieldTestPassed == true)
                this.currentRobotStatus = RobotStatus.FIELD_TEST_PASED;
        }
        
        
    }
            
            
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

    public boolean isHardwarePassed() {
        return hardwarePassed;
    }

    public void setHardwarePassed(boolean hardwarePassed) {
        this.hardwarePassed = hardwarePassed;
    }

    public boolean isSoftwarePassed() {
        return softwarePassed;
    }

    public void setSoftwarePassed(boolean softwarePassed) {
        this.softwarePassed = softwarePassed;
    }

    public boolean isFieldTestPassed() {
        return fieldTestPassed;
    }

    public void setFieldTestPassed(boolean fieldTestPassed) {
        this.fieldTestPassed = fieldTestPassed;
    }
    
    
    
    
    @Override
    public String toString()
    {
        return String.format("Team Number: " + teamNumber + "\n" +"Robot Name: "+robotName+"\n" +"Robot Status: "+currentRobotStatus +"\n" +"Robot Heighth: "+heightInInches +"\n" +"Robot Width: " + widthInInches +"\n" + "Robot Depth: "+ depthInInches);
    }
}
