package dao;
import models.Students;
import org.sql2o.Sql2o;
import models.Pairs;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

import java.util.ArrayList;
import java.util.List;

public class Sql2oPairsDao implements PairsDao {
    private final Sql2o sql2o;
    public Sql2oPairsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    List<Students> allStudentsNames = new ArrayList<>();

    @Override
    public void addPairs(Pairs newPairs) {

        String sql = "INSERT INTO pairs (id,student1,student2) VALUES (:id,:student1,:student2)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("student1", newPairs.getStudent1())
                    .addParameter("student2", newPairs.getStudent2())
                    .executeUpdate()
                    .getKey();

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Pairs> getAllPairs() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Pairs")
                    .executeAndFetch(Pairs.class);
        }
    }

    @Override
    public List<Pairs> getStudent1() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Pairs")
                    .executeAndFetch(Pairs.class);
        }
    }

    @Override
    public List<Pairs> getStudent2() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Pairs")
                    .executeAndFetch(Pairs.class);
        }
    }

    @Override
    public List<Students> getAllStudentsNames(){
        try(Connection con = sql2o.open()){
            String sqlStudentsNames = "SELECT name FROM students";
            List<Students> students = con.createQuery(sqlStudentsNames)
                    .executeAndFetch(Students.class);
            allStudentsNames.addAll(students);
        }
        return allStudentsNames;
    }

    @Override
    public List<Object> getCreatedPairs(){
        List<Students> initialNames = getAllStudentsNames();


        ArrayList shuffledList = new ArrayList<>();
        if(initialNames.size() % 2 != 0){
            Students lastName = initialNames.get(0);
            initialNames.remove(0);
            for(Students name : initialNames){
                shuffledList.add(name);
            }
        }
        else{
            for(Students name : initialNames){
                shuffledList.add(name);
            }
        }

        ArrayList halfOfFirst = new ArrayList<>();

        System.out.println("Names without first name :"+shuffledList);

        Collections.shuffle(shuffledList);
        System.out.println("Shuffled list :"+ shuffledList);
        for(int i = 0; i < (shuffledList.size() / 2 ); i++){
            System.out.println(shuffledList.get(i));
            halfOfFirst.add(shuffledList.get(i));
        }

        System.out.println("First half :"+halfOfFirst);


        ArrayList halfOfSecond = new ArrayList<>();

        Collections.reverse(shuffledList);

        System.out.println("Here is the reversed and shuffled:"+shuffledList);
        for(int i = 0; i < shuffledList.size()/2; i++){
            halfOfSecond.add(shuffledList.get(i));
        }

        System.out.println("Half Of Second :"+halfOfSecond);

        ArrayList finalArray = new ArrayList<>();

        for(int i=0; i < halfOfFirst.size(); i++){
            finalArray.add(halfOfFirst.get(i));
            finalArray.add(halfOfSecond.get(i));
        }

        System.out.println(finalArray);



        for(int i=0; i < finalArray.size(); i+=2){
            System.out.println("Pair :" +finalArray.get(i)+" & "+ finalArray.get(i+1));

        }
        if(initialNames.size() % 2 != 0){
            System.out.println(initialNames.get(0) + " joins final Pair.");
            finalArray.add(initialNames.get(0));
        }

        Collections.shuffle(finalArray);

        return finalArray;

    }




    public void clearAll() {
        String sql ="DELETE FROM students *";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}