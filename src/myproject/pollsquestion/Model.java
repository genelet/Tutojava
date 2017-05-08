package myproject.pollsquestion;

import myproject.MyprojectModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Model extends MyprojectModel {
public Model() {
    List<String> adds = Arrays.asList("question_text");
    insert_pars = new ArrayList<>(adds);
    update_pars = new ArrayList<>(adds);
    update_pars.add("id");
    topics_pars = new ArrayList<>(adds);
    topics_pars.add("id");
    edit_pars = new ArrayList<>(adds);
    edit_pars.add("id");
    current_table  = "polls_question";
    current_key    = "id";
    current_id_auto= "id";
}

   public Error dashboard(List<Map<String,Object>> extras) throws SQLException, Exception {
       return topics(extras);
   }

}