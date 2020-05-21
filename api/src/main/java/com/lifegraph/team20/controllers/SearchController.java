package com.lifegraph.team20.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifegraph.team20.models.SearchGraphInfo;

@RestController
public class SearchController {
/**
 *  LikeNameであいまい検索ができるよう設定
 * 現在は、仮設定中
 * static final String で中の文字が含まれるデータが全て引っ張ってこられる。
 *　スラッシュでコメントアウトしているコードはバックで特定の引数をSQLから引っ張るようのAPIテスト用のコードなので無視
 */
//	private static final String LikeName = "私";
//	private static final String StartDate = "";
//	private static final String UpdateDate = "";

	@RequestMapping(value = "/auth/search", method = RequestMethod.GET)
// SearchGraphInfoから検索ページに必要な要素を引っ張ってきて、反映。 l.33はl.50に影響している。　　　like_nameを引数にしてあいまい検索を行えるようにしている。　バックだけでは引数"私"のようなものがない為、フロントと繋げる必要あり。
	public List<SearchGraphInfo>SearchGraphInfo(@RequestParam("LikeName") Optional<String>like_name,
												@RequestParam("StartDate") Optional<Timestamp>start_date,
												@RequestParam("UpdateDate") Optional<Timestamp>update_date){
		List<SearchGraphInfo> SearchGraphInfos = SelectSearchGraphInfo(like_name,start_date,update_date);
		return SearchGraphInfos;
	}
//	public List<SearchGraphInfo>SearchGraphInfo(){
//			List<SearchGraphInfo> SearchGraphInfos = SelectSearchGraphInfo();
//			return SearchGraphInfos;
//	}
// 日時検索のためには、変更、編集が必要かも？
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private List<SearchGraphInfo> SelectSearchGraphInfo(Optional<String> like_name, Optional<Timestamp> start_date, Optional<Timestamp> update_date){
		String sql="";
		if(like_name != null) {
			//　l.50でsql内``で囲っているデータをAPIで引っ張ってくる
			final String sqlName = "select `username`, `user_id`, parent_chart. `created_at`, parent_chart. `updated_at` from users INNER JOIN parent_chart on users.id = parent_chart.user_id where username like '%"+like_name+"%'";
			sql=sqlName;
//　betweenで範囲指定しているが、「初回登録と更新日時では変な範囲になるのでは？」という疑問が有り。　今と更新日の範囲指定が必要なのかな？　わからん。。。
		}else if(start_date != null && update_date != null) {
			final String sqlDate = "select `username`, `user_id`, parent_chart. `created_at`, parent_chart. `updated_at` from users INNER JOIN parent_chart on users.id = parent_chart.user_id where `created_at` between'"+start_date+"' AND '"+update_date+"'";
			sql=sqlDate;
		}
//		private List<SearchGraphInfo> SelectSearchGraphInfo(){
//		String sql="";
//		if(LikeName != "") {
//			final String sqlName = "select `username`, `user_id`, parent_chart. `created_at`, parent_chart. `updated_at` from users INNER JOIN parent_chart on users.id = parent_chart.user_id where username like '%"+LikeName+"%'";
//			sql=sqlName;
//	}else if( StartDate != "" && UpdateDate != "") {
//		final String sqlDate = "select `username`, `user_id`, parent_chart. `created_at`, parent_chart. `updated_at` from users INNER JOIN parent_chart on users.id = parent_chart.user_id where `created_at` between'"+StartDate+"' AND '"+UpdateDate+"'";
//		sql=sqlDate;
//	}
//
		return jdbcTemplate.query(sql, new RowMapper<SearchGraphInfo>() {
			public SearchGraphInfo mapRow(ResultSet rs, int rowNum)throws SQLException {
				return new SearchGraphInfo(rs.getString("username"), rs.getInt("user_id"), rs.getTimestamp("created_at"),rs.getTimestamp("updated_at"));
			}
		});
	}
}
