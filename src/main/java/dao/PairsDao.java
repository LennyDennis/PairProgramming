package dao;

import models.Pairs;
import models.Students;

import java.util.List;

public interface PairsDao {
    //create
    void addPairs(Pairs newPairs);



    //
    List<Pairs> getAllPairs();
    List<Pairs> getStudent1();
    List<Pairs> getStudent2();
    List<Students> getAllStudentsNames();
    List<Object> getCreatedPairs();
}
