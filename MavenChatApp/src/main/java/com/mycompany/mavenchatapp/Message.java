
package com.mycompany.mavenchatapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Message {
    private String messages;
    private String recipientCell;
    private String messageId;
    private String messageHash;
    private int amountOfmessages;
    // Array
    private static final List<Message> sentMessagesList = new ArrayList<>();
    private static final List<Message> storedMessagesList = new ArrayList<>();
    private static int totalMessages = 0;
        
    public Message() {
        messages = null;
        recipientCell = null;
        messageId = null;
        messageHash = null;
        amountOfmessages = 0;
        
    }
    public Message (String messageText, String recipientCell, int messageNumber) {
        this();
        this.messages = messageText;
        this.recipientCell = recipientCell;
        this.amountOfmessages = messageNumber;  
    }
    
    // Set
    public void setMessages(String userMessages) {
        messages = userMessages;
    }
    public void setRecipient(String recipientcell) {
        recipientCell = recipientcell;
    }
    public void setAmount(int amount) {
        amountOfmessages = amount;
    }
    // Get
    public String getMessages() {
      return messages;
    }
    public String getRecipient() {
        return recipientCell;
    }
    public int getAmount() {
        return amountOfmessages;
    }
    public String getMessageId() {
        return messageId;
    }
    public String getMessageHash() {
        return messageHash;
    }
    // Conditions
    public boolean checkMessageID() { 
        if (messageId == null || messageId.isEmpty()) {
            // Generate a random long value
            messageId = String.valueOf(ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L));
        }
        return messageId.length() == 10;
    }
    public String checkRecipientCell() {
        // Cell number has no more than ten characters and an international code
        if (recipientCell == null || recipientCell.trim().isEmpty()) {
            return "Cell phone number incorrectly formatted or contains more than ten characters.";
        }
        // Replace every substring 
        String cellNumber = recipientCell.replaceAll("\\s+", "");
        // Regular expression
        if (cellNumber.matches("^\\+\\d{9,13}$")) {
            return "Cell phone number successfully added.";
        }
        return "Cell phone number incorrectly formatted or contains more than ten characters.";
    }
    public String createMessageHash() {
        if (messageId == null || messageId.length() != 10) {
            checkMessageID();
        }
        // Contains frist two numbers of message Id, a colon , number of message & first and last word
        String hashChar = String.valueOf(messageId);
        // first and last words of the message
        char oneChar = hashChar.charAt(0);
        char twoChar = hashChar.charAt(1);
        
        // Split the string by whitespace
        String[] words = messages.trim().split("\\s+");
        String hashWord;
        if (words.length > 1) {
            String firstWord = words[0];
            String lastWord = words[words.length - 1];
            
            hashWord = "Start: " + firstWord + ", End: " + lastWord;
        } else { 
            hashWord = "Only: " + words[0];
        }
        String messageHash = (oneChar + twoChar + ":" + amountOfmessages + hashWord).toUpperCase();
        return messageHash;
    }
    public String sentMessages(String option) {
        if (messages == null || messages.trim().isEmpty() || messages.length() > 250) {
            return "Please enter a message of less than 250 characters.";
        }
        String recipientCheck = checkRecipientCell();
        if (!"Cell phone number successfully added.".equals(recipientCheck)) {
            return recipientCheck;
        }
        if (!checkMessageID()) {
            return "Message ID is invalid.";
        }
        createMessageHash();

        if (option == null) {
            return "Invalid option.";
        }
        // Converts the option to uppercase so input is easier to compare
        String choice = option.trim().toUpperCase();

        if ("SEND".equals(choice)) { // Sends and adds it to the sent list
            sentMessagesList.add(this);
            totalMessages++;
            return "Message successfully sent";
        }
        if ("STORE".equals(choice)) { // Stores for later and writes it to JSON
            storedMessagesList.add(this);
            return storeMessages();
        }
        if ("DISREGARD".equals(choice) || "O".equals(choice)) { // Disregards the message 
            return "Press O to delete the message";
        }
        // Handles invalid options
        return "Invalid option.";
    }
    public String printMessages() { // Returns a message if nothing has been sent yet
        if (sentMessagesList.isEmpty()) {
            return "No messages sent.";
        }

        StringBuilder builder = new StringBuilder();
        for (Message message : sentMessagesList) {
            builder.append(message).append(System.lineSeparator()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
    public int returnTotalMessages() {
        // Returns the total number of messages that have been sent
        return totalMessages;
    }
    public String storeMessages() {
        // Creates a Gson object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Opens the Json file and writes the stored message list
        try (FileWriter writer = new FileWriter("StoreMessage.json")) {
            gson.toJson(storedMessagesList, writer);
            return "Message successfully stored";
        } catch (IOException e) { // Returns an error message if the file cannot be written
            return "Could not store message: " + e.getMessage();
        }
    }
    public static List<Message> loadStoredMessages() {
        // Creates a Gson object for reading JSON back into Java objects
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Message>>() { }.getType();
        // Opens the JSON file
        try (BufferedReader reader = new BufferedReader(new FileReader("StoreMessage.json"))) {
            List<Message> messages = gson.fromJson(reader, listType);
            return messages == null ? new ArrayList<>() : messages; // Returns an empty list if the file is empty
        } catch (IOException e) { // Returns an empty list if the file cannot be read
            return new ArrayList<>();
        }
    }
    @Override // Redefine a method already existing
    public String toString() { // Formats the message details for display on screen
        return "Message ID: " + messageId + System.lineSeparator() + "Message Hash: " + messageHash + System.lineSeparator() + "Recipient: " + recipientCell + System.lineSeparator() + "Message: " + messages;
    }
}
// String json = "id: " + messageId + '\'' + " hash: " + messageHash + " recipient: " + recipientcell + " message: " + messages + '\'';
