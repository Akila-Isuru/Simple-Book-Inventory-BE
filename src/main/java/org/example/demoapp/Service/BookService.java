package org.example.demoapp.Service;


import org.example.demoapp.DTO.BookDTO;
import org.example.demoapp.Entity.Book;
import org.example.demoapp.Repo.BookRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    public BookDTO createBook(BookDTO bookDTO) {
       Book savedBook = bookRepo.save(modelMapper.map(bookDTO, Book.class));
       return modelMapper.map(savedBook, BookDTO.class);
    }

    public BookDTO updateBook(BookDTO bookDTO) {
        bookRepo.save(modelMapper.map(bookDTO, Book.class));
        return bookDTO;
    }

    public String deleteBook(int id) {

        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return "Book with id " + id + " has been deleted";
        }else {
            return "Book with id " + id + " does not exist";
        }

    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return modelMapper.map(books,new TypeToken<List<BookDTO>>(){}.getType());
    }

    public BookDTO getBookById(int id) {
        Book book= bookRepo.findById(id).orElse(null);
        if  (book != null) {
            return modelMapper.map(book, BookDTO.class);
        }else  {
            return null;
        }
    }

}
