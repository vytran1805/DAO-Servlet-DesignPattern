# Tutor Assignment Project

This project combines the use of the DAO pattern with servlet. The purpose of this project is to process a web client’s request to assign a course to a tutor.

## Project Description

- Create a webpage that accepts the user id and password for the database, first name and lastname of the tutor, and the course code (CST8101) of the course to be assigned.
- Launch the servlet that utilizes the DAO implementation to validate the data, assign the course to the tutor, and obtain the required data.
- Return a suitable error message if the validation fails or a table of all the tutors who are assigned to the course, including the one just added if the validation succeeds.
- A person qualifies to tutor the course if that person is a tutor and had completed the course with the grade of "A-", "A", or "A+".
- Provide a Web page to launch the servlet.The initial Web page must prompt the end-user to enter the userid and password to authenticate to the MySQL database, the first name and lastname of the tutor, and the coursecode of the course to be assigned.
- The servlet will produce the HTML output as the response to the servlet request. This will be either a suitable error message if the validation failed or a table of all the tutors who are assigned to the course, including the one just added.
- **Java packages**: businesslayer, dataaccesslayer (including a class to encapsulate the "data source"), transferobjects, and viewlayer.

## Getting Started

### Prerequisites

- MySQL database
- Java Development Kit (JDK)
- Apache Tomcat
- Netbeans IDE

### Installation

- Clone the repository from GitHub.
- Import the project into Eclipse.
- Set up the MySQL database and run the SQL scripts provided.
- Configure the database connection in the dataaccesslayer package.
- Deploy the project on Apache Tomcat.

## Authors

- This project was created by [@vytran](https://www.github.com/vytran1805)
