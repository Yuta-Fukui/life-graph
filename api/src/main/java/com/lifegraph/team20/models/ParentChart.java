package com.lifegraph.team20.models;

public class ParentChart {
// コメントアウトしている部分は、人生グラフ参照に必要なかった為消しています。　他で使わないのであれば、文自体削除OK

// フィールド（クラス直下の属性郡）
  private int id;
//  private int user_id;
//  private String created_at;
//  private String updated_at;
// コンストラクタ（インスタンス化と同時にクラスに値を投げる。）
  public ParentChart(int id/** int user_id, String created_at, String updated_at*/) {

    this.id = id;
//    this.user_id = user_id;
//    this.created_at = created_at;
//    this.updated_at = updated_at;
    // this.でインスタンスに値を渡す。
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
/**
  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }
  */
}
