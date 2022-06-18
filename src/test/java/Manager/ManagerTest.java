package Manager;

import Domain.Book;
import Domain.Product;
import Domain.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManagerTest {
    Product book1 = new Book("FirstAuthor", "First", 111, 1000);
    Product book2 = new Book("SecondAuthor", "Second", 222, 2000);
    Product smartphone1 = new Smartphone("FirstProducer", "FirstPhone", 333, 3000);
    Product smartphone2 = new Smartphone("SecondProducer", "SecondPhone", 444, 4000);
    Repo repo = new Repo();
    Manager manager = new Manager(repo);

    @Test
    void addTwoProdacts() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void searchByTwoProduct() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("Fir");
        Product[] expected = {book1, smartphone1};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void searchByOneMatch() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("irstP");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void searchByNoMatch() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("kuy");
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void searchByNoProduct() {


        Product[] actual = manager.searchBy("first");
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);

    }


}