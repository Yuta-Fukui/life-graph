package com.lifegraph.team20.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class LifeGraphRepository {

  // データベースと接続する
    @Autowired

    // MySQLのデータを持ってくるライブラリ
    JdbcTemplate jdbcTemplate;

    // ユーザーIdと年齢のチェック
    public Boolean existsByUserIdAndAge(long parentId, int age) {
      final String sql = "select count(( parent_id = " + parentId + " and age = " + age + "  ) or null) from child_chart";
      Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
      return 1 <= count;
    }

    // ageが重複しているか確認したい
    // リクエストできたageが同じユーザーのレコードに既に存在しているか
    public Integer selectChild(long id) {
      final String sql = "select count(*) from child_chart where user_id = " + id ;
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
    public void deleteChild(long id) {
      jdbcTemplate.update("delete from child_chart where id = " + id);
    }

    // 更新日時を更新する
    public void updateNowTime(long userId) {
     jdbcTemplate.update("update parent_chart set updated_at = now() where user_id =" + userId);
    }

    public Boolean existsByUserId(long userId) {
        final String sql = "select count(( user_id = " + userId + ") or null) from parent_chart";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return 1 <= count;
    }

}



