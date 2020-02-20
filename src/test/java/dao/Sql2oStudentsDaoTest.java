package dao;

import models.Students;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oStudentsDaoTest {

    private static Sql2oStudentsDao studentDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/paired_test";
        Sql2o sql2o = new Sql2o(connectionString, "lenny", " ");

        studentDao = new Sql2oStudentsDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        studentDao.clearAll();
    }
    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
    }

    Students testStudent = new Students("Dennis");
    @Test
    public void addStudents_testIfItSavedToDB(){
        studentDao.addStudent(testStudent);
        assertTrue(studentDao.getAllStudents().get(0).equals(testStudent));
    }


}