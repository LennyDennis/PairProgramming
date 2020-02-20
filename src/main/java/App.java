import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Map<String, Object> model = new HashMap<String, Object>();

        get("/", (req, res) -> {
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pairs", (req, res) -> {
            return new ModelAndView(model, "paired.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
