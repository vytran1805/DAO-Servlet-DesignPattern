/**
 * Assessment: Demonstration of DAO Design Pattern with Servlet website
 * Assignment: Assignment 2
 * Student Name: Vy Tran
 * Due Date: April 6, 2023
 * Course & Section #: 22S_CST8288_012
 * Class: TutorsDao.java
 * Description: This class includes CRUD operations for Domain Object
 * Professor Name: Professor Rama Thavasinadar
 * This lab has been completed for demo by: Vy Tran
 * Declaration: This is my own original work and is free from Plagiarism.
 */
package dataaccesslayer;
import java.util.List;
import transferobjects.GradeDTO;
import transferobjects.StudentDTO;

import transferobjects.TutorDTO;

/**
 * This class includesCRUD operations for Domain Object
 *
 * @author VyTran
 */
public interface TutorsDao {

    /**
     * get all records of TutorCourse
     *
     * @return tutorDTO obj
     */
    List<TutorDTO> getAllTutorsInTutorCourseTable();

    /**
     * Get tutorID by Name
     *
     * @param lastName first name
     * @param firstName last name
     * @return tutorDTO obj
     */
    TutorDTO getTutorIDByName(String lastName, String firstName);

    /**
     * Get grade by Name
     *
     * @param lastName last name
     * @param firstName first name
     * @return GradeDTO obj
     */
    GradeDTO getGradeByName(String lastName, String firstName);

    /**
     * Get studentID by Name
     *
     * @param lastName first name
     * @param firstName last name
     * @return studentDTO obj
     */
    StudentDTO getStudentIDbyName(String lastName, String firstName);

    /**
     * add tutor
     *
     * @param tutor tutor
     */
    void addTutor(TutorDTO tutor);

}
