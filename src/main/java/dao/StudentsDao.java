package dao;

import models.Students;

import java.util.List;

public interface StudentsDao {

    void addStudent(Students student);

    List<Students> getAllStudents();

    void clearAll();
}
