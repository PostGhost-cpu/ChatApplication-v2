
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
                System.out.println("Option 3) Stored Messages");
                System.out.println("Option 4) Quit");
                
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
                // Ignores lower case and upper case differences
                if (choice.equalsIgnoreCase("Send")) {
                    System.out.println(message);
                    System.out.println("Total messages sent: " + message.returnTotalMessages());
                } else if (choice.equalsIgnoreCase("Store")) {
                    System.out.println(message);
                }
            } else if (option == 2) {
                System.out.println("Recently sent messages:");
                // Creates a temporary Message object and calls printMessages()
                System.out.println(new Message().printMessages()); // Display all messages stored in the sentMessagesList array
            } else if (option == 3) {

                Message message = new Message();

                System.out.println("1. Display Recipients");
                System.out.println("2. Display Longest Message");
                System.out.println("3. Search Message ID");
                System.out.println("4. Search Recipient");
                System.out.println("5. Delete Message");
                System.out.println("6. Full Report");
                System.out.println("7. Display Stored Messages");
                
                int storedOption = input.nextInt();
                input.nextLine();
                // The switch statement selects one of many code blocks to be executed
                switch (storedOption) {
                    case 1: 
                        // Displays all recipients of stored messages
                        System.out.println(message.displayStoredRecipients());
                    break;
                    case 2: 
                        // Finds and displays the longest stored message
                        System.out.println(message.longestStoredMessage());
                    break;
                    case 3: 
                        // Prompts the user for a Message Id
                        System.out.println("Enter Message ID:");
                        String id = input.nextLine();
                        
                        // Displays the recipient and message associated with the Id
                        System.out.println(message.searchMessageID(id));
                    break;
                    case 4: 
                        // Prompts the user for a recipient number
                        System.out.println("Enter Recipient:");
                        String recipient = input.nextLine();
                        
                        // Displays all messages stored for that recipient
                        System.out.println(message.searchRecipient(recipient));
                    break;
                    case 5:
                        // Prompts the user for a message hash
                        System.out.println("Enter Message Hash:");
                        String hash = input.nextLine();
                        
                        // Deletes the matching stored message
                        System.out.println(message.deleteMessage(hash));
                    break;
                    case 6:
                        // Displays a complete report of all stored messages
                        System.out.println(message.messageReport());
                    break;
                    case 7:
                        // Displays every stored message loaded from the Json file
                        System.out.println(message.storedMessages());
                    break;
                default:
                    System.out.println("Invalid option."); // Executes when the user enters an invalid option
                }
            } else if (option == 4) {
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

    Credit: Website - GitHub - Automated Testing with Maven and GitHub Actions
    Source: https://github.com/PROG5121Guru/Maven-UnitTesting

    Credit: YouTube - JUnit Tutorial - #1 - Introduction to JUnit | What is the JUnit? | JUnit Tutorial New Series 
    Source: https://www.youtube.com/watch?v=YXV51LVmfok&list=PLGRDMO4rOGcNhqxHpVjQP80tLRTxis__x

    Credit: YouTube - JUnit Tutorial - #4 - Writing Your First JUnit Test | Unit Test Calculator
    Source: https://www.youtube.com/watch?v=ZoOXPuxvsfo&list=PLGRDMO4rOGcNhqxHpVjQP80tLRTxis__x&index=4

    Credit: Website - Longest Word
    Source: https://www.geeksforgeeks.org/dsa/print-all-strings-of-maximum-length-from-an-array-of-strings/

    Credit: Website - W3school - Java Switch
    Source: https://www.w3schools.com/java/java_switch.asp

    Credit: Website - Oracle - Class StringBuilder
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html

    Credit: Website - Oracle - Interface List<E>
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html

    Credit: YouTube - Bro Code - Java File Handling
    Source: https://www.youtube.com/watch?v=H62Jfv1DJlU

    Credit: YouTube - Coding with John - Reading and Writing Files in Java
    Source: https://www.youtube.com/watch?v=kjzmaJPoaNc

    Credit: Website - Oracle - Class FileWriter
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/FileWriter.html

    Credit: Website - Oracle - Class BufferedReader
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/BufferedReader.html

    Credit: Website - Oracle - Class FileReader
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/FileReader.html

    Credit: Website - Oracle - Interface AutoCloseable (Try-With-Resources)
    Source: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
    
    Credit: Website - Oracle - Lambda Expressions
    Source: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

    Credit: YouTube - Amigoscode - Java Lambda Expressions
    Source: https://www.youtube.com/watch?v=ePJrt5-G8eM

    Credit: YouTube - Coding with John - Lambda Expressions in Java
    Source: https://www.youtube.com/watch?v=tj5sLSFjVj4

    Credit: Website - Oracle - Collection.removeIf()
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collection.html#removeIf(java.util.function.Predicate)

    Credit: Website - Oracle - System.lineSeparator()
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/System.html#lineSeparator()

    Credit: Website - Oracle - ThreadLocalRandom
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html

    Credit: Website - Baeldung - Gson List Serialization and Deserialization
    Source: https://www.baeldung.com/gson-list

    Credit: YouTube - Amigoscode - Gson Tutorial Java
    Source: https://www.youtube.com/watch?v=5sQvQdUxy4w

    Credit: YouTube - Java Guides - Gson JSON Serialization and Deserialization
    Source: https://www.youtube.com/watch?v=HSuLn7z7Dtw

    Credit: YouTube - ProgrammingKnowledge - Read JSON File using Gson in Java
    Source: https://www.youtube.com/watch?v=7sZx8j2j7vM

    Credit: Website - GeeksforGeeks - StringBuilder in Java
    Source: https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/

    Credit: YouTube - ProgrammingKnowledge - Java StringBuilder Tutorial
    Source: https://www.youtube.com/watch?v=7QzYwYvR8kg

    Credit: YouTube - Coding with John - Java StringBuilder
    Source: https://www.youtube.com/watch?v=9X7pHf3yY6g

    Credit: Website - GeeksforGeeks - ArrayList in Java
    Source: https://www.geeksforgeeks.org/arraylist-in-java/
    
    Credit: YouTube - Bro Code - ArrayLists in Java
    Source: https://www.youtube.com/watch?v=E3jH5PjAFZg

    Credit: YouTube - Bro Code - Java ArrayList Tutorial
    Source: https://www.youtube.com/watch?v=xk4_1vDrzzo

    Credit: YouTube - Alex Lee - Java ArrayList Tutorial
    Source: https://www.youtube.com/watch?v=rzA7UJ-hQn4

    Credit: YouTube - Coding with John - Java ArrayLists Explained
    Source: https://www.youtube.com/watch?v=NwJgqXj-bxE

    Credit: Website - GeeksforGeeks - File Handling in Java
    Source: https://www.geeksforgeeks.org/file-handling-in-java/

    Credit: Website - GeeksforGeeks - Lambda Expressions in Java
    Source: https://www.geeksforgeeks.org/lambda-expressions-java-8/

    Credit: Website - JUnit 5 User Guide
    Source: https://junit.org/junit5/docs/current/user-guide/

    Credit: Website - Baeldung - JUnit 5 Testing
    Source: https://www.baeldung.com/junit-5

    Credit: Website - GeeksforGeeks - Searching in ArrayList
    Source: https://www.geeksforgeeks.org/search-an-element-in-an-arraylist-java/

    Credit: Website - Oracle - Enhanced For Loop
    Source: https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html

    Credit: Website - Oracle - Object Class (toString Method)
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#toString()

    Credit: Website - Oracle - Override Annotation
    Source: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Override.html

    Credit: YouTube - Amigoscode - JUnit 5 Tutorial
    Source: https://www.youtube.com/watch?v=Geq60OVyBPg

    Credit: YouTube - Coding with John - JUnit Testing in Java
    Source: https://www.youtube.com/watch?v=vZm0lHciFsQ

    Credit: YouTube - Java Brains - JUnit Tutorial for Beginners
    Source: https://www.youtube.com/watch?v=0N4fJmVYvYI

    Credit: YouTube - Bro Code - Java For Each Loop
    Source: https://www.youtube.com/watch?v=cwWBy6JtKBY

    Credit: YouTube - Alex Lee - Override toString Method in Java
    Source: https://www.youtube.com/watch?v=9JvWhduhSU8

*/