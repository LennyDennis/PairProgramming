package dao;

import models.Students;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.Assert.*;

public class Sql2oStudentsDaoTest {
    private static Connection conn;
    private static Sql2oStudentsDao studentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/paired_test";
        Sql2o sql2o = new Sql2o(connectionString, "lenny", " ");
        studentDao = new Sql2oStudentsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        studentDao.clearAll();
        System.out.println("Nice clean slate coming up...");
    }
    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingStudentSetsAnId() throws Exception {
        Students testStudent = setUpStudent();
        int ogStudentId = testStudent.getId();
        studentDao.addStudent(testStudent);
        assertNotEquals(ogStudentId, testStudent.getId());
    }

    @Test
    public void getAllReturnsAllStudentsFromTheDb() throws Exception{
        Students student1 = setUpStudent();
        Students student2 = setUpStudent();
        studentDao.addStudent(student1);
        studentDao.addStudent(student2);
        assertEquals(2, studentDao.getAllStudents().size());
    }

    @Test
    public void addStudents_testIfItSavedToDB(){
        Students student = setUpStudent();
        studentDao.addStudent(student);
        assertTrue(studentDao.getAllStudents().get(1).equals(student));
    }

    @Test
    public void noStudentsReturnedIfListIsEmpty() throws Exception {
        assertEquals(0, studentDao.getAllStudents().size());
    }

    @Test
    public void deleteCorrectStudentById() throws Exception {
        Students student = setUpStudent();
        studentDao.addStudent(student);
        studentDao.deleteById(student.getId());
        assertEquals(0, studentDao.getAllStudents().size());
    }

    @Test
    public void clearAllStudentsFromLIst() throws Exception {
        Students student1 = setUpStudent();
        Students student2 = setUpStudent();
        studentDao.clearAll();
        assertEquals(0, studentDao.getAllStudents().size());
    }

    Students setUpStudent(){
        return new Students("Brooklyn");
    }
}