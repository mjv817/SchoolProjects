


public class InputValve_A {
    
    private int valveAStatus = 0;
    private double fillLevel = 0.0;
    
    // creates instance of Valve A class
    public InputValve_A(double fillLevel) {
        
        this.fillLevel = fillLevel;
        this.fillingTank(fillLevel);
    }

    public int getValveAStatus() {
        return valveAStatus;
    }

    public void setValveAStatus(int valveAStatus) {
        this.valveAStatus = valveAStatus;
    }

    public double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(double fillLevel) {
        this.fillLevel = fillLevel;
    }
    
    
    
    // fillingTank fills the tank and makre sure it does not overflow
    public double fillingTank(double fillLevel) {
        try {
            double tempNumber;
             Thread.currentThread().sleep(5000);

            tempNumber = 9.8 - fillLevel;
            if ( fillLevel > 9.8) {

                this.valveAStatus = 0;
            }
            else if (fillLevel < 5.0){
                this.fillLevel = fillLevel + tempNumber;
                this.valveAStatus = 0;

            }

            return this.fillLevel;
        }
        catch (InterruptedException ex) {
        }
        return 0;
    }
    
    
    public double checkTemp() {
        
        
        return 1.0;
    }
    
    
    
    
    
    
}