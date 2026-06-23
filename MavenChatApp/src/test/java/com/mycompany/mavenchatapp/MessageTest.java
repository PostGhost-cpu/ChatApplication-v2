package com.mycompany.mavenchatapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    
    private Message message;

    @BeforeEach
    public void setUp() {
        message = new Message();
    }

    // Message length tests (Task 1 data)
    @Test
    public void testMessageWithin250Characters() {
        message.setMessages("Hi Mike, can you join us for dinner tonight?");
        message.setRecipient("+27718693002");
        message.setAmount(2);
        
        String result = message.sentMessages("SEND");
        
        assertEquals("Message successfully sent", result);
    }

    @Test
    public void testMessageExceeds250Characters() {
        String longMessage = "a".repeat(251);
        message.setMessages(longMessage);
        message.setRecipient("+27718693002");
        
        String result = message.sentMessages("SEND");
        
        assertTrue(result.contains("less than 250 characters"));
    }

    // Recipient cell validation tests (Task 1 & 2 data)
    @Test
    public void testRecipientCorrectlyFormatted() {
        message.setRecipient("+27718693002");
        String result = message.checkRecipientCell();
        assertEquals("Cell phone number successfully added.", result);
    }

    @Test
    public void testRecipientIncorrectlyFormatted() {
        message.setRecipient("08575975889");
        String result = message.checkRecipientCell();
        assertTrue(result.contains("incorrectly formatted"));
    }

    // Message hash test
    @Test
    public void testMessageHashIsCreated() {
        message.setMessages("Hi Mike, can you join us for dinner tonight?");
        message.setAmount(2);
        message.checkMessageID();
        
        String hash = message.createMessageHash();
        
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    // Message ID test
    @Test
    public void testMessageIdIsCreated() {
        message.checkMessageID(); 
        assertNotNull(message.getMessageId()); 
        assertEquals(10, message.getMessageId().length());
    }

    // MessageSent tests with different options
    @Test
    public void testMessageSentWithSendOption() {
        message.setMessages("Hi Mike, can you join us for dinner tonight?");
        message.setRecipient("+27718693002");
        message.setAmount(2);
        
        String result = message.sentMessages("Send");
        assertEquals("Message successfully sent", result);
    }

    @Test
    public void testMessageSentWithDiscardOption() {
        message.setMessages("Hi Keegan, did you receive the payment?");
        message.setRecipient("+27718693002");
        
        String result = message.sentMessages("Disregard");
        assertTrue(result.contains("delete"));
    }

    @Test
    public void testMessageSentWithStoreOption() {
        message.setMessages("Hi Mike, can you join us for dinner tonight?");
        message.setRecipient("+27718693002");
        message.setAmount(2);
        
        String result = message.sentMessages("Store");
        assertEquals("Message successfully stored", result);
    }
    
    /** Portfolio of Evidence Test Data **/
    @Test 
    public void testSentMessage1() { 
	Message message = new Message( "Did you get the cake?", "+27834557896", 1); 
	assertEquals( "Message successfully sent", message.sentMessages("SEND")); 
    }

    @Test 
    public void testStoredMessage2() { 
	Message message = new Message( "Where are you? You are late! I have asked you to be on time.", "+27838884567", 2); 
	assertEquals( "Message successfully stored", message.sentMessages("STORE")); 
    }

    @Test 
    public void testDisregardedMessage3() { 
	Message message = new Message( "Yohoooo, I am at your gate.", "+27834484567", 3); 
	assertEquals( "Message disregarded", message.sentMessages("DISREGARD")); 
    }

    @Test 
    public void testSentMessage4() { 
	Message message = new Message( "It is dinner time !", "+27838884567", 4); 
	assertEquals( "Message successfully sent", message.sentMessages("SEND")); 
    }

    // Message Id Test
    @Test 
    public void testMessageIDLength() { 
	Message message = new Message( "It is dinner time !", "+27838884567", 4); 
	message.checkMessageID(); assertEquals( 10, message.getMessageId().length()); 
    }

    // Stored Message
    @Test 
    public void testSearchMessageID() { 
	Message message = new Message( "Where are you? You are late! I have asked you to be on time.", "+27838884567", 2); 
	message.sentMessages("STORE"); assertNotNull(message.getMessageId()); 
    }

    @Test 
    public void testMessageHashGenerated() { 
	Message message = new Message( "Did you get the cake?", "+27834557896", 1); 
	message.checkMessageID(); String hash = message.createMessageHash(); assertNotNull(hash); 	assertFalse(hash.isEmpty()); 
    }

    @Test 
    public void testStoredMessageReport() { 
	Message message = new Message( "Where are you? You are late! I have asked you to be on time.", "+27838884567", 2); 
	message.sentMessages("STORE"); 

	String report = message.messageReport(); 

	assertNotNull(report); 
    }
}
