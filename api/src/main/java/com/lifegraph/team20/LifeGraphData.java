package com.lifegraph.team20;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

//HTTPリクエストを受け取るためのクラスここに情報の定義が集まっている
@Data
public class LifeGraphData {

  private long id;

  private long parentId;

  @NotNull
  private long userId;

  @NotNull
  @Max(100)
  @Min(0)
  private int age;

  @NotNull
  @Max(100)
  @Min(-100)
  private int score;


  @Size(max = 100)
  private String comment;
}
