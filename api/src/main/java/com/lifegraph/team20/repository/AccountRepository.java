package com.lifegraph.team20.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.lifegraph.team20.Account.Account;

@Repository
public class AccountRepository {

	private static final ZoneId ZONE_ID_UTC = ZoneId.of("UTC");
	private static final ZoneId ZONE_ID_JST = ZoneId.of("Asia/Tokyo");


	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public Account selectAccount(Integer id) {
		// 三つのテーブルくっつけてる。ユーザ名と権限名を取得するため
		final String sql = "select users.id, username, name, created_at, updated_at from users ¥n"
				+ " inner join user_roles on users.id = user_roles.user_id\n"
				+ " inner join roles on roles.id = user_roles.role_id where users.id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Account result = jdbcTemplate.queryForObject(sql, param, new RowMapper<Account>() {
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Account(rs.getInt("id"), rs.getString("username"), rs.getString("name"),
		            toLocalDateTime(rs.getString("created_at")), toLocalDateTime(rs.getString("updated_at")));
			}
		});
		return result;
	}
	private LocalDateTime toLocalDateTime(String strTimestamp) {
	    if (StringUtils.isEmpty(strTimestamp)) {
	      return null;
	    }
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sdf.setTimeZone(TimeZone.getTimeZone(ZONE_ID_UTC));
	    Date formatDate = null;
	    try {
	      formatDate = sdf.parse(strTimestamp);
	    } catch (ParseException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    LocalDateTime def = LocalDateTime.ofInstant(formatDate.toInstant(), ZONE_ID_UTC);
	    ZonedDateTime jst = def.atZone(ZONE_ID_UTC).withZoneSameInstant(ZONE_ID_JST);
	    return jst.toOffsetDateTime().toLocalDateTime();
	  }
}