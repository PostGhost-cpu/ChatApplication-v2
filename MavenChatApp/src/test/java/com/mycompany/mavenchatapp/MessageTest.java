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
        
        String result = message.sentMessages("Send");
        assertEquals("Message successfully sent", result);
    }

    @Test
    public void testMessageExceeds250Characters() {
        String longMessage = "a".repeat(251);
        message.setMessages(longMessage);
        message.setRecipient("+27718693002");
        
        String result = message.sentMessages("Send");
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
    public void testMessageHashIsCorrect() {
        message.setMessages("Hi Mike, can you join us for dinner tonight?");
        message.setAmount(2);
        message.checkMessageID();
        
        String hash = message.createMessageHash();
        assertNotNull(hash);
        assertTrue(hash.contains(":"));
    }

    // Message ID test
    @Test
    public void testMessageIdIsCreated() {
        assertTrue(message.checkMessageID());
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
}
