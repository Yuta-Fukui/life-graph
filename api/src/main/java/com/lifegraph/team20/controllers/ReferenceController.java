package com.lifegraph.team20.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifegraph.team20.models.ChildChart;
import com.lifegraph.team20.models.ParentChart;

@RestController
public class ReferenceController {

//  IDの名は後で明確にします。（林）

	@GetMapping(value = "/auth/reference")
	public ResponseEntity<List<ChildChart>> Child(
			@RequestParam("userID") int userID){
//	Optional:その値がnullかもしれないことを表現するクラス/URLが叩かれたときにこれが動く/key IDに何も入らないとhttp400エラーになるから注意
		List<ChildChart> Child = selectChilds(userID);  //子チャートをIDに定義 //selectChildsの定義をl.55へ
//			l.31のselectChildsを定義名Childで呼び出す
		return ResponseEntity.ok(Child);
	}


	@Autowired
	//MySQLのデータを持ってくるライブラリ
	private JdbcTemplate jdbcTemplate;

	public List<ChildChart> selectChilds(int userID) {
		final String sql = "select * from child_chart where parent_id=(select id from parent_chart where user_id ="+userID+")";

		return jdbcTemplate.query(sql, new RowMapper<ChildChart>() {// <ChildChart>の中にそれぞれのデータを入れている

			public ChildChart mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ChildChart(rs.getInt("id"), rs.getInt("parent_id"),
			            rs.getInt("age"), rs.getInt("score"), rs.getString("comment"));
			}
		});
	}

	public List<Map<String, Object>> uploadGraph(List<ParentChart> graphs, List<ChildChart> data) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	    Map<String, Object> map;
	    for (ParentChart graph: graphs) {
	    	map = new HashMap<>();
	    	map.put("id", graph.getId());
	    	map.put("id", data.stream()
	    			.filter(s -> s.getParent_id()==graph.getId())
	    			.collect(Collectors.toList()));
	    	dataList.add(map);
	    }
		return dataList;
	}

}
