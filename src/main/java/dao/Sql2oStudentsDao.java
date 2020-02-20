package dao;

import models.Students;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oStudentsDao implements StudentsDao{

    private final Sql2o sql2o;

    public Sql2oStudentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addStudent(Students student){
        String sql = "INSERT INTO students (name,studentDate) VALUES (:name,CURRENT_DATE)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(student)
                    .executeUpdate()
                    .getKey();
            student.setId(id);
        }

    }

    @Override
    public List<Students> getAllStudents(){
        String sql="SELECT * FROM students";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Students.class);
        }
    }

    @Override
    public void clearAll(){
        String sql ="DELETE FROM students *";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}
