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
public class AddressClass {
    private String streetName;
    private String cityName;
    private String stateName;
    private int zipCode;
    private Scanner input = new Scanner(System.in);

    public AddressClass() {
        System.out.println();
        System.out.println("ENTER ADDRESS INFO BELOW!!!!");
        System.out.println();
        setStreetName(streetName); // Asks for street name from user
        setCityName(cityName);  //Asks for City name from user 
        setStateName(stateName); // Asks for State name from user
        setZipCode(zipCode);  // Asks for Zip code from user
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        System.out.println();
        System.out.println("Please Enter your Street Address: (String/Integer value)");
        streetName = input.nextLine();
        this.streetName = streetName;
        input = new Scanner(System.in);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        System.out.println();
        System.out.println("Please Enter the name of City: (String Value)");
        cityName = input.nextLine();
        this.cityName = cityName;
        input = new Scanner(System.in);
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        System.out.println();
        System.out.println("Please Enter the State: (String Value)");
        stateName = input.nextLine();
        this.stateName = stateName;
        input = new Scanner(System.in);
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        System.out.println();
        System.out.println("Please enter the Zip Code: (Integer Value)");
        zipCode = input.nextInt();
        this.zipCode = zipCode;
        input = new Scanner(System.in);
        
    }
    
    
    @Override 
    
    public String toString()
    {
        return String.format("Street Name: " + streetName + "\n" + "City Name: " + cityName + "\n" + "State Name: " + stateName + "\n" + "Zip Code: " + zipCode);
    }
    
    
}
