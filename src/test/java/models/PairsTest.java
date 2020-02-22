package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PairsTest {

    @Test
    public void getIdOfPair(){
        Pairs testPair = setUpPair();
        assertEquals(1, testPair.getId());
    }

    @Test
    public void setId() {
        Pairs testPair = setUpPair();
        testPair.setId(2);
        assertEquals(2, testPair.getId());
    }

    @Test
    public void getStudent1(){
        Pairs testPair = setUpPair();
        assertEquals("Brody", testPair.getStudent1());
    }

    @Test
    public void setStudent2(){
        Pairs testPair = setUpPair();
        testPair.setStudent2("Jack");
        assertEquals("Jack", testPair.getStudent2());
    }

    Pairs setUpPair(){
        return new Pairs(1,"Brody","Brooklyn");
    }
}