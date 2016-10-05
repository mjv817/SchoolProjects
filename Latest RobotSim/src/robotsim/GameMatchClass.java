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
import java.util.ArrayList;
public class GameMatchClass {
    private int matchNumber;
    private int gameFieldNumber;
    private ArrayList<String> redAlliance;
    private ArrayList<String> blueAlliance;
    private int redAllyScore;
    private int blueAllyScore;

    public GameMatchClass(int matchNumber, int gameFieldNumber, ArrayList<String> redAlliance, ArrayList<String> blueAlliance) {
        this.matchNumber = matchNumber;
        this.gameFieldNumber = gameFieldNumber;
        this.redAlliance = redAlliance;
        this.blueAlliance = blueAlliance;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getGameFieldNumber() {
        return gameFieldNumber;
    }

    public void setGameFieldNumber(int gameFieldNumber) {
        this.gameFieldNumber = gameFieldNumber;
    }

    public ArrayList<String> getRedAlliance() {
        return redAlliance;
    }

    public void setRedAlliance(ArrayList<String> redAlliance) {
        this.redAlliance = redAlliance;
    }

    public ArrayList<String> getBlueAlliance() {
        return blueAlliance;
    }

    public void setBlueAlliance(ArrayList<String> blueAlliance) {
        this.blueAlliance = blueAlliance;
    }

    public int getRedAllyScore() {
        return redAllyScore;
    }

    public void setRedAllyScore(int redAllyScore) {
        this.redAllyScore = redAllyScore;
    }

    public int getBlueAllyScore() {
        return blueAllyScore;
    }

    public void setBlueAllyScore(int blueAllyScore) {
        this.blueAllyScore = blueAllyScore;
    }
    
    @Override
    
    public String toString()
    {
        return String.format("Match Number: " + matchNumber + "\n" + "Red Ally Score: " + redAllyScore + "\n" + "Blue Ally Score: " + blueAllyScore );
                
    }
  
}
