package com.lifegraph.team20.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
//
@Entity
@Table( name = "Child_Chart",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "parent_id"),
		@UniqueConstraint(columnNames = "age")
	})

public class LifeGraph {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@NotBlank
	@Column(name = "parent_id")
	private long parent_id;

	@NotBlank
	@Column(name = "age")
	private int age;

	@NotBlank
	@Column(name = "score")
	private int score;

	// defalut nullも書く？？
//	@Column(name = "title")
//	private String title;

	// defalut nullも書く？？
	@Column(name = "comment")
	private String comment;

	// 親チャートとくっつける
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "parent_id", referencedColumnName = "id", insertable=false, updatable=false)
	private ParentLifeGraph parent;


	// 初期化
//	public LifeGraph (long parent_id,int age,int score,String title,String comment) {
//		this.parent_id = parent_id; // 親chartのentityから取得する
//		this.age = age;
//		this.title = title;
//		this.comment = comment;
//	}

}
