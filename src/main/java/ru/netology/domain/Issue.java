package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issue {
  private int id;
  private String title;
  private boolean status;//status=true-открыт, status=false-закрыт
  private int dateCreation;
  private int dateUpdate;
  private Author author;
  private Set<Label> label;
  private String project;
  private String milestone;
  private Set<Author> assignee;
  private int countComment;

}
