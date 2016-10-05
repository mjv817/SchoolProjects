
public class HeatingElement_C  {
    private int elementOn;
    private int elementOff;
    private int elementStatus = 0;
    private double fillN;
    //private TempSensor_E tempTest = new TempSensor_E(fillN);
    
    

    public HeatingElement_C(double fillLevel) {
        if (fillLevel > .05) {
            this.setElementStatus(1);
        }
    }

    public int getElementOn() {
        return elementOn;
        
    }

    public void setElementOn() {
        this.elementOn = 1;
        System.out.println("Heating Element is now on");
        System.out.println("Product is now up to propper tempeture");
       // this.tempTest.setTempC(86);
    }

    public int getElementOff() {
        return elementOff;
    }

    public void setElementOff() {
        this.elementOff = 0;
        System.out.println("Heating Element is now off");
    }
    // checks temp and changes heating element status
    public void checkTemp(double tempNumber) {
        if (tempNumber <=  83) {
            System.out.println("Turning burner on");
            this.setElementOn();
        }
        else if (tempNumber >= 87) {
            System.out.println("Turning burner off");
            this.setElementOff();
        }
        
        
    }



    public int getElementStatus() {
        return elementStatus;
    }

    public void setElementStatus(int elementStatus) {
        this.elementStatus = elementStatus;
    }
    
    
    
}
    
    
    
    
    
    
    
    
    
    
