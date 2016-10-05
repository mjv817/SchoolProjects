/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * RobotSim is the Driver class that runs the tournament simulation
 * 
 * @author Matt
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Locale;

/**
 * RobotSim is the Driver class that runs the tournament simulation
 * @author Matt
 */
public class RobotSim {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
     ArrayList<Team> newTeams = new ArrayList();
     Scanner input = new Scanner(System.in);
     int x = 3;
     int userChoice;
     Formatter output = null;
     
    
     Tournament newTest = new Tournament(); // CREATES A NEW TOURNAMNET SIMULATION, ONLY RUN ONCE

        
        
       
        
/*
        File coachFile = new File("Tourney1coachesFinal.csv");
        Scanner inFile;
        try
        {
            inFile = new Scanner(coachFile);
            
        }
        catch( FileNotFoundException f)
        {
            inFile = new Scanner(System.in);
            System.out.println("Coach file not Found");
        }
        
        inFile.nextLine();
        String coachInfo = inFile.nextLine();
        String[] coachInfoArray = coachInfo.split(",");
        
        for(int i = 0; i < coachInfoArray.length;i++)
        {
            System.out.println(stringClean(coachInfoArray[i]) + "    " + i);
        }
    */
     
     /*
        File myFile = new File("testFile");
        Scanner inFile;
        try    
        {
            inFile = new Scanner(myFile);
            System.out.println("000000000000000000000000000000000000000000000000000000000000000");
        }
        catch (FileNotFoundException f)
        {
            inFile = new Scanner(System.in);
            System.out.println("Tournament Info File has not been found");
        }
        
        
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        
        
        String tournamentInfo = inFile.nextLine();
        String[] tournyInfo = tournamentInfo.split(",");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < tournyInfo.length; i++)
        {
             System.out.println("at index "+ i +" string is "+tournyInfo[i]);
        }   
        
     

     
    }
    */
     
     
}
    
    /**
     *
     * @param s
     * @return
     */
    public static String stringClean(String s)
    {
        String blank = new String(" ");

        while (s.startsWith(blank))
        {
            s = s.substring(1);
        }
        return s;
    }    

    }


