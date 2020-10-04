package ru.isaev.demoserver.service;

import ru.isaev.demoserver.model.Book;
import ru.isaev.demoserver.repository.BookRepository;

import java.util.List;

public interface BookService {

    public void setBookRepository(BookRepository bookRepository);

    public List<Book> showAllBookInRepo();

    public void saveBookInRepo (Book book);

    public void deleteBookByIDInRepo(short id);

    public Book findByIDInRepo(short id);

    public void updateBookInRepo(Book book);

    public List<Book> findAllByBookNameOrGenreOrAuthorInRepo(String request);
}
