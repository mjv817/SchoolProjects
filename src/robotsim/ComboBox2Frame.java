/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.LayoutManager;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

/**
 * 
 * @author Matt GUI for creating combo boxes
 */
public class ComboBox2Frame extends JFrame{
    
   private JComboBox robotNamesJComboBox;
 
   private JLabel newRobotName;
   private JTextField robotNameText;
   private ArrayList<String> robotNames = new ArrayList();
   private  String[] robotNamesStringArray;
   private ArrayList<Robot> robotArrayTest;
   private JTextArea currentName = new JTextArea("         ");
   private JCheckBox rollFowardAction;
   private JCheckBox rollBackwardAction;
   private JCheckBox attackAction;
   private JCheckBox stopAction;
   
   private JLabel action1;
   private JLabel action2;
   private JLabel action3;
   private JLabel action4;
   
    /**
     *
     * @param robotArray
     * @param arraySize
     */
    public ComboBox2Frame(ArrayList<Robot> robotArray, int arraySize)
   {
      super( "Testing JComboBox2" );
      setLayout( new FlowLayout() );
      
      robotArrayTest = robotArray;
      
      for(int i = 0; i < arraySize; i++)
      { 
          robotNames.add(robotArray.get(i).getRobotName());
          //robotNamesStringArray[i] = robotArray.get(i).getRobotName();
      }
      
      

      //String[] robotNamesStringArray = {"R2D2", "T1000"};
      robotNamesStringArray = new String[robotNames.size()];
      for(int i = 0; i < arraySize; i++)
      {
          
          robotNamesStringArray[i] = robotArray.get(i).getRobotName();
      }   
      
      newRobotName = new JLabel("Please Select a Robot to choose specific Actions to take");
      robotNameText = new JTextField(20);   
      robotNamesJComboBox  = new JComboBox(robotNamesStringArray);
      //robotNamesJComboBox = new JComboBox(robotNames);
      robotNamesJComboBox.setMaximumRowCount(12);
      
      RobotNameHandler robotHandler = new RobotNameHandler();
      CheckBoxHandler checkHandler = new CheckBoxHandler();
      
      
      robotNamesJComboBox.addItemListener(robotHandler);
      
      add(robotNamesJComboBox);
      add(newRobotName);
      add(robotNameText);
      add(currentName);
      
      rollFowardAction = new JCheckBox("Move Forward");
      rollBackwardAction = new JCheckBox("Move Backwards");
      attackAction = new JCheckBox("Attack!");
      stopAction = new JCheckBox("Stop Attack");
      
      add(rollFowardAction);
      add(rollBackwardAction);
      add(attackAction);
      add(stopAction);  
      
      
      action1 = new JLabel("Rolling Foward");
      action2 = new JLabel("Rolling Backwards");
      action3 = new JLabel("Attacking");
      action4 = new JLabel("Stopping all Actions");
      
      rollFowardAction.addItemListener(checkHandler);
      rollBackwardAction.addItemListener(checkHandler);
      attackAction.addItemListener(checkHandler);
      stopAction.addItemListener(checkHandler);
      
      
      
      
   }

   private class RobotNameHandler implements ItemListener
   {
       
       public void itemStateChanged( ItemEvent event)
       {
           if ( event.getStateChange() == ItemEvent.SELECTED)
           {
               add(currentName);
               //robotArrayTest.get(robotNamesJComboBox.getSelectedIndex()).setRobotName(new String(robotNameText.getText()));
               String newRobotName = robotNameText.getText();
               currentName.setText(newRobotName);
               
           }
       
       
   }
       
    

    
    
}
   
private class CheckBoxHandler implements ItemListener 
   {
      
      public void itemStateChanged( ItemEvent event )
      {
     

         
         if ( rollFowardAction.isSelected() )
         {
            
            add(action1);
         }
         else if ( rollBackwardAction.isSelected() )
         {
         
            add(action2);
         }
         else if ( attackAction.isSelected() )
         {
            
            add(action3);
         }
         else
         {
          
            add(action4);
            
         }
         
        

         
      } 
   }   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   }
