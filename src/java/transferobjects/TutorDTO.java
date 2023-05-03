/**
* Assessment: Demonstration of DAO Design Pattern with Servlet website
* Assignment: Assignment 2
* Student Name: Vy Tran
* Due Date: April 6, 2023
* Course & Section #: 22S_CST8288_012
* Class: TutorDTO.java
* Description: This class contains encapsulates tutor's data sent between DAO and Domain layer
* Professor Name: Professor Rama Thavasinadar
* This lab has been completed for demo by: Vy Tran 
* Declaration: This is my own original work and is free from Plagiarism.
*/
package transferobjects;
/**
 * TutorDTO used to store and transfer Tutor data
 * @author VyTran
 */
public class TutorDTO {
    private int tutorID;
    private String firstName;
    private String lastName;
    private String courseCode;
    private String grade;

    /**
     * get grade
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * set grade
     * @param grade grade 
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    /**
     * get tutor ID
     * @return tutor ID
     */
    public int getTutorID() {
        return tutorID;
    }

    /**
     * set Tutor ID
     * @param tutorID tutor ID 
     */
    public void setTutorID(int tutorID) {
        this.tutorID = tutorID;
    } 

    /**
     * get course code
     * @return course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * set course code
     * @param courseCode course code 
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    /**
     * get tutor's first name
     * @return first name of the tutor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set tutor's first name
     * @param firstName first name of the tutor
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

        /**
     * get tutor's last name
     * @return last name of the tutor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set tutor's last name
     * @param lastName last name of the tutor
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
