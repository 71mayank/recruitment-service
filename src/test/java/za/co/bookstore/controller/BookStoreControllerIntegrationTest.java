package za.co.bookstore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import za.co.bookstore.service.BookServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(BookStoreController.class)
public class BookStoreControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookServiceImpl bookServiceImpl;

    @Test
    public void saveBookSuccessTest() {

    }


}
