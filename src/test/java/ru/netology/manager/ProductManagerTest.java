package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Smartphone phone1 = new Smartphone(33,"Iphone 22",100000,"Apple" );
    Smartphone phone2 = new Smartphone(44,"Redmi Note", 50000,"Xiaomi" );
    Smartphone phone3 = new Smartphone(55,"X series", 9999,"Nokia" );
    Book book1 = new Book(66,"Three Friends", 2000,"E.M.Remark");
    Book book2 = new Book(77,"The Lord of The Rings", 5000,"G.R.R.Tolkien");
    Book book3 = new Book(88,"The Financier", 1500,"T.Dreiser");


    @Test
    public void shouldAddProducts () {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product [] actual = manager.findAll();
        Product [] expected ={phone1,phone2,phone3,book1,book2,book3};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldSearchBySymbols () {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product [] actual = manager.searchBy("Th");
        Product [] expected ={book1,book2,book3};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldRemoveById () {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.removeById(33);
        manager.removeById(88);
        Product [] actual = manager.findAll();
        Product [] expected ={phone2,phone3,book1,book2};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotRemoveById () {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.removeById(11);
        Product [] actual = manager.findAll();
        Product [] expected ={phone1,phone2,phone3,book1,book2,book3};
        Assertions.assertArrayEquals(expected,actual);
    }









}
