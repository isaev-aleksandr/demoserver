package ru.isaev.demoserver.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isaev.demoserver.model.Book;
import ru.isaev.demoserver.repository.BookRepository;
import ru.isaev.demoserver.service.BookService;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    @Override
    public void setBookRepository (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> showAllBookInRepo() {
        return bookRepository.showAllInDB();
    }

    @Override
    public void saveBookInRepo (Book book){
        bookRepository.saveBookInDB(book);
    }

    @Override
    public void deleteBookByIDInRepo(short id){
        bookRepository.deleteBookByIDInDB(id);
    }

    @Override
    public Book findByIDInRepo(short id) {
        return bookRepository.findByIDInDB(id);
    }

    @Override
    public void updateBookInRepo(Book book){
        bookRepository.updateBookInDB(book);
    }

    @Override
    public List<Book> findAllByBookNameOrGenreOrAuthorInRepo(String request){
        return bookRepository.findAllByBookNameOrGenreOrAuthorInDB(request);
    }

}
