package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issue {
  private int id;
  private String title;
  private boolean status;//status=true-открыт, status=false-закрыт
  private int dateCreation;
  private Author author;
  private Label label;
  private String project;
  private String milestone;
  private Author assignee;
  private int countComment;

}
