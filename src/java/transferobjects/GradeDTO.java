/**
* Assessment: Demonstration of DAO Design Pattern with Servlet website
* Assignment: Assignment 2
* Student Name: Vy Tran
* Due Date: April 6, 2023
* Course & Section #: 22S_CST8288_012
* Class: GradeDTO.java
* Description: This class contains encapsulates grade's data sent between DAO and Domain layer
* Professor Name: Professor Rama Thavasinadar
* This lab has been completed for demo by: Vy Tran 
* Declaration: This is my own original work and is free from Plagiarism.
*/
package transferobjects;

/**
 * GradeDTO used to store and transfer Grade
 * @author VyTran
 */
public class GradeDTO {
    private String grade;
    private String firstName;
    private String lastName;
    
    /**
     * get student Grade
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * set student grade
     * @param grade grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * get student's first name
     * @return first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set student's first name
     * @param firstName first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get student's last name
     * @return last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set student's last name
     * @param lastName last name of the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
