/**
 * Assessment: Demonstration of DAO Design Pattern with Servlet website
 * Assignment: Assignment 2
 * Student Name: Vy Tran
 * Due Date: April 6, 2023
 * Course & Section #: 22S_CST8288_012
 * Class: TutorsDaoImpl.java
 * Description: This concrete class implements the interface TutorsDAO,
 *               receive the data from the client in a DTO Object to update
 *               the data in the data source.
 * Professor Name: Professor Rama Thavasinadar
 * This lab has been completed for demo by: Vy Tran
 * Declaration: This is my own original work and is free from Plagiarism.
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.TutorDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import transferobjects.CredentialsDTO;
import transferobjects.GradeDTO;
import transferobjects.StudentDTO;

/**
 * This concrete class implements the interface TutorsDAO, receive the data from
 * the client in a DTO Object to update the data in the data source.
 *
 * @author VyTran
 */
public class TutorsDaoImpl implements TutorsDao {

    private CredentialsDTO creds;

    public TutorsDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }

    /**
     * Get all the records of tutors that has assigned to the course
     *
     * @return the list of recipients
     */
    @Override
    public List<TutorDTO> getAllTutorsInTutorCourseTable() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<TutorDTO> tutors = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "select tutor_TutorID, LastName, FirstName from tutorcourse, tutor where tutorcourse.tutor_TutorID = tutor.TutorID;");
            rs = pstmt.executeQuery();
            tutors = new ArrayList<TutorDTO>();
            while (rs.next()) {
                TutorDTO tutor = new TutorDTO();
                tutor.setTutorID(rs.getInt("tutor_tutorID"));
                tutor.setFirstName(rs.getString("firstName"));
                tutor.setLastName(rs.getString("lastName"));
                tutors.add(tutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tutors;
    }

    /**
     * Get StudentID by Name to check if the person is a student
     * @param lastName last name
     * @param firstName first name
     * @return student
     */
    @Override
    public StudentDTO getStudentIDbyName(String lastName, String firstName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentDTO student = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID, firstName, lastName FROM student WHERE lastName = ? and firstName = ?");
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new StudentDTO();
                student.setStudentID(rs.getInt("StudentID"));
                student.setStudentLastName(rs.getString("lastname"));
                student.setStudentFirstName(rs.getString("firstName"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return student;
    }

    /**
     * This method retrieves the student grade based on last name and first name
     *
     * @param lastName last name of the student
     * @param firstName first name of the student
     * @return GradeDTO
     */
    @Override
    public GradeDTO getGradeByName(String lastName, String firstName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        GradeDTO grade = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "select gradeCode, lastname, firstname from grade "
                    + "join student on grade.student_StudentID = student.studentID "
                    + "where lastname = ? and firstName = ?");
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                grade = new GradeDTO();
                grade.setGrade(new String(rs.getString("gradeCode")));
                grade.setLastName(rs.getString("lastname"));
                grade.setFirstName(rs.getString("firstName"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return grade;
    }

    /**
     * this methods retrieves tutor's information based on their last name
     *
     * @param lastName lastname of the tutor
     * @return TutorDTO object
     */
    @Override
    public TutorDTO getTutorIDByName(String lastName, String firstName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TutorDTO tutor = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT tutorID, firstName, lastName FROM tutor WHERE lastName = ? and firstName = ?");
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                tutor = new TutorDTO();
                tutor.setTutorID(rs.getInt("tutorID"));
                tutor.setLastName(rs.getString("lastname"));
                tutor.setFirstName(rs.getString("firstName"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tutor;
    }

    /**
     * Assign tutor to the course
     * @param tutor tutor
     */
    @Override
    public void addTutor(TutorDTO tutor) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement(
                    "INSERT INTO tutorcourse (tutor_TutorID, course_CourseCode) "
                    + "VALUES(?, ?)");
            pstmt.setInt(1, tutor.getTutorID());
            pstmt.setString(2, tutor.getCourseCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
