package dao;

import models.Pairs;

import java.util.List;

public interface PairsDao {
    //create
    void addPairs(Pairs newPairs);



    //
    List<Pairs> getAllPairs();
    List<Pairs> getStudent1();
    List<Pairs> getStudent2();

}
