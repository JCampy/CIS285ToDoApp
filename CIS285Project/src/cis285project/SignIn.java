/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cis285project;

/**
 *
 * @author Daniel
 * 
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class SignIn {
    
    //-----------------------------------------------------
    // These fields store the active user's ID and Role
    private String userID;
    private String userRole; 
    //-----------------------------------------------------
    
    
    /*
     * Method that when called displays a popup window with text and password fields for the user to sign in
     */
    public void display() {
        Stage popupWindow = new Stage();
        
        popupWindow.initModality(Modality.APPLICATION_MODAL); // Makes it so that when the popup window is visible, the user cannot interact with the main application
        popupWindow.setTitle("Sign In");
        
        Label userIDLbl = new Label("User ID:");
        Label passwordLbl = new Label("Password:");
        TextField userIDTxt = new TextField();
        PasswordField passwordFld = new PasswordField(); // Special text field that "stars out" the entered text
        Button submitBtn = new Button("Submit");
        Button closeBtn = new Button("Close");
        submitBtn.setDefaultButton(true);
        
        submitBtn.setOnAction(e-> userSignIn(userIDTxt.getText(), passwordFld.getText()));
        closeBtn.setOnAction(e-> popupWindow.close()); // Cancel button action that closes the window and discards any entered data
        
        //Containers for the controls
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        VBox vbox = new VBox(8);
        
        hbox1.getChildren().addAll(userIDLbl, userIDTxt);
        hbox2.getChildren().addAll(passwordLbl, passwordFld);
        hbox3.getChildren().addAll(submitBtn, closeBtn);
        vbox.getChildren().addAll(hbox1, hbox2, hbox3);
        
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        
        Scene popupScene = new Scene(vbox, 275, 175);
        
        popupWindow.setScene(popupScene);
        popupWindow.showAndWait();
    }
    
    /*
     * Method to set allow a user to sign in to the program
     * Tests the entered password against the stored password in the database, and stores the UserID and Role in variables
     * THIS METHOD IS VERY WIP. NEEDS ALL CODE TO PULL APPROPRIATE DATA FROM THE DATABASE FOR THE COMPARISONS.
     * Every // comment on its own line in this method will represent a line of code to pull from the database.
     */
    public void userSignIn(String userIDInput, String userPassInput){
        ProjUIController controllerObj = new ProjUIController();
        System.out.println(userIDInput + " " + userPassInput);
        controllerObj.infoVerification(userIDInput, userPassInput);
        String passFromDb = controllerObj.getAcceptedUserPass(); // Stores the password from the database that will be compared against. WILL REMOVE INITIALIZATION WHEN DATABASE CODE IS PRESENT. ONLY INITIALIZED FOR TESTING
        System.out.println(passFromDb);
        String idInputDb = controllerObj.getAcceptedUser();
        System.out.println(idInputDb);
        System.out.println("Sign In Test");
        // Search database for password and save in passFromDb variable
        
        /*
         * If/Else statement that compares the input password to the password pulled from the database
         * If the passwords match, the UserID and a role pulled from the database are stored in the class fields
         * If the passwords don't match it displays an error window
         * Only actually tests the password, because the password comparison will return false when for both an invalid ID and a wrong password
         */
        if (userPassInput.equals(passFromDb) && userIDInput.equals(idInputDb)){
            setID(idInputDb);
            setRole(controllerObj.getUserRole());
            currentUser();
            displaySuccess();
            logIn();
            controllerObj.setPermissions();
        } else {
            displayWrongPass();
        }
        
    }
    
    /*
     * Method to create an error window that displays when the UserID or Password are incorrect
     */
    public void displayWrongPass(){
        Stage errorWindow = new Stage();
        
        errorWindow.initModality(Modality.APPLICATION_MODAL); // Makes it so that when the popup window is visible, the user cannot interact with the main application
        errorWindow.setTitle("Error");
        
        Label lbl1 = new Label("Incorrect User ID or Password");
        Label lbl2 = new Label("");
        Label lbl3 = new Label("Contact an Administrator if you have");
        Label lbl4 = new Label("forgotten your ID or Password.");
        Button tryAgainBtn = new Button("Try Again");
        
        tryAgainBtn.setOnAction(e-> errorWindow.close());
        
        VBox vbox = new VBox(3);
        
        vbox.getChildren().addAll(lbl1, lbl2, lbl3, lbl4, tryAgainBtn);
        vbox.setAlignment(Pos.CENTER);
        
        Scene errorScene = new Scene(vbox, 200, 120);
        errorWindow.setScene(errorScene);
        errorWindow.showAndWait();
    }
    
    /*
     * Method that displays a window confirms that the user is signed in
     */
    public void displaySuccess(){
        Stage successWindow = new Stage();
        
        successWindow.initModality(Modality.APPLICATION_MODAL); // Makes it so that when the popup window is visible, the user cannot interact with the main application
        successWindow.setTitle("Signed In");
        
        Label lbl1 = new Label("Successfully signed in.");
        Label lbl2 = new Label("You can close both this and");
        Label lbl3 = new Label("the Sign In window");
        Button closeBtn = new Button("Close");
        
        closeBtn.setOnAction(e-> successWindow.close());
        
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(lbl1, lbl2, lbl3, closeBtn);
        vbox.setAlignment(Pos.CENTER);
        
        Scene successScene = new Scene(vbox, 200, 130);
        successWindow.setScene(successScene);
        successWindow.showAndWait();
    }
   
    
    /*
     * Method that sets the Role associated to the UserID from the database
     */
    public void setRole(String id){
        String role = "Admin"; // Currently initialized for testing. Will not be initialized once code for database retrieval is installed
        
        //Code to get role from database
           
        userRole = role;
    }
    
    /*
     * Get method to allow for external access to the userRole field
     */
    public String getRole(){
        return userRole;
    }
    
    /*
     * Set method for the userID field
     */
    public void setID(String id){
        userID = id;
    }
    
    /*
     * Get method to allow for external access to the userID field
     */
    public String getID(){
        return userID;
    }
    
    /*
     * Method for sending a string to the setRoleLbl method in the controller
     */
    public void logIn() {
        ProjUIController controlObj = new ProjUIController();
        String output = userID + " - " + userRole;
        //System.out.println(output);
        controlObj.setRoleLbl(output);
        controlObj.setSignedIn(true);
    }
    
    /*
     * Void method for assigning current user in Controller class when a log in is successful
    */
    public void currentUser() {
        ProjUIController controlObj = new ProjUIController();
        controlObj.setCurrentUser(getID());
        
    }
    
    
}
