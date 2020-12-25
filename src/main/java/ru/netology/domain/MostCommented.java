package ru.netology.domain;

import java.util.Comparator;

public class MostCommented implements Comparator<Issue> {
    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getCountComment()- o2.getCountComment();
    }
}
