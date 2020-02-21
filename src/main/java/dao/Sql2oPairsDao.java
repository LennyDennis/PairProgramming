package dao;
import models.Students;
import org.sql2o.Sql2o;
import models.Pairs;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oPairsDao implements PairsDao {
    private final Sql2o sql2o;
    public Sql2oPairsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

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
}