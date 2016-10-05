/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;
   
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Matt Radio Button GUI For modifying team member information
 */
public class RadioButtonFrame extends JFrame {
   private JTextField textField; // used to display font changes
   private ButtonGroup radioGroup; // buttongroup to hold radio buttons
   private JRadioButton team1;
   private JRadioButton team2;
   private JRadioButton team3;
   private JRadioButton team4;
   private JRadioButton team5;
   private JRadioButton team6;
   private JRadioButton team7;
   private JRadioButton team8;
   private JRadioButton team9;
   private JRadioButton team10;
   private JRadioButton team11;
   private JRadioButton team12;
   
   
   
   private JComboBox teamMember;
   private String[] teamMemberNames;
   private ArrayList teamsArray = new ArrayList();
   private ArrayList<PersonClass> testClass = new ArrayList();
   
    /**
     *
     * @param test
     * @param maxTeams
     */
    public RadioButtonFrame(ArrayList<Team> test, int maxTeams)
   {
       
      super( "Team List" );
      setLayout( new FlowLayout() );
      int arraySize;
      
     
       //teamMemberNames[0] = test.get(0).getTeamMembers().get(0).getFirstName();
       teamMemberNames = new String[100];
       
       for(int k = 0; k < maxTeams; k++)
       {
           arraySize = test.get(k).getNumberOfTeamMembers();
           System.out.println("---"+ arraySize);
           System.out.println(test.get(0).getTeamMembers().get(0));
           int i = 0;
           
                while(i < arraySize)
                    {
                        
                        teamMemberNames[i] = test.get(k).getTeamMembers().get(i).getFirstName();
                        i++;
                        
                    }
                   
                   
       }
       
      team1 = new JRadioButton("Team 0", true);
      team2 = new JRadioButton("Team 1", false);
      team3 = new JRadioButton("Team 2", false);
      team4 = new JRadioButton("Team 3", false);
      team5 = new JRadioButton("Team 4", false);
      team6 = new JRadioButton("Team 5", false);
      team7 = new JRadioButton("Team 6", false);
      team8 = new JRadioButton("Team 7", false);
      team9 = new JRadioButton("Team 8", false);
      team10 = new JRadioButton("Team 9", false);
      team11 = new JRadioButton("Team 10", false);
      team12 = new JRadioButton("Team 11", false);
      
      add(team1);
      add(team2);
      add(team3);
      add(team4);
      add(team5);
      add(team6);
      add(team7);
      add(team8);
      add(team9);
      add(team10);
      add(team11);
      add(team12);

      
      radioGroup = new ButtonGroup();
      radioGroup.add(team1);
      radioGroup.add(team2);
      radioGroup.add(team3);
      radioGroup.add(team4);
      radioGroup.add(team5);
      radioGroup.add(team6);
      radioGroup.add(team7);
      radioGroup.add(team8);
      radioGroup.add(team9);
      radioGroup.add(team10);
      radioGroup.add(team11);
      radioGroup.add(team12);
      
      //textField.add(null, "test");
      

      
      
      teamMember = new JComboBox(teamMemberNames);
      teamMember.setMaximumRowCount(30);
      TeamNameHandler teamMemberNames = new TeamNameHandler();
      teamMember.addItemListener(teamMemberNames);
      add(teamMember);
      
      
      
      
      
   }
   
   
   // private inner class to handle radio button events
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // font associated with this listener
      private String teamName;
      public RadioButtonHandler( Font f )
      {
         font = f; // set the font of this listener
      } // end constructor RadioButtonHandler
      
      
           
      // handle radio button events
      public void itemStateChanged( ItemEvent event )
      {
         textField.setFont( font ); // set font of textField
         textField.add(null,teamName);
         JOptionPane.showMessageDialog(rootPane, teamName);
      } // end method itemStateChanged
   } // end private inner class RadioButtonHandler   
   
   
   
   private class TeamNameHandler implements ItemListener
   {
       public void itemStateChanged (ItemEvent event)
       {
           if (event.getStateChange() == ItemEvent.SELECTED)
           {
               String userInput;
               userInput = JOptionPane.showInputDialog(rootPane, "Edit the users's first name");
           }
       }
   }
}
