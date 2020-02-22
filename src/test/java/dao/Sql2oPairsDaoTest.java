package dao;

import models.Students;
import models.Pairs;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class Sql2oPairsDaoTest {
    private static Connection conn;
    private static Sql2oPairsDao pairsDao;
    private static Sql2oStudentsDao studentsDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/paired_test";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        pairsDao = new Sql2oPairsDao(sql2o);
        studentsDao = new Sql2oStudentsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        pairsDao.clearAll();
        studentsDao.clearAll();
    }


    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
    }

    @Test
    public void getAllStudentsNamesCorrectly(){
        Students student = new Students("Nelly");
        studentsDao.addStudent(student);
        assertEquals(1, pairsDao.getAllStudentsNames().size());
    }

    @Test
    public void getCreatedPairsReturnsCorrectly(){
        Students firstTestStudent = new Students("Nelly");
        studentsDao.addStudent(firstTestStudent);
        Students secondTestStudent = new Students("Calvin");
        studentsDao.addStudent(secondTestStudent);

        assertEquals(2, pairsDao.getCreatedPairs().size());
    }
    public void addingPairSetsAnId() throws Exception {
        Pairs pair1 = setUpPair();
        int ogPairId = pair1.getId();
        assertNotEquals(ogPairId, pair1.getId());
    }

    @Test
    public void addPair_testIfSavedToDb() throws Exception {
        Pairs pair1 = setUpPair();
        assertTrue(pairsDao.getAllPairs().get(0).equals(pair1));
    }

    @Test
    public void getAll_ReturnsAllPairsFromDb() throws Exception {
        Pairs pair1 = setUpPair();
        Pairs pair2 = setUpPair();
        assertEquals(2, pairsDao.getAllPairs().size());
    }

    @Test
    public void noStudentsReturnedIfListIsEmpty() throws Exception {
        assertEquals(0, pairsDao.getAllPairs().size());
    }

    @Test
    public void clearAllPairsFromDb() throws Exception {
        Pairs pair1 = setUpPair();
        Pairs pair2 = setUpPair();
       pairsDao.clearAll();
        assertEquals(2, pairsDao.getAllPairs().size());
    }

    Pairs setUpPair(){
        Pairs pair = new Pairs(1, "Brody","Brooklyn");
        pairsDao.addPairs(pair);
        return pair;
    }
}