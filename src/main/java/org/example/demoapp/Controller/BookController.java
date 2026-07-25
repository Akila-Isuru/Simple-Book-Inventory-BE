package org.example.demoapp.Controller;

import jakarta.validation.Valid;
import org.example.demoapp.DTO.BookDTO;
import org.example.demoapp.Entity.Book;
import org.example.demoapp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @PostMapping
    public BookDTO updateBook(@RequestBody BookDTO bookDTO) {
        return bookService.updateBook(bookDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
         return bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public  BookDTO getBookById(int id) {
        return bookService.getBookById(id);
    }
}

