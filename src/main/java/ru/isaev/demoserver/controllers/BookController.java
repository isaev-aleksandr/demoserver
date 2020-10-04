package ru.isaev.demoserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.isaev.demoserver.model.Book;
import ru.isaev.demoserver.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookServiceImpl;

    @Autowired
    public BookController(BookService bookService) {
        this.bookServiceImpl = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookServiceImpl.showAllBookInRepo();
    }

    @PostMapping("/book-create")
    public List<Book> createBook (@RequestBody Book book){
        bookServiceImpl.saveBookInRepo(book);
        return bookServiceImpl.showAllBookInRepo();
    }

    @DeleteMapping("/book-delete/{id}")
    public List<Book> deleteBook(@PathVariable("id") Short id){
        bookServiceImpl.deleteBookByIDInRepo(id);
        return bookServiceImpl.showAllBookInRepo();
    }

    @GetMapping("/book-get/{id}")
    public Book updateBook(@PathVariable("id") Short id){
        return bookServiceImpl.findByIDInRepo(id);
    }

    @PatchMapping("/book-update")
    public Book updateBook(@RequestBody Book book){
        bookServiceImpl.updateBookInRepo(book);
        return book;
    }

    @GetMapping("/book-search")
    public List<Book> searchBook(@RequestParam("bookName") String request, Book book){
        if (request == "") {
            return null;
        }
        return bookServiceImpl.findAllByBookNameOrGenreOrAuthorInRepo(request);
    }
}

