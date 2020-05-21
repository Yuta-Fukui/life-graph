package com.lifegraph.team20.models;

import lombok.Data;

@Data
public class LifeGraph {

    private long id;
    private long parentId;
    private int age;
    private int score;
    private String comment;

    public LifeGraph(long id, long parentId, int age, int score, String comment) {
      this.setId(id);
      this.setParentId(parentId);
      this.setAge(age);
      this.setScore(score);
      this.setComment(comment);
    }

}
