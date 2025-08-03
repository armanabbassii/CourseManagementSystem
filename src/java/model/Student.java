package model;

public class Student {
    private String name;
    private String major;
    private int year;
    private String gpa;

    public Student(String name, String major, int year, String gpa) {
        this.name = name;
        this.major = major;
        this.year = year;
        this.gpa = gpa;
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

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", year=" + year +
                ", gpa='" + gpa + '\'' +
                '}';
    }
}



