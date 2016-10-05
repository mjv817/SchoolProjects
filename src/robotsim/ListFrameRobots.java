/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import javax.swing.JLabel;
/**
 *
 * @author Matt
 */
public class ListFrameRobots extends JFrame {
    

private JList teamNamesJList; // list to display team names
private JLabel label;



   
   private  String[] teamNames;

   // ListFrame constructor add JScrollPane containing JList to JFrame

    /**
     *
     * @param teamRobotInfo
     */
       public ListFrameRobots(ArrayList<Team> teamRobotInfo)
   {
      super( "List Test" );
      setLayout( new FlowLayout() ); // set frame layout
      
      for(int i = 0; i < 12; i ++)
      {
         teamNames[i] = teamRobotInfo.get(i).getTeamName();
      }

     
      
      teamNamesJList = new JList(teamNames);
      teamNamesJList.setVisibleRowCount(12);
      
   
    
      teamNamesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

 /*
      add( new JScrollPane(teamNamesJList));

      colorJList.addListSelectionListener(
         new ListSelectionListener() // anonymous inner class
         {   
            // handle list selection events
            public void valueChanged( ListSelectionEvent event )
            {
               getContentPane().setBackground( 
                  colors[ colorJList.getSelectedIndex() ] );
               label.setName("Dogs");
            } // end method valueChanged
         } // end anonymous inner class
    
  ); // end call to addListSelectionListener
      
      
    /*  
      teamNamesJList.addListSelectionListener(
         new ListSelectionListener() // anonymous inner class
         {   
            // handle list selection events
            public void valueChanged( ListSelectionEvent event )
            {
               getContentPane().setBackground( 
                  colors[ colorJList.getSelectedIndex() ] );
            } // end method valueChanged
         } // end anonymous inner class
    
  );
            
            */
   } // end ListFrame constructor    
}
