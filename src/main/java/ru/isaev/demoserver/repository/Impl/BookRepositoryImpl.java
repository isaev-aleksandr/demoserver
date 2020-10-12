package ru.isaev.demoserver.repository.Impl;

import org.springframework.stereotype.Repository;
import ru.isaev.demoserver.model.Book;
import ru.isaev.demoserver.repository.BookRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class BookRepositoryImpl implements BookRepository {

    private EntityManager entityManager;

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> showAllInDB (){
        Query query = entityManager.createNamedQuery("Book.findBooks");
        return query.getResultList();
    }

    @Override
    public void saveBookInDB (Book book){
        entityManager.persist(book);
    }

    @Override
    public void deleteBookByIDInDB (short id){
        entityManager.createNamedQuery("Book.deleteBook")
        .setParameter("Id", id).executeUpdate();
    }

    @Override
    public Book findByIDInDB(short id){
        Query query = entityManager.createNamedQuery("Book.findBookById")
                .setParameter("Id", id);
        return (Book) query.getSingleResult();
    }

    @Override
    public void updateBookInDB(Book book){
        entityManager.merge(book);
    }

    @Override
    public List<Book> findAllByBookNameOrGenreOrAuthorInDB(String request){
        Query query = entityManager.createNamedQuery("Book.findBookByTitleOrGenreOrAuthor").
                setParameter("title", request).
                setParameter("genre", request).
                setParameter("author", request);
        return query.getResultList();
    }
}
