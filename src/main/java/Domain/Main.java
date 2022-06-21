package Domain;

import Manager.Manager;
import Manager.Repo;

public class Main {
    public static void main(String[] args) {

        Repo repo = new Repo();
        Manager manager = new Manager(repo);


//       Product book2 = new Book("SecondAuthor", "Second", 222);
//        Product smartphone1 = new Smartphone("FirstProducer", "FirstPhone", 333);
//        Product smartphone2 = new Smartphone("SecondProducer", "SecondPhone", 444);

//        repo.add(book1)
//
//        repo.save();
        // Product[] result = repo.save();
//        Product book1 = new Book("FirstAuthor", "First", 111, 1000);
//        Product book2 = new Book("SecondAuthor", "Second", 222, 2000);
//       // manager.findById(222);

        repo.removeById(222);
        System.out.println("test");

    }
}
