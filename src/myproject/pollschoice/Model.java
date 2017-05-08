package myproject.pollschoice;

import myproject.MyprojectModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Model extends MyprojectModel {
  public Model() {
    List<String> adds = Arrays.asList("question_id","choice_text","votes");
    insert_pars = new ArrayList<>(adds);
    update_pars = new ArrayList<>(adds);
    update_pars.add("id");
    topics_pars = new ArrayList<>(adds);
    topics_pars.add("id");
    edit_pars = new ArrayList<>(adds);
    edit_pars.add("id");
    current_table  = "polls_choice";
    current_key    = "id";
    current_id_auto= "id";
  }

  public Error dashboard(List<Map<String,Object>> extras) throws SQLException, Exception {
    return topics(extras);
  }

  @Override
  public Error update(List<Map<String,Object>> extras) throws SQLException, Exception  {    
    String role = (String) ARGS.get("g_role");
    if ("admin".equals(role)) {
      return super.update(extras);
    }
    return this.do_sql("UPDATE polls_choice SET votes=votes+1 WHERE id=?", new Object[]{ ARGS.get("id") });
  }

  @Override
  public Error topics(List<Map<String,Object>> extras) throws SQLException, Exception  {    
    String role = (String) ARGS.get("g_role");
    if ("admin".equals(role)) {
      return super.topics(extras);
    }
    LISTS = new ArrayList<>();
    return this.select_sql(LISTS, "SELECT * FROM polls_choice WHERE question_id=?", new Object[]{ ARGS.get("question_id") });
  }
}