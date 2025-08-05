package util;

import model.Student;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    public static Connection getConnetion() throws SQLException {

        String URL = "jdbc:postgresql://localhost:5432//CourseManagementSystem";
        String USER = "postgres";
        String PASSWORD = "123456";

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void executeLine(String sql, Object... params) {
        try (Connection connection = getConnetion();
             PreparedStatement pstm = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("error: " + e.getMessage(), e);
        }
    }

    public static void addStudent(Student student) throws IllegalAccessException {
        if (student.getName() == null) {
            throw new IllegalAccessException("name of student is a required filed");
        }

        String sql = "insert into student(name, major, years, gpa) VALUES (?,?,?,?)";
        executeLine(sql, student.getName(), student.getMajor(), student.getYear(), student.getGpa());
    }

    public static void updateStudent(int studentId, Student student) {
        String sql = "update student set name = ?, major=?, years = ?, gpa=? where student_id = ?";
        executeLine(sql, student.getName(), student.getMajor(), student.getYear(), student.getGpa(), studentId);
    }

    public static void deleteStudent(int studentId) {
        String sql = "delete from student where student_id = ?";
        DBUtil.executeLine(sql, studentId);
    }

    public static Student readStudent(int studentId) {
        String sql = "select * from student where student_id = ?";
        try (Connection connection = getConnetion();
             PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, studentId);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getString("name"),
                            resultSet.getString("major"),
                            resultSet.getInt("years"),
                            resultSet.getDouble("gpa")
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reading student: " + e.getMessage(), e);
        }
    }



    public static List<Student> readAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection connection = getConnetion();
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("major"),
                        rs.getInt("years"),
                        rs.getDouble("gpa")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reading all students: " + e.getMessage(), e);
        }
        return students;
    }
}
