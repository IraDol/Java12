package Manager;

import Domain.Product;

public class Repo {
    private Product[] products = new Product[0];


    public void save(Product product) {
        int lenght = products.length + 1;
        Product[] tmp = new Product[lenght];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndexProduct = tmp.length - 1;
        tmp[lastIndexProduct] = product;
        products = tmp;
    }


    public Product[] findAll() {
        return products;
    }


    public void removeById(int id) {
        int lenght = products.length - 1;
        Product[] tmp2 = new Product[lenght];
        int indexFirst = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp2[indexFirst] = product;
                indexFirst++;
            }
            products = tmp2;
        }

    }

}

