/**
* Assessment: Demonstration of DAO Design Pattern with Servlet website
* Assignment: Assignment 2
* Student Name: Vy Tran
* Due Date: April 6, 2023
* Course & Section #: 22S_CST8288_012
* Class: StudentDTO.java
* Description: This class contains encapsulates student's data sent between DAO and Domain layer
* Professor Name: Professor Rama Thavasinadar
* This lab has been completed for demo by: Vy Tran 
* Declaration: This is my own original work and is free from Plagiarism.
*/
package transferobjects;

/**
 * StudentDTO used to store and transfer Student data
 * @author VyTran
 */
public class StudentDTO {
    private String studentLastName;
    private String studentFirstName;
    private int studentID;
    /**
     * get student's last name
     * @return last name of the student
     */
    public String getStudentLastName() {
        return studentLastName;
    }

    /**
     * set student's last name
     * @param studentLastName last name of the student
     */
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    /**
     * get student's first name
     * @return first name of the student
     */
    public String getStudentFirstName() {
        return studentFirstName;
    }

    /**
     * set student's first name
     * @param studentFirstName first name of the student
     */
    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    /**
     * get student ID
     * @return ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * set student ID
     * @param studentID ID 
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
