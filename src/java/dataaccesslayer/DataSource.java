/**
* Assessment: Demonstration of DAO Design Pattern with Servlet website
* Assignment: Assignment 2
* Student Name: Vy Tran
* Due Date: April 6, 2023
* Course & Section #: 22S_CST8288_012
* Class: DataSource.java
* Description: This class represents a data source implementation
* Professor Name: Professor Rama Thavasinadar
* This lab has been completed for demo by: Vy Tran 
* Declaration: This is my own original work and is free from Plagiarism.
*/
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import transferobjects.CredentialsDTO;

/**
 * This class represents a data source implementation
 * @author VyTran
 */
public class DataSource {

    private Connection connection = null;
    Properties props = new Properties();
    private String url = "jdbc:mysql://localhost:3306/tutoring?useSSL=false&allowPublicKeyRetrieval=true";
    private String username;
    private String password;
   

    public DataSource(CredentialsDTO creds) {
        username = creds.getUsername();
        password = creds.getPassword();
    }

    /*
 * Only use one connection for this application, prevent memory leaks.
     */
    public Connection createConnection() {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
