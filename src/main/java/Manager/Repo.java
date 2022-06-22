package Manager;

import Domain.Product;

public class Repo {
    private Product[] products = new Product[0];
//   private Repo repo = new Repo();

//    public Product sameId(int findId) {
//        Product product = new Product();
//        if (findId == product.getId()) {
//            throw new NegativeIdException("Такой ID уже существует");
//        }
//        return product;
//    }

    public void save(Product product) {
        for (Product product1 : findAll())
            if (product1.getId() == product.getId()) {
                throw new NegativeExistId("Такой ID уже существует");
            }
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
    // доб нов метод

    public Product[] findById(int findId) {
        Product[] result = new Product[0];   // завели место под находку
        for (Product product : findAll()) {  // перебирем каждый товар
            if (product.getId() == findId) {      // если условие условие тру, то ретурн товара
                Product[] tmp = new Product[result.length + 1]; // все, что нашлось, доб в новый массив
                System.arraycopy(findAll(), 0, tmp, 0, result.length); // для этого копируем старый и доб новую находку
                int bingoIndex = 0;
                tmp[bingoIndex] = product;
                result = tmp;
                return result;
            }
        }
        return null;
    }


    public void removeById(int id) {
        //int findId;
        if (findById(id) == null) {
            throw new NegativeIdException("Element with id: " + id + " not found");
        } else {
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
}



