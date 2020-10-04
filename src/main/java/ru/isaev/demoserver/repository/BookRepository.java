package ru.isaev.demoserver.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.isaev.demoserver.model.Book;

import java.util.List;


@Repository
public class BookRepository {

    public List<Book> showAllInDB (){
        try (Session session = HibernateUtill.getSession()) {
            session.beginTransaction();

            List<Book> allBooks = session.createQuery("FROM Book ", Book.class).list();

            session.close();
            return allBooks;

        } catch (Throwable cause){
            cause.printStackTrace();
            return null;
        }
    }

    public void saveBookInDB (Book book){
        try (Session session = HibernateUtill.getSession()) {
            session.beginTransaction();
            session.save(book);

            session.getTransaction().commit();
            session.close();

        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public void deleteBookByIDInDB (short id){
        try (Session session = HibernateUtill.getSession()) {
            session.beginTransaction();

            Query query = session.createQuery("DELETE Book where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();


            session.getTransaction().commit();
            session.close();

        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public Book findByIDInDB(short id){
        try (Session session = HibernateUtill.getSession()) {
            session.beginTransaction();

            Query query = session.createQuery("FROM Book where id= :id").
                    setParameter("id", id);
            Book selectedBook = (Book) query.uniqueResult();

            session.close();
            return selectedBook;

        } catch (Throwable cause){
            cause.printStackTrace();
            return null;
        }
    }

    public void updateBookInDB(Book book){
        try (Session session = HibernateUtill.getSession()) {
            session.beginTransaction();

            session.update(book);

            session.getTransaction().commit();
            session.close();

        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public List<Book> findAllByBookNameOrGenreOrAuthorInDB(String request){
        try (Session session = HibernateUtill.getSession()) {
            session.beginTransaction();

            List<Book> allBooks = session.createQuery(
                    "FROM Book WHERE " +
                            "bookName = :request or " +
                            "author = :request or " +
                            "genre = :request", Book.class
            ).setParameter("request", request).list();

            session.close();
            return allBooks;

        } catch (Throwable cause){
            cause.printStackTrace();
            return null;
        }
    }
}
