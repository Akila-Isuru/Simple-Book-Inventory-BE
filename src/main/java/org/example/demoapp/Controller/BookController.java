package org.example.demoapp.Controller;

import jakarta.validation.Valid;
import org.example.demoapp.DTO.BookDTO;
import org.example.demoapp.Entity.Book;
import org.example.demoapp.Service.BookService;
import org.example.demoapp.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAllBooks() {
        List<BookDTO> bookDTOList  = bookService.getAllBooks();
       return new ResponseEntity<>(
               new StandardResponse(200,"Succefully Fetched All Books",bookDTOList),
               HttpStatus.OK
       );
    }

    @PostMapping
   public ResponseEntity<StandardResponse> createBook(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO newBook =  bookService.createBook(bookDTO);
        return new ResponseEntity<>(
                new StandardResponse(201,"Book saved Successfully",newBook),
                HttpStatus.CREATED
        );
    }
    @PutMapping
    public ResponseEntity<StandardResponse> updateBook(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook =  bookService.updateBook(bookDTO);
        return new ResponseEntity<>(
                new StandardResponse(200,"Book Updated Successfully",updatedBook),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteBook(@PathVariable Integer id) {
        String message = bookService.deleteBook(id);
        return new  ResponseEntity<>(
                new StandardResponse(200, "Book Deleted Successfully !",message)
                , HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public  ResponseEntity<StandardResponse> getBookById(@PathVariable int id) {
        BookDTO book = bookService.getBookById(id);
        return new ResponseEntity<>(
                new StandardResponse(200,"Book Details Successfully !",book),
                HttpStatus.OK
        );
    }
}

