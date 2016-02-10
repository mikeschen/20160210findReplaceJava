import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

import org.apache.commons.lang.StringUtils;

public class FindReplace {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/main.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");
      String userString = request.queryParams("userInput");
      String searchWord = request.queryParams("searchWord");
      String replaceWord = request.queryParams("replaceWord");

      String results = FindReplace.replaceWord(userString, searchWord, replaceWord);

      model.put("results", results);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String replaceWord(String userString, String searchWord, String replaceWord) {

    String[] words = userString.split("([.,!?:;'\"-]|\\s)+");
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() == searchWord.length()) {
        words[i] = words[i].replace(searchWord, replaceWord);
      }
    }
    return StringUtils.join(words, " ");
  }

}
