/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 *
 * @author Matt
 */
import java.util.Scanner;

/**
 * This class creates Tournament Directors
 * @author Matt
 */
public class TournamentDirector extends TourneyStaff {
    private String diretorTitle;
    private int firstYearServed;
    private Scanner userInput = new Scanner(System.in);

    /**
     *
     * @param tournamentName
     */
    public TournamentDirector(String tournamentName) {
        super(tournamentName);
        setDiretorTitle();
        setFirstYearServed();
    }

    /**
     *
     * @return
     */
    public String getDiretorTitle() {
        return diretorTitle;
    }

    /**
     *
     */
    public void setDiretorTitle() {
        String userChoice;
        System.out.println();
        System.out.println("Enter your orginizational title (String Value) ");
        userChoice = userInput.nextLine();    
        this.diretorTitle = userChoice;
    }

    /**
     *
     * @return
     */
    public int getFirstYearServed() {
        return firstYearServed;
    }

    /**
     *
     */
    public void setFirstYearServed() {
        System.out.println();
        System.out.println("Enter the number of Years you have served");
        this.firstYearServed = userInput.nextInt();
    }
    
    
    
    @Override
    public String toString()
    {
        return String.format(super.toString() + "\n" + "Director Title: " + diretorTitle + "\n" + "First Year Served: " + firstYearServed);
    }
}
