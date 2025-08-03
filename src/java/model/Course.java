package model;

public class Course {
    private String title;
    private String department;
    private String credits;

    public Course(String department, String credits, String title) {
        this.department = department;
        this.credits = credits;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", credits='" + credits + '\'' +
                '}';
    }
}
