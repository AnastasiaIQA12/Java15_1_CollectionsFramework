package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

class IssueManagerTest {

    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);
    private Author author1 = new Author("Ivan", "url:\\1");
    private Author author2 = new Author("Sveta", "url:\\2");
    private Author author3 = new Author("Kolia", "url:\\3");
    private Label label1 = new Label("lightGreen", "component", "Kotlin");
    private Label label2 = new Label("Green", "component", "Jupiter");
    private Label label3 = new Label("lightGreen", "component", "OTA");
    private Issue issue1 = new Issue(1, "Issue", true, 15122020, author1, label1, "Java8", "5.8M1", author3, 5);
    private Issue issue2 = new Issue(2, "Issue", false, 15102020, author2, label2, "Java8", "5.8M1", author2, 3);
    private Issue issue3 = new Issue(3, "Issue", true, 15082020, author3, label1, "Java8", "5.8M1", author2, 7);

    @Nested
    class Empty {
        @Test
        void shouldFilterAuthor() {
            manager.filterAuthor(author1);
        }

        @Test
        void shouldFilterLabel() {
            manager.filterLabel(label1);
        }

        @Test
        void shouldFilterAssignee() {
            manager.filterAssignee(author2);
        }
    }

    @Nested
    class SingleIssue {
        @BeforeEach
        public void setUp() {
            manager.add(issue1);
        }

        @Test
        void shouldFilterAuthor() {
            manager.filterAuthor(author1);
        }

        @Test
        void shouldFilterLabel() {
            manager.filterLabel(label1);
        }

        @Test
        void shouldFilterAssignee() {
            manager.filterAssignee(author2);
        }
    }

    @Nested
    class MultipleIssue {
        @BeforeEach
        public void setUp() {
            manager.add(issue1);
            manager.add(issue2);
            manager.add(issue3);
        }

        @Test
        void shouldFilterAuthor() {
            manager.filterAuthor(author1);
        }

        @Test
        void shouldFilterLabel() {
            manager.filterLabel(label1);
        }

        @Test
        void shouldFilterAssignee() {
            manager.filterAssignee(author2);
        }
    }
}