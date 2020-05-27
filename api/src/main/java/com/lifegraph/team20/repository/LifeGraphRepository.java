package com.lifegraph.team20.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.lifegraph.team20.models.ParentLifeGraph;



@Repository
public class LifeGraphRepository {

  // データベースと接続する
    @Autowired

    // MySQLのデータを持ってくるライブラリ
   private JdbcTemplate jdbcTemplate;

//    // ユーザーIdと年齢のチェック
//    public Boolean existsByUserIdAndAge(long parentId, int age) {
//      final String sql = "select COUNT(*)from child_chart where parent_id = " + parentId + " and age = " + age;
//      Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
//      return 1 <= count;
//    }

    public Boolean existsById(long id) {
      final String sql = "select COUNT(*)from child_chart where id = " + id;
      Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
      return 1 <= count;
    }

    // ageが重複しているか確認したい
    // リクエストできたageが同じユーザーのレコードに既に存在しているか
    public Integer selectData(long id) {
      final String sql = "select count (*) from child_chart where user_id = " + id ;
      Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
      return count;
    }

    // 子テーブルのレコードを編集する
      public void updateChild(long id, int age, int score, String comment) {
        String sql = "update child_chart set age = " + age + " , score = " + score + " , comment = '" + comment + "' where id = " + id;
        jdbcTemplate.update(sql);
      }

    // 子テーブルにレコードを追加する
    public void addChild(long parentId, int age, int score, String comment) {
      jdbcTemplate.update("insert into child_chart (parent_id, age, score, comment) values (" + parentId + "," + age + ","
          + score +  ",'" + comment + "')");
    }

    // // 親子テーブルのデータを削除する
    // public void deleteLifeGraph(long userId, long parentId) {
    //     jdbcTemplate.update("delete from parent_chart where user_id = " + userId + " and id = " + parentId);
    // }

    // 子テーブルのデータを削除する
    public void deleteChild(long Id) {
      jdbcTemplate.update("delete from child_chart where id = " + Id);
    }

    // 更新日時を更新する
    public void updateNowTime(long userId) {
     jdbcTemplate.update("update parent_chart set updated_at = now() where user_id = " + userId);
    }

  //   public List<ChildChart> selectChilds(long userId) {
	// 	final String sql = "select * from child_chart where parent_id=(select id from parent_chart where user_id ="+ userId +") order by age asc ";
	// 	return jdbcTemplate.query(sql, new RowMapper<ChildChart>() {// <ChildChart>の中にそれぞれのデータを入れている
	// 		public ChildChart mapRow(ResultSet rs, int rowNum) throws SQLException {
	// 			return new ChildChart(rs.getLong("id"), rs.getLong("parent_id"),
	// 		            rs.getInt("age"), rs.getInt("score"), rs.getString("comment"));
	// 		}
	// 	});
	//

 // user_idが存在するかを確認したい
    // リクエストを送った人のuser_idのレコードをDBから取得する

    /**
     * 親グラフをユーザーIDを元に検索する ※ユーザーIDはユニークキー
     *
     * @param userId ユーザーIDLi
     * @return 親グラフ
     */
    public Optional<ParentLifeGraph> findByUserId(long userId) {
      final String sql = "select * from parent_chart where user_id = " + userId;
      RowMapper<ParentLifeGraph> mapper = new BeanPropertyRowMapper<ParentLifeGraph>(ParentLifeGraph.class);
      List<ParentLifeGraph> parentLifeGraphs = jdbcTemplate.query(sql, mapper);
      return CollectionUtils.isEmpty(parentLifeGraphs) ? Optional.empty() : Optional.of(parentLifeGraphs.get(0));
    }

    // // Idがあるかどうか確認する
    // public Boolean existsByUserId(long userId) {
    //   final String sql = "select count(*) from parent_chart where user_id = " + userId;
    //   Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
    //   return 1 <= count;
    // }

    // userIdがあるレコードのIdを取得する
    public long insert(long userId) {
      SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
      jdbcInsert.withTableName("parent_chart").usingGeneratedKeyColumns("id");
      Map<String, Object> parameters = new HashMap<>();
      Date date = new Date();
      parameters.put("user_id", userId);
      parameters.put("created_at", date);
      parameters.put("updated_at", date);
      // execute insert
      Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
      // convert Number to Int using ((Number) key).intValue()
      return key.longValue();
    }

//    public ChildChart record(long parentId, int age) {
//        String sql = "select * from child_chart where parent_id = " + parentId + " and age = " + age;
//        RowMapper<ChildChart> mapper = new BeanPropertyRowMapper<ChildChart>(ChildChart.class);
//        ArrayList<ChildChart> LifeGraphs = (ArrayList<ChildChart>) jdbcTemplate.query(sql, mapper);
//        return LifeGraphs.get(0);
//      }


}



