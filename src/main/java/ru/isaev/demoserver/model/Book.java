package ru.isaev.demoserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private short id;

    @Column(name = "book_name")
    private  String bookName;
    private  String genre;
    private  String author;
    private  short publication;
    @Column(name = "count_pages")
    private  short countPages;
    private  short price;
}
