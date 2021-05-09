package net.einself.quarker.comment.service;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import net.einself.quarker.comment.domain.Comment;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@QuarkusTest
class CommentServiceTest {

    @InjectMock
    CommentRepository commentRepository;

    @Inject
    CommentService underTest;

    @Test
    void createShouldShouldDelegateModelToRepository() {
        // arrange
        final var comment = new Comment();

        // act
        final var result = underTest.create(comment);

        // assert
        verify(commentRepository).persist(comment);
        assertEquals(comment, result);
    }

    @Test
    void shouldFindAllByThreadId() {
        // arrange
        final var comment = new Comment();
        final var comments = List.of(comment);
        when(commentRepository.listAllByThreadId(1L)).thenReturn(comments);

        // act
        final var result = underTest.findAllByThreadId(1L);

        // assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(comment, result.get(0));
    }

}