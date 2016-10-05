/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Formatter;

/**
 *
 * @author Matt
 */
public class WriteToAwardFile {
    private Formatter output;
    
    /**
     *
     */
    public void openFile()
   {
      try
      {
         output = new Formatter( new File( "awardInfoTest.txt" ) );
         System.out.println("TESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
      } // end try
      catch ( FileNotFoundException f)
      {
         System.err.println( "Error opening file." );
         System.exit( 1 );
      } // end catch
   } // end method openFile    
    
    /**
     *
     * @param record
     * @return
     */
    public boolean writeRecord(Tournament record)
   {
       /*
       output.format("%-10d,%-12s,%-12s,%10.2f\n",
               record.getAccount(), record.getFirstName(),
               record.getLastName(), record.getBalance());
       */
       
       ArrayList<Team> teamRecords = record.getNewTeamsTest();
       
       for(int i = 0;i < record.getMaxNumberOfTeams();i++)
       {
           
           
       
            output.format("%-12s,%-10d,%-12d,%-12d,%10d\n",teamRecords.get(i).getTeamName(),
               teamRecords.get(i).getTeamNumber(), teamRecords.get(i).getQualifyingPoints(),
               teamRecords.get(i).getRankingPoints(), teamRecords.get(i).getJudgingPoints());
            
         /* 
             output.format(teamRecords.get(i).getTeamName() + ",     "+
               teamRecords.get(i).getTeamNumber()+ ",     "+ teamRecords.get(i).getQualifyingPoints()+ ",     "+
               teamRecords.get(i).getRankingPoints()+ ",     "+ teamRecords.get(i).getJudgingPoints()+"\n");
                 
                 */
        } 
       
       
       
       return true;
   }
   
   
   
   
   
      // close file and terminate application

    /**
     *
     */
       public void closeFile()
   {
      if ( output != null )
         output.close(); // close file
   } // end method closeFile    
}
