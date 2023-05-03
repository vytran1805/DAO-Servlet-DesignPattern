/**
 * Assessment: Demonstration of DAO Design Pattern with Servlet website
 * Assignment: Assignment 2
 * Student Name: Vy Tran
 * Due Date: April 6, 2023
 * Course & Section #: 22S_CST8288_012
 * Class: TutorsBusinessLogic.java
 * Description: This class includes methods to modify DTO objects and require access to Data Sources to obtain/store data
 * Professor Name: Professor Rama Thavasinadar
 * This lab has been completed for demo by: Vy Tran
 * Declaration: This is my own original work and is free from Plagiarism.
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.TutorsDaoImpl;
import transferobjects.TutorDTO;
import transferobjects.CredentialsDTO;
import dataaccesslayer.TutorsDao;
import transferobjects.GradeDTO;
import transferobjects.StudentDTO;

/**
 * This class modifies DTO object and requires access to Data Sources to
 * obtain/store data
 *
 * @author VyTran
 */
public class TutorsBusinessLogic {

    private static final int FIRST_NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final int COURSE_CODE_MAX_LENGTH = 7;

    private TutorsDao tutorsDao = null;
    private CredentialsDTO creds;

    /**
     * Constructor with one argument
     * @param creds credentialsDTO
     */
    public TutorsBusinessLogic(CredentialsDTO creds) {
        tutorsDao = new TutorsDaoImpl(creds);
    }

    /**
     * This method returns records off all Tutors that are assigned for the
     * course, in other word, retrieves data from TutorCourse table
     *
     * @return the list of all tutors that are assigned to the course
     */
    public List<TutorDTO> getAllTutors() {
        return tutorsDao.getAllTutorsInTutorCourseTable();
    }

    /**
     * This method checks if a person is a Student
     *
     * @param student student information
     * @return student
     * @throws ValidationException exception
     */
    public boolean checkIsAStudent(StudentDTO student) throws ValidationException {
        boolean isAStudent = false;
        if (tutorsDao.getStudentIDbyName(student.getStudentLastName(), student.getStudentFirstName()) == null) {
            isAStudent = false;
        } else {
            isAStudent = true;
        }
        return isAStudent;
    }

    /**
     * Get tutorID from last name and first name
     * @param lastName last name
     * @param firstName first name
     * @return tutorDTO
     */
    public TutorDTO getTutorID(String lastName, String firstName) {
        return tutorsDao.getTutorIDByName(lastName, firstName);
    }

    /**
     * This method checks if the person is a Tutor
     *
     * @param tutor tutor
     * @return boolean
     * @throws ValidationException exception
     */
    public boolean checkIsATutor(TutorDTO tutor) throws ValidationException {
        boolean isATutor = false;
        cleanTutor(tutor);
        validateTutor(tutor);
        if (tutorsDao.getTutorIDByName(tutor.getLastName(), tutor.getFirstName()) == null) {
            isATutor = false;
        } else {
            isATutor = true;
        }
        return isATutor;
    }

    /**
     * Get grade based on student information
     *
     * @param student studentDTO
     */
    public void getGrade(StudentDTO student) {
        String grade = tutorsDao.getGradeByName(student.getStudentLastName(), student.getStudentLastName()).getGrade();
        System.out.println(grade);
    }

    ;
    /**
     * This method checks if this student's grade is qualified to be a tutor
     * @param gradeDTO gradeDTO
     * @return boolean
     * @throws ValidationException exception
     */
    public boolean checkGradeQualified(GradeDTO gradeDTO) throws ValidationException {
        boolean isQualified;
//        cleanTutor(tutor);
//        validateTutor(tutor);
        String grade = tutorsDao.getGradeByName(gradeDTO.getLastName(), gradeDTO.getFirstName()).getGrade();
        if ("A-".equals(grade) || "A".equals(grade) || "A+".equals(grade)) {
            isQualified = true;
        } else {
            isQualified = false;
        }
        return isQualified;
    }

    /**
     * This method adds the person to the tutorcourse table once the validation
     * succeeds
     *
     * @param tutor the input tutor
     * @throws ValidationException exception
     */
    public void addTutor(TutorDTO tutor) throws ValidationException {
        tutorsDao.addTutor(tutor);
    }

    /**
     * This method cleans the input (only used for TutorDTO) Needs to modify in
     * order to be used for other DTO classes
     *
     * @param tutor tutor
     */
    private void cleanTutor(TutorDTO tutor) {
        if (tutor.getFirstName() != null) {
            tutor.setFirstName(tutor.getFirstName().trim());
        }
        if (tutor.getLastName() != null) {
            tutor.setLastName(tutor.getLastName().trim());
        }
    }

    /**
     * Validate the input based on the database constraints (only used for
     * TutorDTO) Needs to modify in order to be used for other DTO classes
     *
     * @param tutor tutor
     * @throws ValidationException exception
     */
    private void validateTutor(TutorDTO tutor) throws ValidationException {
        validateString(tutor.getFirstName(), "First Name", FIRST_NAME_MAX_LENGTH, true);
        validateString(tutor.getLastName(), "Last Name", LAST_NAME_MAX_LENGTH, true);
        validateString(tutor.getLastName(), "Last Name", COURSE_CODE_MAX_LENGTH, true);
    }

    /**
     * Validate the String
     *
     * @param value input value
     * @param fieldName field name
     * @param maxLength max length allows
     * @param isNullAllowed is nullable or not
     * @throws ValidationException exception
     */
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
            throws ValidationException {
        if (value == null && isNullAllowed) {
            return; // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new ValidationException(String.format("%s cannot be null",
                    fieldName));
        } else if (value.length() == 0) {
            throw new ValidationException(String.format("%s cannot be empty or only whitespace",
                    fieldName));
        } else if (value.length() > maxLength) {
            throw new ValidationException(String.format("%s cannot exceed %d characters",
                    fieldName, maxLength));
        }
    }
    /*
	private void validateInt(int value, String fieldName)
	    throws ValidationException{
		if(value <= 0){
			throw new ValidationException(String.format("%s cannot be a negative number", 
					fieldName));
		}
	}
     */
}
