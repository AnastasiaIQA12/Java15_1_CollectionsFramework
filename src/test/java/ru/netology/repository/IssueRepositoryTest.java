package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.domain.Label;
import ru.netology.sort.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {

    private IssueRepository repository = new IssueRepository();
    private Author author1 = new Author(1,"Ivan", "url:\\1");
    private Author author2 = new Author(2,"Sveta", "url:\\2");
    private Author author3 = new Author(3,"Kolia", "url:\\3");
    private Set<Author> assignees=new HashSet<Author>();
    private Label label1 = new Label(1,"lightGreen", "component", "Kotlin");
    private Label label2 = new Label(2,"Green", "component", "Jupiter");
    private Label label3 = new Label(3,"lightGreen", "component", "OTA");
    private Set<Label> labels = new HashSet<>();
    private Issue issue1 = new Issue(1, "Issue", true, "15.12.2020", "16.12.2020",author1, labels, "Java8", "5.8M1", assignees, 5);
    private Issue issue2 = new Issue(2, "Issue", false, "29.08.2020", "27.12.2020", author2, labels, "Java8", "5.8M1", assignees, 3);
    private Issue issue3 = new Issue(3, "Issue", true, "15.10.2020", "27.10.2020", author3, labels, "Java8", "5.8M1", assignees, 7);

    @Nested
    class MultipleIssue {
        @BeforeEach
        public void setUp() {
            labels.add(label1);
            labels.add(label2);
            assignees.add(author2);
            repository.add(issue1);
            repository.add(issue2);
            repository.add(issue3);
        }

        @Test
        void shouldOutputListAllOpenIssue() {
            List<Issue> actual = repository.findOpen(repository.getAll());
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldOutputListAllCloseIssue() {
            List<Issue> actual = repository.findClose(repository.getAll());
            List<Issue> expected=new ArrayList<>();
            expected.add(issue2);
            assertEquals(expected, actual);
        }

        @Test
        void shouldOpenIssue() {
            repository.openById(repository.getAll(), 2);
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            expected.add(new Issue(2, "Issue", true, "29.08.2020", "27.12.2020", author2, labels, "Java8", "5.8M1", assignees, 3));
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldCloseIssue() {
            repository.closeById(repository.getAll(), 1);
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(new Issue(1, "Issue", false, "15.12.2020", "16.12.2020",author1, labels, "Java8", "5.8M1", assignees, 5));
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortMostComment() {
            Collections.sort(repository.getAll(), new MostCommented());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue3);
            expected.add(issue1);
            expected.add(issue2);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortLeastComment() {
            Collections.sort(repository.getAll(), new LeastCommented());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue2);
            expected.add(issue1);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateCreationNew() {
            Collections.sort(repository.getAll(),new NewestSort());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            expected.add(issue3);
            expected.add(issue2);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateCreationOld() {
            Collections.sort(repository.getAll(),new OldesSort());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue2);
            expected.add(issue3);
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateUpdateNew() {
            Collections.sort(repository.getAll(),new RecentlyUpdated());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue2);
            expected.add(issue1);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateUpdateOld() {
            Collections.sort(repository.getAll(),new LeastRecentlyUpdate());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue3);
            expected.add(issue1);
            expected.add(issue2);
            assertEquals(expected, actual);
        }

    }

    @Nested
    class Empty {
        @Test
        void shouldOutputListAllOpenIssue() {
            List<Issue> actual=repository.findOpen(repository.getAll());
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldOutputListAllCloseIssue() {
            List<Issue> actual=repository.findClose(repository.getAll());
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldOpenIssue() {
            repository.openById(repository.getAll(), 2);
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldCloseIssue() {
            repository.closeById(repository.getAll(), 1);
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortMostComment() {
            Collections.sort(repository.getAll(), new MostCommented());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortLeastComment() {
            Collections.sort(repository.getAll(), new LeastCommented());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateCreationNew() {
            Collections.sort(repository.getAll(),new NewestSort());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateCreationOld() {
            Collections.sort(repository.getAll(),new OldesSort());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateUpdateNew() {
            Collections.sort(repository.getAll(),new RecentlyUpdated());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateUpdateOld() {
            Collections.sort(repository.getAll(),new LeastRecentlyUpdate());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class SingleIssue {
        @BeforeEach
        public void setUp() {
            repository.add(issue1);
        }

        @Test
        void shouldOutputListAllOpenIssue() {
            List<Issue> actual = repository.findOpen(repository.getAll());
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldOutputListAllCloseIssue() {
            List<Issue> actual=repository.findClose(repository.getAll());
            List<Issue> expected=new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldOpenIssue() {
            repository.openById(repository.getAll(), 1);
            List<Issue> actual=repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(new Issue(1, "Issue", true, "15.12.2020", "16.12.2020", author1, labels, "Java8", "5.8M1", assignees, 5));
            assertEquals(expected, actual);
        }

        @Test
        void shouldCloseIssue() {
            repository.closeById(repository.getAll(), 1);
            List<Issue> actual=repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(new Issue(1, "Issue", false, "15.12.2020", "16.12.2020", author1, labels, "Java8", "5.8M1", assignees, 5));
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortMostComment() {
            Collections.sort(repository.getAll(), new MostCommented());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortLeastComment() {
            Collections.sort(repository.getAll(), new LeastCommented());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateCreationNew() {
            Collections.sort(repository.getAll(),new NewestSort());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateCreationOld() {
            Collections.sort(repository.getAll(),new OldesSort());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateUpdateNew() {
            Collections.sort(repository.getAll(),new RecentlyUpdated());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldSortDateUpdateOld() {
            Collections.sort(repository.getAll(),new LeastRecentlyUpdate());
            List<Issue> actual= repository.getAll();
            List<Issue> expected=new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }
    }
}