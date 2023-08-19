package pl.com.coders.libria1.repository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import pl.com.coders.libria1.Libria1Application;
import pl.com.coders.libria1.domain.Book;

import java.time.LocalDateTime;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Libria1Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:applicationintegrationtest.properties")
class BookRepositoryIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
    }

//    @Test
//    public void givenBooks_whenGetBooks_thenStatus200() throws Exception {
//        Book book = new Book(2L, "Wuthering Heights", "Emily Brontë", 20, LocalDateTime.now(), LocalDateTime.now());
//        book = bookRepository.save(book);
//
//        mvc.perform(get("/book")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect((ResultMatcher) jsonPath("$[1].title", is("Wuthering Heights")));
//    }
}