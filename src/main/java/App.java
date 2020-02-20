import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/paired";
        Sql2o sql2o = new Sql2o(connectionString, "lenny", " ");

        Map<String, Object> model = new HashMap<String, Object>();

        get("/", (req, res) -> {
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pairs", (req, res) -> {
            return new ModelAndView(model, "paired.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
