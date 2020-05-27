package com.lifegraph.team20.Account;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Account {

  @Id
  @GeneratedValue
  // usersテーブルのid
  private int id;

  @NotBlank
  // usersテーブルのusername
  private String username;

  @NotBlank
  // rolesテーブルのname
  private String name;

  private LocalDateTime created_at;

  private LocalDateTime updated_at;

}