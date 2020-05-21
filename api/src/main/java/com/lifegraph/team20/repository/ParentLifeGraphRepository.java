package com.lifegraph.team20.repository;

import java.util.ArrayList;
import java.util.HashMap;
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
public class ParentLifeGraphRepository  {

    @Autowired
    // MySQLのデータを持ってくるライブラリ
    private JdbcTemplate jdbcTemplate;

    // user_idが存在するかを確認したい
    // リクエストを送った人のuser_idのレコードをDBから取得する

    /**
     * 親グラフをユーザーIDを元に検索する ※ユーザーIDはユニークキー
     *
     * @param userId ユーザーID
     * @return 親グラフ
     */
    public Optional<ParentLifeGraph> findByUserId(long userId) {
      final String sql = "select * from parent_chart where user_id = " + userId;
      RowMapper<ParentLifeGraph> mapper = new BeanPropertyRowMapper<ParentLifeGraph>(ParentLifeGraph.class);
      ArrayList<ParentLifeGraph> parentLifeGraphs = (ArrayList<ParentLifeGraph>) jdbcTemplate.query(sql, mapper);
//      List<ParentLifeGraph> parentLifeGraphs = jdbcTemplate.queryForList(sql, ParentLifeGraph.class);
      return CollectionUtils.isEmpty(parentLifeGraphs) ? Optional.empty() : Optional.of(parentLifeGraphs.get(0));
    }

    // Idがあるかどうか確認する
    public Boolean existsByUserId(long userId) {
      final String sql = "select count(*) from parent_chart where user_id = " + userId;
      Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
      return 1 <= count;
    }

    // userIdがあるレコードのIdを取得する
    public long insert(long userId) {
      SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
      jdbcInsert.withTableName("parent_chart").usingGeneratedKeyColumns("id");
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("user_id", userId);
      // execute insert
      Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
      // convert Number to Int using ((Number) key).intValue()
      return key.longValue();
    }

}
