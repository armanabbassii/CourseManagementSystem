package model;

public class Enrollment {
    private int student_id;
    private int course_id;
    private int enrollmentDate;
    private String grade;

    public Enrollment(int student_id, int enrollmentDate, int course_id, String grade) {
        this.student_id = student_id;
        this.enrollmentDate = enrollmentDate;
        this.course_id = course_id;
        this.grade = grade;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(int enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student_id=" + student_id +
                ", course_id=" + course_id +
                ", enrollmentDate=" + enrollmentDate +
                ", grade='" + grade + '\'' +
                '}';
    }
}

