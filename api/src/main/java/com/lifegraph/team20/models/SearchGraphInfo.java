package com.lifegraph.team20.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

// 検索用のパッケージです。

@Data
@AllArgsConstructor
public class SearchGraphInfo {
  private String username;
  private long user_id;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
