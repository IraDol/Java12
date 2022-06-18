package Manager;

import static org.junit.jupiter.api.Assertions.*;

import Domain.Book;
import Domain.Product;
import Domain.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepoTest {
    Product book1 = new Book("FirstAuthor", "First", 111, 1000);
    Product book2 = new Book("SecondAuthor", "Second", 222, 2000);
    Product smartphone1 = new Smartphone("FirstProducer", "FirstPhone", 333, 3000);
    Product smartphone2 = new Smartphone("SecondProducer", "SecondPhone", 444, 4000);
    Repo repo = new Repo();

    @Test
    void saveTwoProdacts() {
        repo.save(book1);
        repo.save(smartphone1);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void saveSameProdacts() {
        repo.save(book1);
        repo.save(book1);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book1};
        Assertions.assertArrayEquals(actual, expected);
    }


    @Test
    void removeById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);

        repo.removeById(333);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void removeByIdLastProdact() {
        repo.save(book1);

        repo.removeById(111);
        Product[] actual = repo.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void removeByIdTwoProdacts() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);

        repo.removeById(111);
        repo.removeById(222);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2};
        Assertions.assertArrayEquals(actual, expected);
    }

}