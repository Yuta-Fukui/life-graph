package com.lifegraph.team20.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class UserKeyId implements Serializable {

  @Getter
  @Setter
  private String goodsId;

  @Getter
  @Setter
  private int salesDetailNo;

}