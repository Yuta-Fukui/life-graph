package com.lifegraph.team20.models;

import java.sql.Timestamp;

// 検索用のパッケージです。

public class SearchGraphInfo {
	private String username;
	private int user_id;
	private Timestamp created_at;
	private Timestamp updated_at;

	public SearchGraphInfo( String username, int user_id, Timestamp created_at, Timestamp updated_at) {
		this.setName(username);
		this.setId(user_id);
		this.setCreated(created_at);
		this.setUpdated(updated_at);
	}

	public String getName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public int getId() {
		return user_id;
	}

	public void setId(int user_id) {
		this.user_id = user_id;
	}

	public Timestamp getCreated() {
		return created_at;
	}

	public void setCreated(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated() {
		return updated_at;
	}

	public void setUpdated(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

}
