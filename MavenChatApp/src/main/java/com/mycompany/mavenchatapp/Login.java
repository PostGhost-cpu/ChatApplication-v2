
package com.mycompany.mavenchatapp;

public class Login {
    private String username;
    private String password;
    private String cellphone;
    
    public Login() {
        username = null;
        password = null;
        cellphone = null;
    }
    // Set
    public void setUsername(String userName) {
        username = userName;
    }
    public void setPassword(String passWord) {
        password = passWord;
    }
    public void setCellphone(String cellPhone) {
        cellphone  = cellPhone;
    }
    // Get
    public String getUsername() {
      return username;
    }
    public String getPassword() {
      return password;  
    }
    public String getCellphone() {
      return cellphone;
    }
    // Conditions
    public boolean checkUserName() {
        if (username != null && username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured.");
            return true;
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            return false;
        }
    }
    public boolean checkPasswordComplexity() {
        if (password == null) {
            return false;
        }
        
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        if (password.length() >= 8 && hasCapital == true && hasNumber == true && hasSpecial == true) {
            System.out.println("Password successfully captured.");
            return true;
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
            return false;
        }
    }
    public boolean checkCellPhoneNumber() {
        if (cellphone == null) {
            return false;
        }
        
        boolean cellphoneFormat = cellphone.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$"); // International format
        if (cellphoneFormat == true) {
            System.out.println("Cell phone number successfully added.");
            return true;
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            return false;
        }
    }
    public String registerUser(String firstName, String lastName) {
        boolean userInput = checkUserName();
        // Password does not meet the complexity
        boolean passInput = checkPasswordComplexity();
        // User has been registered successfully
        if (userInput == true && passInput == true) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    public boolean loginUser(String userInput1, String passInput1) {
        String userInput2 = getUsername();
        String passInput2 = getPassword();
        if (userInput1.equals(userInput2) && passInput1.equals(passInput2)) {
            return true;
        } else {
            return false;
        }
    }
    public String returnLoginStatus(String userInput1, String passInput1) {
        if (loginUser(userInput1, passInput1)) {
            return "A successful login";
        } else {
            return "A failed login";
        }
    }
}