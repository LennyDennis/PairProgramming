package models;

import dao.Sql2oStudentsDao;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class StudentsTest {

    private static Sql2oStudentsDao studentDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/paired";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "access");

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

    Students testStudent = new Students("Pair");

    @Test
    public void getName_returnsStudentNameCorrectly(){

        assertEquals("Pair", testStudent.getName());
    }

    @Test
    public void setName_setsUpNameCorrectly(){
        testStudent.setName("Pair");
        assertEquals("Pair", testStudent.getName());
    }

}