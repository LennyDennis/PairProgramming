package models;
import java.util.Objects;

public class Pairs {
 private int id;
 private String student1;
 private String student2;

    public Pairs(int id, String student1, String student2) {
        this.id = id;
        this.student1 = student1;
        this.student2 = student2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent1() {
        return student1;
    }

    public void setStudent1(String student1) {
        this.student1 = student1;
    }

    public String getStudent2() {
        return student2;
    }

    public void setStudent2(String student2) {
        this.student2 = student2;
    }
}

