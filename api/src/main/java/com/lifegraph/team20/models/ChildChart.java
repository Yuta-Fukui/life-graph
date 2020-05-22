package com.lifegraph.team20.models;

public class ChildChart {
// フィールド（クラス直下の属性郡）
  private int id;
  private int parent_id;
  private int score;
  private int age;
  private String comment;

// コンストラクタ（インスタンス化と同時にクラスに値を投げる。）
  public ChildChart(int id, int parent_id, int score, int age, String comment) {

    this.id = id;
    this.parent_id = parent_id;
    this.age = age;
    this.score = score;
    this.comment = comment;
    // this.でインスタンスに値を渡す。

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getParent_id() {
    return parent_id;
  }

  public void setParent_id(int parent_id) {
    this.parent_id = parent_id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
  public int getAge() {
	    return age;
	  }

	  public void setAge(int age) {
	    this.age = age;
	  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
