package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Library")
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String ISBN;
    private Integer yearOfRelease;
    private Integer amountOfPages;
    private String publisher;
    private double price;

    public Book(Integer id, String name, String author, String ISBN, Integer yearOfRelease, Integer amountOfPages, String publisher, double price)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.yearOfRelease = yearOfRelease;
        this.amountOfPages = amountOfPages;
        this.publisher = publisher;
        this.price = price;
    }

    public Book(String name, String author, String ISBN, Integer yearOfRelease, Integer amountOfPages, String publisher, double price)
    {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.yearOfRelease = yearOfRelease;
        this.amountOfPages = amountOfPages;
        this.publisher = publisher;
        this.price = price;
    }

    public Book () {

    }

    public Integer getYearOfRelease()
    {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease)
    {
        this.yearOfRelease = yearOfRelease;
    }

    public Integer getAmountOfPages()
    {
        return amountOfPages;
    }

    public void setAmountOfPages(Integer amountOfPages)
    {
        this.amountOfPages = amountOfPages;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }
}
