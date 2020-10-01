package ru.isaev.demoserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isaev.demoserver.model.Book;
import ru.isaev.demoserver.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById (Short id){
        return bookRepository.getOne(id);
    }

    public List<Book> findAll (){
        return bookRepository.findAll();
    }

    public void saveBook (Book book){
        bookRepository.save(book);
    }

    public void deleteById(Short id){
        bookRepository.deleteById(id);
    }

    public List<Book> findAllByBookNameOrGenreOrAuthor (String request){
        return bookRepository.findAllByBookNameOrGenreOrAuthor(request, request, request);
    }
}
