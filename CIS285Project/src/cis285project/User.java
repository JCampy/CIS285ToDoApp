/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cis285project;

/**
 *
 * @author Jason
 */
public class User {
    private String userID;
    private String pass;
    private String passConfirm;
    private String street;
    private String city;
    private String state;
    private String phoneNumber;
    private String userRole;
    
    public User(String uID, String p, String pC, String str, String c, String sT, String pN) {
        this.userID = uID;
        this.pass = p;
        this.passConfirm = pC;
        this.street = str;
        this.city = c;
        this.state = sT;
        this.phoneNumber = pN;
        
    }
    
    public void setUserID(String uID) {
    this.userID = uID;       
    }
    
    public String getUserID() {
    return this.userID;           
    }
    
    public void setPass(String p) {
    this.pass = p;        
    }
    
    public String getPass() {
    return this.pass;          
    }
    
    public void setPassConfirm(String pC) {
    this.pass = pC;        
    }
    
    public String getPassConfirm() {
    return this.passConfirm;          
    }
    
    public void setStreet(String str) {   
    this.street = str;     
    }
    
    public String getStreet() {
    return this.street;    
    }
    
    public void setCity(String c) { 
    this.city = c;       
    }
    
    public String getCity() {  
    return this.city;         
    }
    
    public void setState(String str) {
    this.state = str;          
    }
    
    public String getState() {
    return this.state;         
    }
    
    public void setPhoneNumber(String pN) {
    this.phoneNumber = pN;          
    }
    
    public String getPhoneNumber() {
    return this.phoneNumber;         
    }
    
    public void setUserRole(String uR) {
    this.userRole = uR;          
    }
    
    public String getUserRole() {
    return this.userRole;         
    }
}
