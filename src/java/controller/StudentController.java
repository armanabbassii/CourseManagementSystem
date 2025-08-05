package controller;

import model.Student;
import util.DBUtil;

import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StudentController {

    List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) throws IllegalAccessException {
        DBUtil.addStudent(student);
        studentList.add(student);
    }


    public void updateStudent(int studentId, Student updatedStudent) {

        DBUtil.updateStudent(studentId, updatedStudent);
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == studentId) {
                studentList.set(i, updatedStudent);
                return;
            }
        }
    }

    public Student getStudent(int studentId){
        for(Student student : studentList){
            if(student.getId() == studentId){
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudentList(){
        studentList = DBUtil.readAllStudents();
        return new ArrayList<>(studentList);
    }

    public void deleteStudent(int studentId) {
        DBUtil.deleteStudent(studentId);
        studentList.removeIf(student -> student.getId() == studentId);
    }

    public long studentsOlderThanCertainYear(int year){
        return studentList.stream()
                .filter(student -> student.getYear() < year)
                .count();
    }
    public void studentNamesUpperCase(){
        Consumer<Student> printUpperCase = student ->
                System.out.println(student.getName().toUpperCase());
        studentList.forEach(printUpperCase);
    }

    public void highGpaStudents(){
        studentList.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase("Computer Science"))
                .filter(student -> student.getGpa() > 3.5)
                .forEach(student -> System.out.println("student: " + student.getName() + "gpa: " + student.getGpa()));
    }
}

