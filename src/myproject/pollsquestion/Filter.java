package myproject.pollsquestion;

import myproject.MyprojectFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Filter extends MyprojectFilter {
   public Filter() {
    this.setActions(new HashMap<String, Map<String,List<String>>>(){
        {
            put("startnew", new HashMap<String, List<String>>(){
                {
                    put("options", Arrays.asList("no_db", "no_method"));
                    put("groups", Arrays.asList("public"));
                }
            });
            put("insert", new HashMap<String, List<String>>(){
                {
                    put("validate", Arrays.asList("question_text"));
                 }
             });
            put("edit", new HashMap<String, List<String>>(){
                {
                    put("validate", Arrays.asList("id"));
                }
             });
            put("update", new HashMap<String, List<String>>(){
                {
                    put("validate", Arrays.asList("id"));
                 }
             });
            put("delete", new HashMap<String, List<String>>(){
                {
                    put("validate", Arrays.asList("id"));
                }
           });
            put("topics", new HashMap<String, List<String>>() {
                {
                    put("groups",Arrays.asList("public"));
                }
            });
            put("dashboard", new HashMap<String, List<String>>() {
                {
                    put("groups",Arrays.asList("public"));
                }
            });
        }
    });

    this.setFks(new HashMap<>());
   }

}