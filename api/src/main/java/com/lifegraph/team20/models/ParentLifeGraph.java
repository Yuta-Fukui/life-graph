package com.lifegraph.team20.models;

import lombok.Data;

@Data


public class ParentLifeGraph {

    private long id;
    private long userId;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;

    public ParentLifeGraph(long id, long userId, java.sql.Timestamp createdAt, java.sql.Timestamp updatedAt) {
      this.setId(id);
      this.setUserId(userId);
      this.setCreatedAt(createdAt);
      this.setUpdatedAt(updatedAt);
    }
}

