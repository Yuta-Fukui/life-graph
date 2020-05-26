package com.lifegraph.team20.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildChart {
// フィールド（クラス直下の属性郡）
  private long id;
  private long parent_id;
  private int age;
  private int score;
  private String comment;

}
