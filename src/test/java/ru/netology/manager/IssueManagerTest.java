package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {

    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);
    private Author author1 = new Author(1, "Ivan", "url:\\1");
    private Author author2 = new Author(2, "Sveta", "url:\\2");
    private Author author3 = new Author(3, "Kolia", "url:\\3");
    private Set<Author> assignees = new HashSet<>();
    private Set<Integer> nomer = new HashSet<>();
    private Label label1 = new Label(1, "lightGreen", "component", "Kotlin");
    private Label label2 = new Label(2, "Green", "component", "Jupiter");
    private Label label3 = new Label(3, "lightGreen", "component", "OTA");
    private Set<Label> labels = new HashSet<>();
    private Issue issue1 = new Issue(1, "Issue", true, 15122020, 241220020, author1, labels, "Java8", "5.8M1", assignees, 5);
    private Issue issue2 = new Issue(2, "Issue", false, 15102020, 13122020, author2, labels, "Java8", "5.8M1", assignees, 3);
    private Issue issue3 = new Issue(3, "Issue", true, 15082020, 17092020, author1, labels, "Java8", "5.8M1", assignees, 7);

    @Nested
    class MultipleIssue {
        @BeforeEach
        public void setUp() {
            labels.add(label1);
            labels.add(label2);
            assignees.add(author2);
            manager.add(issue1);
            manager.add(issue2);
            manager.add(issue3);
        }

        @Test
        void shouldFilterAuthorNo() {
            List<Issue> actual = manager.filterAuthor(author3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAuthorYes() {
            List<Issue> actual = manager.filterAuthor(author1);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue1);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issue> actual = manager.filterLabel(label3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelYes() {
            List<Issue> actual = manager.filterLabel(label2);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue1);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issue> actual = manager.filterAssignee(author1);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeYes() {
            List<Issue> actual = manager.filterAssignee(author2);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue1);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }
    }


    @Nested
    class Empty {
        @Test
        void shouldFilterAuthorNo() {
            List<Issue> actual = manager.filterAuthor(author3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issue> actual = manager.filterLabel(label3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issue> actual = manager.filterAssignee(author1);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

    }

    @Nested
    class SingleIssue {
        @BeforeEach
        public void setUp() {
            labels.add(label1);
            labels.add(label2);
            assignees.add(author1);
            manager.add(issue1);

        }

        @Test
        void shouldFilterAuthorNo() {
            List<Issue> actual = manager.filterAuthor(author3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAuthorYes() {
            List<Issue> actual = manager.filterAuthor(author1);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issue> actual = manager.filterLabel(label3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelYes() {
            List<Issue> actual = manager.filterLabel(label2);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issue> actual = manager.filterAssignee(author2);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeYes() {
            List<Issue> actual = manager.filterAssignee(author1);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue1);
            assertEquals(expected, actual);
        }

    }
}