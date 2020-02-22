package models;

import org.junit.*;
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
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesStudentNameCorrectly() throws Exception {
        Students testStudent = setUpStudent();
        assertEquals("Brooklyn", testStudent.getName());
    }
    @Test
    public void setsNewStudentNameCorrectly() throws Exception {
        Students testStudent = setUpStudent();
        testStudent.setName("Hudson");
        assertEquals("Hudson", testStudent.getName());
    }
    @Test
    public void setId() {
        Students testStudent = setUpStudent();
        testStudent.setId(5);
        assertEquals(5, testStudent.getId());
    }

    Students setUpStudent(){
        return new Students("Brooklyn");
    }
}