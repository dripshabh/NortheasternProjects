package javamysql;
import java.sql.*;
import java.util.Scanner;

public class AcademicTrackerApp {
  private static final String DB_URL = "jdbc:mysql://localhost/academictracker";
  private static final String DB_USER = getUsernameFromUser();
  private static final String DB_PASSWORD = getPasswordFromUser();

  public static void main(String[] args) {
    try {
      // Step 1: Establish a connection to the database
      Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//
//      // Call the createCourse procedure
//      createCourse(connection, "Math", 1, 90, 2023);
//
//      // Call the readCourse procedure
//      readCourse(connection, 1);
//
//      // Call the updateCourse procedure
//      updateCourse(connection, 1, "Mathematics", 95, 2024);
//
//      // Call the deleteCourse procedure
//      deleteCourse(connection, 1);
//
//      // Call the createTranscript procedure
//      createTranscript(connection, "Science", 2, 2023, 85);
//
//      // Call the readTranscript procedure
//      readTranscript(connection, 2);
//
//      // Call the updateTranscript procedure
//      updateTranscript(connection, "Science", 2, 2024, 90);
//
//      // Call the deleteTranscript procedure
//      deleteTranscript(connection, "Science", 2);
//
//      // Call the createNote procedure
//      createNote(connection, "Note 1", "note1.txt", 1);
//
//      // Call the readNote procedure
//      readNote(connection, 1);
//
//      // Call the updateNote procedure
//      updateNote(connection, "Note 1", "new_note1.txt", 2);
//
//      // Call the deleteNote procedure
//      deleteNote(connection, "Note 1");
//
//      // Call the createAssignment procedure
//      createAssignment(connection, "Assignment 1", "2023-06-21", 90, 1, "Homework", 10);
//
//      // Call the readAssignment procedure
//      readAssignment(connection, "Assignment 1");
//
//      // Call the updateAssignment procedure
//      updateAssignment(connection, "Assignment 1", "2023-06-22", 1, 95, "Exam", 20);
//
//      // Call the deleteAssignment procedure
//      deleteAssignment(connection, "Assignment 1", 1);
//
//      // Call the createStudent procedure
//      createStudent(connection, "John Doe", "john@example.com", 1);
//
//      // Call the readStudent procedure
//      readStudent(connection, 1);
//
//      // Call the deleteStudent procedure
//      deleteStudent(connection, "John Doe", "john@example.com", 1);
//
//      // Call the createStaff procedure
//      createStaff(connection, "Jane Smith", "jane@example.com", 1, 1);
//
//      // Call the readStaff procedure
//      readStaff(connection, 1);
//
//      // Call the updateStaff procedure
//      updateStaff(connection, "Jane Doe", "jane.doe@example.com", 1, 2);
//
//      // Call the deleteStaff procedure
//      deleteStaff(connection, 1);
//
//      // Call the createResource procedure
//      createResource(connection, "Resource 1", 1, "Book", "John Smith");
//
//      // Call the readResource procedure
//      readResource(connection, "Resource 1");
//
//      // Call the updateResource procedure
//      updateResource(connection, "Resource 1", "Website", "Jane Doe");
//
//      // Call the deleteResource procedure
//      deleteResource(connection, "Resource 1");

      Scanner scanner = new Scanner(System.in);
      boolean exit = false;

      while (!exit) {
          System.out.println("Student Menu");
          System.out.println("1. Create");
          System.out.println("2. Read");
          System.out.println("3. Update");
          System.out.println("4. Delete");
          System.out.println("0. Exit");

          System.out.print("Enter your choice: ");
          int choice = scanner.nextInt();
          scanner.nextLine(); // Consume newline character

          switch (choice) {
              case 1:
                  viewOverallTranscript(connection);
                  break;
              case 2:
                  readMenu(connection);
                  break;
              case 3:
                  updateMenu
              case 0:
                  exit = true;
                  break;
              default:
                  System.out.println("Invalid choice. Please try again.");
          }

          System.out.println();
      }
      // Step 5: Close the connection
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static String getUsernameFromUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter MySQL username: ");
    return scanner.nextLine();
  }

  private static String getPasswordFromUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter MySQL password: ");
    return scanner.nextLine();
  }
  
  public static void createCourse(Connection connection, String name, int courseID, int grade, int year) throws SQLException {
    String query = "CALL createCourse(?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setInt(2, courseID);
      statement.setInt(3, grade);
      statement.setInt(4, year);
      statement.execute();
      System.out.println("Course created successfully.");
    }
  }

  public static void readCourse(Connection connection, int courseID) throws SQLException {
    String query = "CALL readCourse(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, courseID);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        int courseId = resultSet.getInt("courseID");
        int grade = resultSet.getInt("grade");
        int year = resultSet.getInt("year");
        System.out.println("Name: " + name + ", Course ID: " + courseId + ", Grade: " + grade + ", Year: " + year);
      }
    }
  }

  public static void updateCourse(Connection connection, int courseID, String newName, int newGrade, int newYear) throws SQLException {
    String query = "CALL updateCourse(?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, courseID);
      statement.setString(2, newName);
      statement.setInt(3, newGrade);
      statement.setInt(4, newYear);
      statement.execute();
      System.out.println("Course updated successfully.");
    }
  }

  public static void deleteCourse(Connection connection, int courseID) throws SQLException {
    String query = "CALL deleteCourse(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, courseID);
      statement.execute();
      System.out.println("Course deleted successfully.");
    }
  }

  public static void createTranscript(Connection connection, String name, int courseID, int year, int grade) throws SQLException {
    String query = "CALL createTranscript(?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setInt(2, courseID);
      statement.setInt(3, year);
      statement.setInt(4, grade);
      statement.execute();
      System.out.println("Transcript created successfully.");
    }
  }

  public static void readTranscript(Connection connection, int courseID) throws SQLException {
    String query = "CALL readTranscript(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, courseID);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        int courseId = resultSet.getInt("courseID");
        int year = resultSet.getInt("year");
        int grade = resultSet.getInt("grade");
        System.out.println("Name: " + name + ", Course ID: " + courseId + ", Year: " + year + ", Grade: " + grade);
      }
    }
  }

  public static void updateTranscript(Connection connection, String name, int courseID, int newYear, int newGrade) throws SQLException {
    String query = "CALL updateTranscript(?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setInt(2, courseID);
      statement.setInt(3, newYear);
      statement.setInt(4, newGrade);
      statement.execute();
      System.out.println("Transcript updated successfully.");
    }
  }

  public static void deleteTranscript(Connection connection, String name, int courseID) throws SQLException {
    String query = "CALL deleteTranscript(?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setInt(2, courseID);
      statement.execute();
      System.out.println("Transcript deleted successfully.");
    }
  }

  public static void createNote(Connection connection, String name, String filename, int courseID) throws SQLException {
    String query = "CALL createNote(?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setString(2, filename);
      statement.setInt(3, courseID);
      statement.execute();
      System.out.println("Note created successfully.");
    }
  }

  public static void readNote(Connection connection, int courseID) throws SQLException {
    String query = "CALL readNote(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, courseID);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        String filename = resultSet.getString("filename");
        int courseId = resultSet.getInt("courseID");
        System.out.println("Name: " + name + ", Filename: " + filename + ", Course ID: " + courseId);
      }
    }
  }

  public static void updateNote(Connection connection, String name, String newFilename, int newCourseID) throws SQLException {
    String query = "CALL updateNote(?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setString(2, newFilename);
      statement.setInt(3, newCourseID);
      statement.execute();
      System.out.println("Note updated successfully.");
    }
  }

  public static void deleteNote(Connection connection, String name) throws SQLException {
    String query = "CALL deleteNote(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.execute();
      System.out.println("Note deleted successfully.");
    }
  }

  public static void createAssignment(Connection connection, String name, String dueDate, int grade, int courseID, String type, int weight) throws SQLException {
    String query = "CALL createAssignment(?, ?, ?, ?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setString(2, dueDate);
      statement.setInt(3, grade);
      statement.setInt(4, courseID);
      statement.setString(5, type);
      statement.setInt(6, weight);
      statement.execute();
      System.out.println("Assignment created successfully.");
    }
  }

  public static void readAssignment(Connection connection, String name) throws SQLException {
    String query = "CALL readAssignment(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String assignmentName = resultSet.getString("name");
        String dueDate = resultSet.getString("due_date");
        int courseId = resultSet.getInt("courseID");
        int grade = resultSet.getInt("grade");
        String assignmentType = resultSet.getString("type");
        int weight = resultSet.getInt("weight");
        System.out.println("Name: " + assignmentName + ", Due Date: " + dueDate + ", Course ID: " + courseId + ", Grade: " + grade + ", Type: " + assignmentType + ", Weight: " + weight);
      }
    }
  }

  public static void updateAssignment(Connection connection, String name, String newDueDate, int courseID, int newGrade, String newType, int newWeight) throws SQLException {
    String query = "CALL updateAssignment(?, ?, ?, ?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setString(2, newDueDate);
      statement.setInt(3, courseID);
      statement.setInt(4, newGrade);
      statement.setString(5, newType);
      statement.setInt(6, newWeight);
      statement.execute();
      System.out.println("Assignment updated successfully.");
    }
  }

  public static void deleteAssignment(Connection connection, String name, int courseID) throws SQLException {
    String query = "CALL deleteAssignment(?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setInt(2, courseID);
      statement.execute();
      System.out.println("Assignment deleted successfully.");
    }
  }

  public static void createStudent(Connection connection, String name, String studentEmail, int courseID) throws SQLException {
    String query = "CALL createStudent(?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setString(2, studentEmail);
      statement.setInt(3, courseID);
      statement.execute();
      System.out.println("Student created successfully.");
    }
  }

  public static void readStudent(Connection connection, int courseID) throws SQLException {
    String query = "CALL readStudent(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, courseID);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        String studentEmail = resultSet.getString("student_email");
        int courseId = resultSet.getInt("courseID");
        System.out.println("Name: " + name + ", Student Email: " + studentEmail + ", Course ID: " + courseId);
      }
    }
  }

  public static void deleteStudent(Connection connection, String name, String studentEmail, int courseID) throws SQLException {
    String query = "CALL deleteStudent(?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setString(2, studentEmail);
      statement.setInt(3, courseID);
      statement.execute();
      System.out.println("Student deleted successfully.");
    }
  }

  public static void createStaff(Connection connection, String name, String email, int staffID, int courseID) throws SQLException {
    String query = "CALL createStaff(?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, name);
      statement.setString(2, email);
      statement.setInt(3, staffID);
      statement.setInt(4, courseID);
      statement.execute();
      System.out.println("Staff created successfully.");
    }
  }

  public static void readStaff(Connection connection, int staffID) throws SQLException {
    String query = "CALL readStaff(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, staffID);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        int staffId = resultSet.getInt("staffID");
        int courseId = resultSet.getInt("courseID");
        System.out.println("Name: " + name + ", Email: " + email + ", Staff ID: " + staffId + ", Course ID: " + courseId);
      }
    }
  }

  public static void updateStaff(Connection connection, String newName, String newEmail, int staffID, int newCourseID) throws SQLException {
    String query = "CALL updateStaff(?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, newName);
      statement.setString(2, newEmail);
      statement.setInt(3, staffID);
      statement.setInt(4, newCourseID);
      statement.execute();
      System.out.println("Staff updated successfully.");
    }
  }

  public static void deleteStaff(Connection connection, int staffID) throws SQLException {
    String query = "CALL deleteStaff(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setInt(1, staffID);
      statement.execute();
      System.out.println("Staff deleted successfully.");
    }
  }

  public static void createResource(Connection connection, String resourceName, int courseID, String type, String authorName) throws SQLException {
    String query = "CALL createResource(?, ?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, resourceName);
      statement.setInt(2, courseID);
      statement.setString(3, type);
      statement.setString(4, authorName);
      statement.execute();
      System.out.println("Resource created successfully.");
    }
  }

  public static void readResource(Connection connection, String resourceName) throws SQLException {
    String query = "CALL readResource(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, resourceName);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String name = resultSet.getString("resource_name");
        int courseId = resultSet.getInt("courseID");
        String resourceType = resultSet.getString("type");
        String authorName = resultSet.getString("author_name");
        System.out.println("Name: " + name + ", Course ID: " + courseId + ", Type: " + resourceType + ", Author: " + authorName);
      }
    }
  }

  public static void updateResource(Connection connection, String resourceName, String newType, String newAuthorName) throws SQLException {
    String query = "CALL updateResource(?, ?, ?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, resourceName);
      statement.setString(2, newType);
      statement.setString(3, newAuthorName);
      statement.execute();
      System.out.println("Resource updated successfully.");
    }
  }

  public static void deleteResource(Connection connection, String resourceName) throws SQLException {
    String query = "CALL deleteResource(?)";
    try (CallableStatement statement = connection.prepareCall(query)) {
      statement.setString(1, resourceName);
      statement.execute();
      System.out.println("Resource deleted successfully.");
    }
  }
  
  public static void view(Connection connection) {
    
  }
  
  public static void edit(Connection connection) {
    
  }
}
