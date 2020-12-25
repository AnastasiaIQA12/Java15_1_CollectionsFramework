package ru.netology.domain;

import java.util.Comparator;

public class NewestSort implements Comparator<Issue> {

    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getDateCreation() - o2.getDateCreation();
    }
}
