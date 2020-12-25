package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

import java.util.Collections;
import java.util.List;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    private Author author1 = new Author("Ivan", "url:\\1");
    private Author author2 = new Author("Sveta", "url:\\2");
    private Author author3 = new Author("Kolia", "url:\\3");
    private Label label1 = new Label("lightGreen", "component", "Kotlin");
    private Label label2 = new Label("Green", "component", "Jupiter");
    private Label label3 = new Label("lightGreen", "component", "OTA");
    private Issue issue1 = new Issue(1, "Issue", true, 15122020, author1, label1, "Java8", "5.8M1", author2, 5);
    private Issue issue2 = new Issue(2, "Issue", false, 15102020, author2, label2, "Java8", "5.8M1", author2, 3);
    private Issue issue3 = new Issue(3, "Issue", true, 15082020, author3, label3, "Java8", "5.8M1", author2, 7);

    @Nested
    class Empty {
        @Test
        void shouldAddIssue() {
            repository.getAll();
        }

        @Test
        void shouldOutputListAllOpenIssue() {
            repository.findOpen(repository.getAll());
        }

        @Test
        void shouldOutputListAllCloseIssue() {
            repository.findClose(repository.getAll());
        }

        @Test
        void shouldOpenIssue() {
            repository.openById(repository.getAll(), 2);
        }

        @Test
        void shouldCloseIssue() {
            repository.closeById(repository.getAll(), 1);
        }

        @Test
        void shouldSortDateNew() {
            Collections.sort(repository.getAll(), new NewestSort());
        }

        @Test
        void shouldSortDateOld() {
            Collections.sort(repository.getAll(), new OldesSort());
        }

        @Test
        void shouldSortMostComment() {
            Collections.sort(repository.getAll(), new MostCommented());
        }

        @Test
        void shouldSortLeastComment() {
            Collections.sort(repository.getAll(), new LeastCommented());
        }
    }

    @Nested
    class SingleIssue {
        @BeforeEach
        public void setUp() {
            repository.add(issue1);
        }

        @Test
        void shouldAddIssue() {
            repository.getAll();
        }

        @Test
        void shouldOutputListAllOpenIssue() {
            repository.findOpen(repository.getAll());
        }

        @Test
        void shouldOutputListAllCloseIssue() {
            repository.findClose(repository.getAll());
        }

        @Test
        void shouldOpenIssue() {
            repository.openById(repository.getAll(), 2);
        }

        @Test
        void shouldCloseIssue() {
            repository.closeById(repository.getAll(), 1);
        }

        @Test
        void shouldSortDateNew() {
            Collections.sort(repository.getAll(), new NewestSort());
        }

        @Test
        void shouldSortDateOld() {
            Collections.sort(repository.getAll(), new OldesSort());
        }

        @Test
        void shouldSortMostComment() {
            Collections.sort(repository.getAll(), new MostCommented());
        }

        @Test
        void shouldSortLeastComment() {
            Collections.sort(repository.getAll(), new LeastCommented());
        }
    }

    @Nested
    class MultipleIssue {
        @BeforeEach
        public void setUp() {
            repository.add(issue1);
            repository.add(issue2);
            repository.add(issue3);
        }

        @Test
        void shouldAddIssue() {
            List<Issue> actual = repository.getAll();
        }

        @Test
        void shouldOutputListAllOpenIssue() {
            List<Issue> actual = repository.findOpen(repository.getAll());
        }

        @Test
        void shouldOutputListAllCloseIssue() {
            List<Issue> actual = repository.findClose(repository.getAll());
        }

        @Test
        void shouldOpenIssue() {
            repository.openById(repository.getAll(), 2);
        }

        @Test
        void shouldCloseIssue() {
            repository.closeById(repository.getAll(), 1);
        }

        @Test
        void shouldSortDateNew() {
            Collections.sort(repository.getAll(), new NewestSort());
        }

        @Test
        void shouldSortDateOld() {
            Collections.sort(repository.getAll(), new OldesSort());
        }

        @Test
        void shouldSortMostComment() {
            Collections.sort(repository.getAll(), new MostCommented());
        }

        @Test
        void shouldSortLeastComment() {
            Collections.sort(repository.getAll(), new LeastCommented());
        }
    }
}