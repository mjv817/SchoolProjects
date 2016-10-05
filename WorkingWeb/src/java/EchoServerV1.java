import java.io.IOException;
import java.util.Scanner;
 
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.util.stream.DoubleStream;
/** 
 * A portion of the EchoServer and index.html file were take from the following website
 * https://blog.idrsolutions.com/2013/12/websockets-an-introduction/
 * 
 * 
 * 
 */



@ServerEndpoint("/echo") 
public class EchoServerV1  {
    
        
        private int userNum;
        private double  currentFillLevel = 0.0;
        private double currentTemp = 0.0;
        private double amountAdded = 4.0;
        private double totalOutflow = 0.0;
        private String clientInput;
      
        private HoldingTank tankSim = new HoldingTank();
        private InputValve_A valveA; 
        private FillSensor_D fillSensor; 
        private HeatingElement_C heatingElement;
        private TempSensor_E tempSensor;
        private OutputValve_B valveB; 
        private Random rn = new Random();
        private int loopControl = 1;
        
        
        
    /**
     * Onopen creates a connection for the holding tank and calls on the simulation classes
     * 
     * 
     * 
     */
    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a connection"); 
        
        try {
            session.getBasicRemote().sendText("Holding Tank is now running");
            
            this.tankSim.setSystemOn(1);
            fillSensor = new FillSensor_D(1);
            session.getBasicRemote().sendText("Currently Waiting for system to fill and heat to approiate temp");
            valveA = new InputValve_A(0.0);
            tempSensor = new TempSensor_E();
            heatingElement = new HeatingElement_C(valveA.getFillLevel());
            
            session.getBasicRemote().sendText("System is currently ready to be used");
            heatingElement.setElementStatus(0);
            
            valveB = new OutputValve_B();
            valveB.setValveBStatus(1);
            
            this.processMessage(session);
            //this.statusLoop(session);
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        
        
    }
 
    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(String message, Session session){
        int flag1 = 0;
        this.clientInput = message;
        String testingInfo = message;
        
        flag1 = this.processString(clientInput);
        
        System.out.println("Message from " + session.getId() + ": " + message);
        try {
            //session.getBasicRemote().sendText(message);
            if("on".equals(testingInfo)) {
                session.getBasicRemote().sendText("Input Valve is On");
                this.valveA.setValveAStatus(1);
                //System.out.print("valve a on");
            }
            else if ("off".equals(testingInfo)) {
                session.getBasicRemote().sendText("Input Valve is Off");
                this.valveA.setValveAStatus(0);
            }
            else if (flag1 == -1) {
                //session.getBasicRemote().sendText(message);
                this.tempSensor.setDesiredTemp2(message);
                session.getBasicRemote().sendText("Desired temp has been set");
                flag1 = 10000;
            }
            else if ("burneroff".equals(testingInfo)) {
                this.heatingElement.setElementStatus(0);
            }
            else if ("error".equals(testingInfo)) {
                session.getBasicRemote().sendText("Proccessing error report");
                this.processMessage(session);
            }
            else {
                this.processOutflow(session, clientInput);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    
    
    /**
     * The user closes the connection.
     * 
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session){
        System.out.println("Session " +session.getId()+" has ended");
        this.tankSim.setSystemOn(0);
    }
    

    
    // Processmessage updates the client with holding tank information
    public void processMessage(Session session){
        
        int randomNum = rn.nextInt((87 - 83) + 1) + 83;
        this.tempSensor.setTempC(randomNum);
        
            try {
                session.getBasicRemote().sendText("Output Valve B Status is: " + valveB.getValveBStatus());
                session.getBasicRemote().sendText("Input Valve A Status is: " + valveA.getValveAStatus());
                session.getBasicRemote().sendText("Heating Element Status is: " + heatingElement.getElementStatus());
                session.getBasicRemote().sendText("Temp Sensor Status is: " + tempSensor.getSensorStatus());
                session.getBasicRemote().sendText("Tank Product Level: " + valveA.getFillLevel());
                
                this.currentTemp = tempSensor.getTempC();
                session.getBasicRemote().sendText("Current Temp: " + this.currentTemp);  
            } catch (IOException ex) {
                Logger.getLogger(EchoServerV1.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.errorChecking();
      
    }
    
    // processOutflow tracks the outflow of product from the user intake
    public void processOutflow(Session session, String clientInput){
        boolean parsable = true;
        double outflow = 0.0;
        double sOutflow = 0.0;
        int sizeSelection = 0;
        int testNum;
        try {
            testNum = Integer.parseInt(clientInput);
            sizeSelection = testNum;
        } catch (NumberFormatException ex) {
            
        }
        
        try {
            
            if (sizeSelection == 1) {
                Thread.currentThread().sleep(3000);
                outflow += 250.0;
            }
            else if (sizeSelection == 2) {
                Thread.currentThread().sleep(4000);
                outflow += 300.0;
            }
            else if (sizeSelection == 3) {
                Thread.currentThread().sleep(4500);
                outflow += 350.0;
            }
            else if (sizeSelection == 4) {
                Thread.currentThread().sleep(5000);
                outflow += 400.0;
            }
            else if (sizeSelection > 0.0 && sizeSelection <= 9800) {
                outflow += sizeSelection;
            }
            else  {
                  session.getBasicRemote().sendText("Error Incorrect choice selected for one of the valves!!!!!!!!!!!!!!!");
                 }
        } catch (IOException ex) {
                    ex.printStackTrace();
                    
                } catch (InterruptedException ex) {
                Logger.getLogger(EchoServerV1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        sOutflow += outflow / 1000;      
        this.totalOutflow += sOutflow;
        
        this.valveA.setFillLevel(this.valveA.getFillLevel() - sOutflow);
        this.processMessage(session);
        
        if (valveA.getFillLevel() < .08) {
            try {
                session.getBasicRemote().sendText("Not Enough Product in Tank Will beggin refilling!!!!!!!!!!!!!!!!!!!!!!!!!");
                valveB.setValveBStatus(0);
                tempSensor.setSensorStatus(0);
                heatingElement.setElementStatus(1);
                valveA.fillingTank(0.8);
                Thread.currentThread().sleep(5000);
                session.getBasicRemote().sendText("Tank has been refilled and heated to correct temp!!!!!!!!!!");
                valveB.setValveBStatus(1);
                tempSensor.setSensorStatus(1);
                heatingElement.setElementStatus(0);
            }
            catch ( IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                Logger.getLogger(EchoServerV1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          

        
    }
    

    // Tests for leaking tank or stuck heating burner    
    public void errorChecking() {
        
       if (valveA.getValveAStatus() == 0 && heatingElement.getElementStatus() == 1) {
           heatingElement.setElementStatus(0);
       } 
       
       if (valveA.getFillLevel() == 0 && valveA.getValveAStatus() == 1) {
           valveA.setValveAStatus(0);
       }
        
    }    
        
    
    public int processString(String clientInput) {
        int userTemp = 0;
        String testString = clientInput;
        String match = "p";
        String newString;
        int position = testString.indexOf(match);
        
        
        
        
        
        if (position >= 0)
            return -1;
        
        
        return 100000000;
    }
    
    
    public void statusLoop(Session session) {
        
        try {
            int index = 1;
            int slowDataTransfer = 0;
            while(index == 1) {
                if(slowDataTransfer == 1) {
                    session.getBasicRemote().sendText("testing");
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
}