package ru.isaev.demoserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isaev.demoserver.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Short> {

    List<Book> findAllByBookNameOrGenreOrAuthor(String bookName, String genre, String author);
}
