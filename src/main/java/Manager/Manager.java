package Manager;

import Domain.Product;

public class Manager {
    private Repo repo = new Repo();
    //private Product[] products = new Product[0];


    public Manager(Repo repo) {
        this.repo = repo;
    }

    public Manager() {
    }

    public void add(Product product) {
        repo.save(product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tpm2 = new Product[result.length + 1];
                System.arraycopy(repo.findAll(), 0, tpm2, 0, result.length);
                int lastIndex = tpm2.length - 1;
                tpm2[lastIndex] = product;
                result = tpm2;
            }


        }
        return result;


    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);


    }

}




