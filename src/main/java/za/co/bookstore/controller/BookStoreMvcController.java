package za.co.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.bookstore.dto.BookDTO;
import za.co.bookstore.model.Book;
import za.co.bookstore.service.BookServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("bookstore")
public class BookStoreMvcController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        List<Book> allBooks = bookService.getAllBooks();

        Map<Book, BookDTO> bookDTOMap = new HashMap<>();
        allBooks.forEach(book ->
                bookDTOMap.put(book,
                        BookDTO.builder()
                                .authorDTOS(book.getAuthors().stream().map(author -> author.getAuthorName()).toString())
                                .category(book.getBookCategory().getBookCategory())
                                .title(book.getBookTitle().getBookTitle())
                                .price(book.getBookPrice())
                                .year(Long.valueOf(book.getBookYear())).build()));

        model.addAttribute("books", bookDTOMap.values().stream().collect(Collectors.toList()));
        return "home";
    }

    @GetMapping("/sub")
    public String subPage(Model model) {
        model.addAttribute("appName", appName);
        return "subscription.html";
    }
}