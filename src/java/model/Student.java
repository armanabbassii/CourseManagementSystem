package model;

import java.text.DecimalFormat;

public class Student {
    private int student_id;
    private String name;
    private String major;
    private int year;
    private double gpa;

    public Student(int student_id,String  name, String major, int year, double gpa) {
        this.name = name;
        this.major = major;
        this.year = year;
        this.gpa = gpa;
    }


    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", year=" + year +
                ", gpa=" + gpa +
                '}';
    }

    public int getId() {
        return 0;
    }
}



