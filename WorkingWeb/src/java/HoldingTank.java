



public class HoldingTank {
    
    private int systemOn = 0;
    private int valveBStatus;
    public HoldingTank() {
        
    }
    // Holding tank sets the system status: On = 1, Off = 0.
    public HoldingTank(int valveBStatus) {
        this.valveBStatus = valveBStatus;
    }

    public int getSystemOn() {
        return systemOn;
    }

    public void setSystemOn(int systemOn) {
        this.systemOn = systemOn;
    }
    
    
    public void checkValveStatus(){
    
    }

    public int getValveBStatus() {
        return valveBStatus;
    }

    public void setValveBStatus(int valveBStatus) {
        this.valveBStatus = valveBStatus;
    }
    
    
    
}