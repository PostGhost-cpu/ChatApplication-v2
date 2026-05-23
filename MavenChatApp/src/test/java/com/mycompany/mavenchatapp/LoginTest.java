package com.mycompany.mavenchatapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    // Username tests
    @Test
    public void testUsernameCorrectlyFormatted() {
        login.setUsername("kyl_1");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        login.setUsername("kyle!!!!!");
        assertFalse(login.checkUserName());
    }

    // Password tests
    @Test
    public void testPasswordMeetsComplexity() {
        login.setPassword("Ch&$sec@ke99!");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        login.setPassword("password");
        assertFalse(login.checkPasswordComplexity());
    }

    // Cell phone tests
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        login.setCellphone("+27838968976");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        login.setCellphone("08966553");
        assertFalse(login.checkCellPhoneNumber());
    }

    // Login tests
    @Test
    public void testLoginSuccessful() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&$sec@ke99!");
        assertTrue(login.loginUser("kyl_1", "Ch&$sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&$sec@ke99!");
        assertFalse(login.loginUser("kyl_1", "WrongPassword"));
    }
}
