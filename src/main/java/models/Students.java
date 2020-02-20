package models;

import java.util.Objects;

public class Students {
    private int id;
    private String studentName;

    public Students(String studentName) {
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id &&
                studentName == students.studentName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName);
    }
}
