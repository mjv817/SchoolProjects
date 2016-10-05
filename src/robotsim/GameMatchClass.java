/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * GAME MATCH CLASS HOLDS DATA FOR CREATING GAME MATCHES AND BLUE/RED TEAM INFORMATION
 * @author Matt
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * GAME MATCH CLASS HOLDS DATA FOR CREATING GAME MATCHES AND BLUE/RED TEAM INFORMATION
 * @author Matt
 */
public class GameMatchClass {
    private int matchNumber;
    private int gameFieldNumber;
    private ArrayList<Team> redAlliance;
    private ArrayList<Team> blueAlliance;
    private int redAllyScore = 0;
    private int blueAllyScore = 0;
    private Random rndm;

    /**
     *
     * @param matchNumber
     * @param gameFieldNumber
     * @param redAlliance
     * @param blueAlliance
     */
    public GameMatchClass(int matchNumber, int gameFieldNumber, ArrayList<Team> redAlliance, ArrayList<Team> blueAlliance) {
        this.matchNumber = matchNumber;
        this.gameFieldNumber = gameFieldNumber;
        this.redAlliance = redAlliance;
        this.blueAlliance = blueAlliance;
        tallyPoints();
    }

    /**
     *
     * @return
     */
    public int getMatchNumber() {
        return matchNumber;
    }

    /**
     *
     * @param matchNumber
     */
    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    /**
     *
     * @return
     */
    public int getGameFieldNumber() {
        return gameFieldNumber;
    }

    /**
     *
     * @param gameFieldNumber
     */
    public void setGameFieldNumber(int gameFieldNumber) {
        this.gameFieldNumber = gameFieldNumber;
    }

    /**
     *
     * @return
     */
    public ArrayList<Team> getRedAlliance() {
        return redAlliance;
    }

    /**
     *
     * @param redAlliance
     */
    public void setRedAlliance(ArrayList<Team> redAlliance) {
        this.redAlliance = redAlliance;
    }

    /**
     *
     * @return
     */
    public ArrayList<Team> getBlueAlliance() {
        return blueAlliance;
    }

    /**
     *
     * @param blueAlliance
     */
    public void setBlueAlliance(ArrayList<Team> blueAlliance) {
        this.blueAlliance = blueAlliance;
    }

    /**
     *
     * @return
     */
    public int getRedAllyScore() {
        return redAllyScore;
    }

    /**
     *
     * @param redAllyScore
     */
    public void setRedAllyScore(int redAllyScore) {
        this.redAllyScore = redAllyScore;
    }

    /**
     *
     * @return
     */
    public int getBlueAllyScore() {
        return blueAllyScore;
    }

    /**
     *
     * @param blueAllyScore
     */
    public void setBlueAllyScore(int blueAllyScore) {
        this.blueAllyScore = blueAllyScore;
    }
    
    /**
     *
     */
    public void tallyPoints()
    {
        int testRandom = matchNumber;
        rndm = new Random(testRandom);
        
        
        int redTemp = rndm.nextInt(540);
        redTemp += 1;
        
        testRandom += 5;
        
        rndm = new Random(testRandom);
        
        int blueTemp = rndm.nextInt(540);
        blueTemp += 1;
        
        this.redAllyScore = redTemp;
        this.blueAllyScore = blueTemp;
           
       
    }
    
    
    @Override
    
    public String toString()
    {
        return String.format("Match Number: " + matchNumber + "\n" + "Red Ally Score: " + redAllyScore + "\n" + "Blue Ally Score: " + blueAllyScore );
                
    }
  
}
