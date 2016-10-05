/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsim;

/**
 * ADDRESSCLASS HOLDS DATA FOR THE TEAM MEMBERS ADDRESS
 * @author Matt
 */
import java.util.Scanner;

/**
 * ADDRESSCLASS HOLDS DATA FOR THE TEAM MEMBERS ADDRESS
 * @author Matt
 */
public class AddressClass {
    private String streetName;
    private String cityName;
    private String stateName;
    private int zipCode;
    private Scanner input = new Scanner(System.in);

    /**
     *
     */
    public AddressClass() {
        System.out.println();
        System.out.println("ENTER ADDRESS INFO BELOW!!!!");
        System.out.println();
        setStreetName(streetName); // Asks for street name from user
        setCityName(cityName);  //Asks for City name from user 
        setStateName(stateName); // Asks for State name from user
        setZipCode(zipCode);  // Asks for Zip code from user
    }

    /**
     *
     * @param addressInfo
     */
     
    public AddressClass(String[] addressInfo) {
        System.out.println();
        //System.out.println("ENTER ADDRESS INFO BELOW!!!!");
        //System.out.println();
        
        this.streetName = addressInfo[3];
        this.cityName = addressInfo[4];
        this.stateName = addressInfo[5];
        this.zipCode = Integer.parseInt(stringClean(addressInfo[6]));
    }
    
    /**
     *
     * @return
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     *
     * @param streetName
     */
    public void setStreetName(String streetName) {
        System.out.println();
        System.out.println("Please Enter your Street Address: (String/Integer value)");
        streetName = input.nextLine();
        this.streetName = streetName;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public String getCityName() {
        return cityName;
    }

    /**
     *
     * @param cityName
     */
    public void setCityName(String cityName) {
        System.out.println();
        System.out.println("Please Enter the name of City: (String Value)");
        cityName = input.nextLine();
        this.cityName = cityName;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public String getStateName() {
        return stateName;
    }

    /**
     *
     * @param stateName
     */
    public void setStateName(String stateName) {
        System.out.println();
        System.out.println("Please Enter the State: (String Value)");
        stateName = input.nextLine();
        this.stateName = stateName;
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(int zipCode) {
        System.out.println();
        System.out.println("Please enter the Zip Code: (Integer Value)");
        zipCode = input.nextInt();
        this.zipCode = zipCode;
        input = new Scanner(System.in);
        
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static String stringClean(String s){
        String blank = new String(" ");

        while (s.startsWith(blank))
        {
            s = s.substring(1);
        }
        return s;
    }
    
    @Override 
    
    public String toString()
    {
        return String.format("Street Name: " + streetName + "\n" + "City Name: " + cityName + "\n" + "State Name: " + stateName + "\n" + "Zip Code: " + zipCode);
    }
    
    
}
