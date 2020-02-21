package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals("Brooklyn", testStudent.getStudentName());
    }
    @Test
    public void setsNewStudentNameCorrectly() throws Exception {
        Students testStudent = setUpStudent();
        testStudent.setStudentName("Hudson");
        assertEquals("Hudson", testStudent.getStudentName());
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