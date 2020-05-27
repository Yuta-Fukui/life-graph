package com.lifegraph.team20.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.lifegraph.team20.Account.Account;
import com.lifegraph.team20.utils.DateUtil;

@Repository
public class AccountRepository {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  public Account selectAccount(Integer id) {
    // 三つのテーブルくっつけてる。ユーザ名と権限名を取得するため
    final String sql = "select u.id, u.username, r.name, p.created_at, p.updated_at from users u\n"
        + "inner join user_roles ur on u.id = ur.user_id\n" + "inner join roles r on r.id = ur.role_id\n"
        + "left outer join parent_chart p on p.user_id = u.id where u.id = :id;";
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
    Account result = jdbcTemplate.queryForObject(sql, param, new RowMapper<Account>() {
      public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(rs.getInt("id"), rs.getString("username"), rs.getString("name"),
            DateUtil.toJSTLocalDateTime(rs.getString("created_at")),
            DateUtil.toJSTLocalDateTime(rs.getString("updated_at")));
      }
    });
    return result;
  }
}