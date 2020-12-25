package ru.netology.domain;

import java.util.Comparator;

public class OldesSort implements Comparator<Issue> {

    @Override
    public int compare(Issue o1, Issue o2) {
        return o2.getDateCreation()- o1.getDateCreation();
    }
}
