package models;

import org.junit.*;
import static org.junit.Assert.*;

public class StudentsTest {
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