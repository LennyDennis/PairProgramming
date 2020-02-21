package models;

import java.sql.Date;
import java.util.Objects;

public class Students {
    private int id;
    private String name;
    private Date studentDate;

    public Students(String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStudentDate() {
        return studentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id &&
                name.equals(students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
