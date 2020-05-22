package com.lifegraph.team20.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifegraph.team20.models.SearchGraphInfo;

@RestController
public class SearchController {

	@RequestMapping(value = "/auth/life-graphs", method = RequestMethod.GET)
// SearchGraphInfoから検索ページに必要な要素を引っ張ってきて、反映。 l.37はl.50に影響している。　　　likeNameを引数にしてあいまい検索を行えるようにしている。　バックだけでは引数"私"のようなものがない為、フロントと繋げる必要あり。
	public ResponseEntity<List<SearchGraphInfo>>SearchGraphInfos(@RequestParam("likeName") Optional<String>likeName,
												@RequestParam("startDame") Optional<String>startDate,
												@RequestParam("updateDate") Optional<String>updateDate){
		List<SearchGraphInfo> SearchGraphInfos = SelectSearchGraphInfo(likeName,startDate,updateDate);
		return ResponseEntity.ok(SearchGraphInfos);
	}

// 日時検索のためには、変更、編集が必要かも？
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private List<SearchGraphInfo> SelectSearchGraphInfo(Optional<String> likeName, Optional<String> startDate, Optional<String> updateDate){


// sql="";はsqlが空で指定されてしまう
		String sql = "select `username`,`user_id`,`updated_at`,`created_at` from users INNER JOIN parent_chart on users.id = parent_chart.user_id ";
		if(likeName.isPresent()) {
			sql += " WHERE username like '%"+likeName.get()+"%'";
		}
		else if(startDate.isPresent() && updateDate.isPresent()) {
			sql += "WHERE `updated_at` BETWEEN "+startDate.get()+" AND "+updateDate.get()+"";
		}
		return jdbcTemplate.query(sql, new RowMapper<SearchGraphInfo>() {
			public SearchGraphInfo mapRow(ResultSet rs, int rowNum)throws SQLException {
				return new SearchGraphInfo(rs.getString("username"), rs.getInt("user_id"), rs.getTimestamp("created_at"),rs.getTimestamp("updated_at"));
			}
		});
	}
}
