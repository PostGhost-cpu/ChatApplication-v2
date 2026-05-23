
package com.mycompany.mavenchatapp;

import java.util.Scanner;

public class MavenChatApp {

    public static void main(String[] args) {
        // Registration and login feature
        String username;
        String password;
        String cellphone; 
        
        String firstName;
        String lastName;
        // User input
        Scanner input = new Scanner(System.in);
       
        System.out.println("Enter First Name: ");
        firstName = input.nextLine();
        System.out.println("Enter Last Name: ");
        lastName = input.nextLine();
        System.out.println("Create Username - Include an underscore and no more then 5 characters.");
        username = input.nextLine();
        System.out.println("Create Password - Include a capital letter, a number, a special character & at least 8 character.");
        password = input.nextLine();
        System.out.println("Create Cellphone number - Include country code (+27)");
        cellphone = input.nextLine();
        // Set - user values
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        login.setCellphone(cellphone);
        
        // Checks conditions
        boolean usernameState = login.checkUserName();
        boolean passwordState = login.checkPasswordComplexity();
        boolean cellphoneState = login.checkCellPhoneNumber();
        if (usernameState && passwordState && cellphoneState) {
            System.out.println(login.registerUser(firstName, lastName));
            // Sending messages feature
            System.out.println("To send messages to another user press Enter.");
            String enter = input.nextLine(); // Waits for user to press Enter
            
            if (!enter.isEmpty()) {
                System.out.println("You typed: " + enter);
                System.out.println("Cannot wait to see you again!");
                return;
            }
                System.out.println("Welcome to QuickChat.");
                
                System.out.println("Option 1) Send Messages");
                System.out.println("Option 2) Show recently sent messages");
                System.out.println("Option 3) Quit");
                
                int option = input.nextInt();
                input.nextLine(); // Used to read an entire line of text 
                
            if (option == 1) {
                // Send messages
                System.out.println("Enter a message:");
                String userMessages = input.nextLine();

                System.out.println("Enter the recipient's cell phone number:");
                String userRecipient = input.nextLine();

                System.out.println("Enter number of how many messages that will be sent:");
                int messageAmount = input.nextInt();
                input.nextLine();
                    
                // Set - user values
                Message message = new Message();
                message.setMessages(userMessages);
                message.setRecipient(userRecipient);
                message.setAmount(messageAmount);
                
                message.checkMessageID();

                // Ask user what to do with the message
                System.out.println("Choose an option:");
                System.out.println("Send");
                System.out.println("Store");
                System.out.println("Disregard");

                String choice = input.nextLine();
                String result = message.sentMessages(choice);
                System.out.println(result);

                if (choice.equalsIgnoreCase("Send") || choice.equalsIgnoreCase("Store")) {
                    System.out.println(message);
                    System.out.println("Total messages sent: " + message.returnTotalMessages());
                }

            } else if (option == 2) {
                System.out.println("Recently sent messages:");
                System.out.println(new Message().printMessages());

            } else if (option == 3) {
                System.exit(0);

            } else {
                System.out.println("Wrong input");
            }
        } else {
            System.out.println("Registration failed.");
        }
    }
}

/* 

    Credit: Website - w3school - Java Tutorial
    Source: https://www.w3schools.com/java/

    Credit: Website - w3school - JavaScript RegExp Patterns
    Source: https://www.w3schools.com/jsref/jsref_obj_regexp.asp

    Credit: YouTube - CodeLuky - Phone Number Validation with RegEx: A Beginner's Guide
    Source: https://www.youtube.com/watch?v=2ynftHoCyRU

    Credit: Website - GeeksforGeeks -Generating Random Numbers in Java
    Source: https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/

    Credit: YouTube - JSON in Java - Writing to files
    Source: https://www.youtube.com/watch?v=pJt-AYrmopo

    Credit: YouTube - Gson - How to convert Java object to / from JSON
    Source: https://www.youtube.com/watch?v=awvPmWrkfWs&t=1s

    Credit: Website - Google GSON Tutorial
    Source: https://www.javaguides.net/p/google-gson-tutorial.html

    Credit: YouTube - How to convert JSON to Java objects using Gson
    Source: https://www.youtube.com/watch?v=J94lLj_uG3c

    Credit: YouTube - Gson Tutorial — Getting Started with Java-JSON Serialization & Deserialization
    Source: https://www.youtube.com/watch?v=BbI8FdQOKNs&t=7s

    Credit: YouTube - #7 Gson Tutorial for Beginners - Converting JSON File to an Object
    Source: https://www.youtube.com/watch?v=_ga_W7MQEk0

    Credit: Youtube - Parsing JSON in Java
    Source: https://www.youtube.com/watch?v=0nN2stWIHM0

    Credit: Website - Tutorialspoint - GSON - Quick Guide
    Source: https://www.tutorialspoint.com/gson/gson_quick_guide.htm

    Credit: Website - gson - Gson User Guide
    Source: https://google.github.io/gson/UserGuide.html

    Credit: Website - Oracle - Class String
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html

    Credit: Website - Oracle - Class Pattern
    Source: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

    Credit: Website - Oracle - Class ArrayList<E>
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html

    Credit:
    Source:

*/