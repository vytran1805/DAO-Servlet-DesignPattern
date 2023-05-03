/**
* Assessment: Demonstration of DAO Design Pattern with Servlet website
* Assignment: Assignment 2
* Student Name: Vy Tran
* Due Date: April 6, 2023
* Course & Section #: 22S_CST8288_012
* Class: CredentialDTO.java
* Description: This class contains a DTO used to store and transfer DBMS login credentialsse
* Professor Name: Professor Rama Thavasinadar
* This lab has been completed for demo by: Vy Tran 
* Declaration: This is my own original work and is free from Plagiarism.
*/
package transferobjects;

/**
 * a DTO used to store and transfer DBMS login credentials
 * between businesslayer and dataacesslayer
 * @author kriger
 */

public class CredentialsDTO {
    private String username;
    private String password;

    /**
     * simple getter for user name portion of the credentials
     * @return user name portion of the credentials
     */
    public String getUsername() {
        return username;
    }

    /**
     * simple setter for user name portion of the credentials
     * @param username user name portion of the credentials
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * simple getter for password portion of the credentials
     * @return password portion of the credentials
     */
    public String getPassword() {
        return password;
    }

    /**
     * simple setter for password portion of the credentials
     * @param password password portion of the credentials
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}//class
