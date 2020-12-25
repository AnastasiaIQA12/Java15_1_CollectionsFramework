package ru.netology.domain;

import java.util.Comparator;

public class LeastCommented implements Comparator<Issue> {
    @Override
    public int compare(Issue o1, Issue o2) {
        return o2.getCountComment()- o1.getCountComment();
    }
}
