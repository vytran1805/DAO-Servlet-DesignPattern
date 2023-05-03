/**
* Assessment: Demonstration of DAO Design Pattern with Servlet website
* Assignment: Assignment 2
* Student Name: Vy Tran
* Due Date: April 6, 2023
* Course & Section #: 22S_CST8288_012
* Class: MyServlet.java
* Description: 
* Professor Name: Professor Rama Thavasinadar
* This lab has been completed for demo by: Vy Tran 
* Declaration: This is my own original work and is free from Plagiarism.
*/
package servlet_pkg;

import businesslayer.TutorsBusinessLogic;
import businesslayer.ValidationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.CredentialsDTO;
import transferobjects.TutorDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.GradeDTO;
import transferobjects.StudentDTO;

/**
 * View class
 * @author VyTran
 */
public class MyServlet extends HttpServlet {

    private CredentialsDTO creds = new CredentialsDTO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ValidationException {
        response.setContentType("text/html");
        //response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Sample Form Servlet</h1>");
            
            
            creds.setUsername(request.getParameter("username"));
            creds.setPassword(request.getParameter("password"));
            
            TutorsBusinessLogic logic = new TutorsBusinessLogic(creds);
            StudentDTO student = new StudentDTO();
            student.setStudentFirstName(request.getParameter("firstname").trim());
            student.setStudentLastName(request.getParameter("lastname").trim());
            
            GradeDTO grade = new GradeDTO();
            grade.setLastName(student.getStudentLastName());
            grade.setFirstName(student.getStudentFirstName());

            TutorDTO tutor = new TutorDTO();
            tutor.setCourseCode(request.getParameter("coursecode").trim());
            tutor.setFirstName(student.getStudentFirstName());
            tutor.setLastName(student.getStudentLastName());
            if (logic.checkIsAStudent(student) == false) {
                out.print("Invalid input");
                
            } else if (logic.checkIsATutor(tutor) == false) {
                out.println("<ul><strong>FirstName: </strong>" + tutor.getFirstName() + "</ul>");
                out.println("<ul><strong>LastName: </strong>" + tutor.getLastName() + "</ul>");
                out.println("The person has not registered as a tutor!");
                
            } else if (logic.checkGradeQualified(grade) == false) {
                out.println("<ul><strong>FirstName: </strong>" + tutor.getFirstName() + "</ul>");
                out.println("<ul><strong>LastName: </strong>" + tutor.getLastName() + "</ul>");
                out.println("The person does not qualify to tutor this course as the obtained grade is not sufficient");
            
            } else {
                tutor.setTutorID(logic.getTutorID(tutor.getLastName(), tutor.getFirstName()).getTutorID());
                logic.addTutor(tutor);
                List<TutorDTO> tutors = logic.getAllTutors();
                out.print("Table of Tutors assigned to CST8101");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<td>ID</td>");
                out.println("<td>Last Name</td>");
                out.println("<td>First Name</td>");
                out.println("</tr>");
                for (TutorDTO aTutor : tutors) {
                    out.printf("<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
                            aTutor.getTutorID(), aTutor.getLastName(), aTutor.getFirstName());
                }
                out.println("</table>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ValidationException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ValidationException ex) {
            System.out.println("Idk what's happening!");
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
