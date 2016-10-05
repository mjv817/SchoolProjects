/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;
import java.awt.LayoutManager;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Robot GUI class that prints robot information
 * @author Matt
 */
public class RobotGUI extends JPanel {
  
    private JLabel robotName;
    private JLabel robotHeight;
    private JLabel robotWidth;
    private JLabel robotDepth;
    
    /**
     *
     * @param teamRobotInfo
     */
    public RobotGUI(Robot teamRobotInfo)
    {
        
        robotName = new JLabel("Robot Name: " + teamRobotInfo.getRobotName());
        robotHeight = new JLabel("Robot Height: " + teamRobotInfo.getHeightInInches());
        robotWidth = new JLabel("Robot Width: " + teamRobotInfo.getWidthInInches());
        robotDepth = new JLabel("Robot Depth: " + teamRobotInfo.getDepthInInches());
        
        
        
        
        this.add(robotName);
        
        this.add(robotHeight);
        this.add(robotWidth);
        this.add(robotDepth);
        
        
        
        
        
    }

    public JLabel getRobotName() {
        return robotName;
    }

    public void setRobotName(JLabel robotName) {
        this.robotName = robotName;
    }

    public JLabel getRobotHeight() {
        return robotHeight;
    }

    public void setRobotHeight(JLabel robotHeight) {
        this.robotHeight = robotHeight;
    }

    public JLabel getRobotWidth() {
        return robotWidth;
    }

    public void setRobotWidth(JLabel robotWidth) {
        this.robotWidth = robotWidth;
    }

    public JLabel getRobotDepth() {
        return robotDepth;
    }

    public void setRobotDepth(JLabel robotDepth) {
        this.robotDepth = robotDepth;
    }
}
