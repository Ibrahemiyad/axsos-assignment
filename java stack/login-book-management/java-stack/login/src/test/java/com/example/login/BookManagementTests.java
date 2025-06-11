package com.example.login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.login.controllers.BookController;
import com.example.login.models.Book;
import com.example.login.models.User;
import com.example.login.services.BookService;
import com.example.login.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
public class BookManagementTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @Mock
    private UserService userService;

    @InjectMocks
    private BookController bookController;

    private MockHttpSession session;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        session = new MockHttpSession();
        User user = new User();
        user.setId(1L);
        session.setAttribute("userId", user.getId());
    }

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Author Name");
        book.setDescription("Book Description");

        mockMvc.perform(post("/books/add")
                .session(session)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", book.getTitle())
                .param("author", book.getAuthor())
                .param("description", book.getDescription()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testEditBook() throws Exception {
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Updated Book");
        book.setAuthor("Updated Author");
        book.setDescription("Updated Description");

        mockMvc.perform(post("/books/edit/" + bookId)
                .session(session)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", book.getTitle())
                .param("author", book.getAuthor())
                .param("description", book.getDescription()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testDeleteBook() throws Exception {
        Long bookId = 1L;

        mockMvc.perform(post("/books/delete/" + bookId)
                .session(session))
                .andExpect(status().is3xxRedirection());
    }
}