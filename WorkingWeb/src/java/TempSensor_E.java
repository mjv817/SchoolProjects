
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;




public class TempSensor_E {

    // defualt temp is 21
    private double tempC = 21.0;
    private int sensorStatus = 0;
    private int desiredTemp = 0;
    private Random rn = new Random();
    private String desiredTemp2;
    
    public TempSensor_E() {
        this.tempC = 21;
        this.setSensorStatus(1);
    }
    
    public TempSensor_E(int desiredTemp, double fillLevel, double addedProduct) {
        this.desiredTemp = desiredTemp;
        this.calculateTempAfterInput(fillLevel, addedProduct);
        
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }
    
    // calculates temp after product is addeded
    private double calculateTempAfterInput(double fillLevel, double amountAdded) {
        
        double totalTemp;
        double waitTime;
        int randomNum = rn.nextInt((87 - 83) + 1) + 83;
        totalTemp = ((fillLevel * 85) + (amountAdded * 21)) / (fillLevel + amountAdded);
        
        //System.out.println(totalTemp);
        this.tempC = totalTemp;
        waitTime = this.desiredTemp - this.tempC;
        if (this.tempC < this.desiredTemp)
        {
            if (waitTime > 90.0) {
                try {
                    Thread.currentThread().sleep(2000);
                    this.tempC = randomNum;
                } catch (InterruptedException ex) {
                    Logger.getLogger(TempSensor_E.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (waitTime < 83.0 && waitTime > 70.0) {
                try {
                    Thread.currentThread().sleep(3000);
                    this.tempC = randomNum;
                } catch (InterruptedException ex) {
                    Logger.getLogger(TempSensor_E.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (waitTime < 21.0 && waitTime < 82.0) {
                try {
                    Thread.currentThread().sleep(5000);
                    this.tempC = randomNum;
                } catch (InterruptedException ex) {
                    Logger.getLogger(TempSensor_E.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                this.tempC = randomNum;
        }
        return totalTemp;
    }
    
    // returns ccurrent temp
    private double currentTemp(double fillLevel) {
        double totalTemp;
        totalTemp = 21.0;
        this.tempC = totalTemp;
        return totalTemp;
    }

    public int getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(int sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public int getDesiredTemp() {
        return desiredTemp;
    }

    public void setDesiredTemp(int desiredTemp) {
        this.desiredTemp = desiredTemp;
    }

    public String getDesiredTemp2() {
        return desiredTemp2;
    }

    public void setDesiredTemp2(String desiredTemp2) {
        this.desiredTemp2 = desiredTemp2;
    }
    
    
    
    
    
}