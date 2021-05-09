package net.einself.quarker.comment.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.RestAssured;
import net.einself.quarker.comment.domain.Comment;
import net.einself.quarker.comment.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


@QuarkusTest
@TestHTTPEndpoint(CommentResource.class)
class CommentResourceTest {

    @InjectMock
    CommentService commentService;

    @Test
    void getShouldReturnBadRequestStatusIfThreadIdIsNotSet() {
        // act
        final var result = RestAssured.when().get();

        // assert
        result.then().statusCode(400);
    }

    @Test
    void getShouldReturnCommentsIfThreadIdSet() {
        // arrange
        final var comment = new Comment.Builder().id(1L).build();
        final var comments = List.of(comment);
        Mockito.when(commentService.findAllByThreadId(1L)).thenReturn(comments);

        final var request = RestAssured.given()
                .queryParam("threadId", 1L);

        // act
        final var result = request.when().get();

        // assert
        result.then()
                .statusCode(200)
                .body("data", hasSize(1))
                .body("data[0].id", equalTo(1));

    }

}