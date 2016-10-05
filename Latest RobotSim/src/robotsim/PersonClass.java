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
public class PersonClass {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Scanner input = new Scanner(System.in);

    public PersonClass() {
        System.out.println();
        System.out.println("ENTER YOUR FIRST/LAST NAME AND EMAIL ADDRESS");
        setFirstName(firstName); // Asks for Team Members first Name
        setLastName(lastName);  // Asks for Team Members last Name
        setEmailAddress(emailAddress); // Asks for Team Members email address
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println();
        System.out.println("Please Enter your First name: (String Value)");
        firstName = input.nextLine();
        this.firstName = firstName;
        input = new Scanner(System.in);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println();
        System.out.println("Please enter your Last name: (String Value)");
        lastName = input.nextLine();
        this.lastName = lastName;
        input = new Scanner(System.in);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println();
        System.out.println("Please enter your email address: (String Value)");
        emailAddress  = input.nextLine();
        this.emailAddress = emailAddress;
        input = new Scanner(System.in);
    }
    
    @Override
    public String toString()
    {
        return String.format("First Name: "+ firstName + "\n"+ "Last Name: " + lastName + "\n" + "Email Address: "+ emailAddress);
    }
    
}
