import java.util.*;

public class FillSensor_D  {
    private double fillLevel = 0.0;
    private double fillRate = .5;
    private final double maxLevel = 98 / 100.0;
    private final double tankSize = 10.0;
    private int fillSensorStatus = 0;


    
    public FillSensor_D(int sysStatus) {
        this.setFillSensorStatus(sysStatus);
    }
    
    public double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(double fillLevel) {
        double testLevel;
        this.fillLevel = fillLevel;
        
        
    }

    // test product level for overflow
    public boolean testMaxLevel (double fillLevel) {
        
        double tempNum = (fillLevel / 10 );
        System.out.println(tempNum);
        if (tempNum <= maxLevel) {
            System.out.println("Current tank level is fine");
            return true;
        }
        else {
            System.out.println("Reached max input level. Turn off Valve A");
            return false;
        }
            
    }
    // checks tank level
    public void checkTankLevel(int timeInSeconds) {
        double tempNumber;
        tempNumber = timeInSeconds * this.fillRate;
        System.out.println("There current level is: " + tempNumber);
        this.setFillLevel(tempNumber);
    }

    public int getFillSensorStatus() {
        return fillSensorStatus;
    }

    public void setFillSensorStatus(int fillSensorStatus) {
        this.fillSensorStatus = fillSensorStatus;
    }
    
    
    
}