import java.sql.*;

public class StudentManager {

    //  add a new student
    public static void addStudent(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, age, course) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getCourse());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // display all students
    public static void displayAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String course = resultSet.getString("course");

             
                System.out.println("===========================");  
               
                System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Age: " + age + ", Course: " + course);
            
                System.out.println("===========================");  
                }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }
    
     update a student's details
    public static void updateStudent(int studentId, Student student) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, age = ?, course = ? WHERE student_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getCourse());
            preparedStatement.setInt(5, studentId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
     delete a student by ID
    public static void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, studentId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
