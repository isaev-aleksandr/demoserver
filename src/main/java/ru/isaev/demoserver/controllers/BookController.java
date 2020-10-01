package ru.isaev.demoserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.isaev.demoserver.model.Book;
import ru.isaev.demoserver.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping("/book-create")
    public List<Book> createBook (@RequestBody Book book){
        bookService.saveBook(book);
        return bookService.findAll();
    }

    @DeleteMapping("/book-delete/{id}")
    public List<Book> deleteBook(@PathVariable("id") Short id){
        bookService.deleteById(id);
        return bookService.findAll();
    }

    @GetMapping("/book-update/{id}")
    public Book updateBookForm(@PathVariable("id") Short id){
        return bookService.findById(id);
    }

    @PatchMapping("/book-update")
    public Book updateBook(@RequestBody Book book){
        bookService.saveBook(book);
        return book;
    }

    @GetMapping("/book-search")
    public List<Book> searchBook(@RequestParam("bookName") String request, Book book, Model model){
        if (request == "") {
            return null;
        }
        return bookService.findAllByBookNameOrGenreOrAuthor(request);
    }
}

