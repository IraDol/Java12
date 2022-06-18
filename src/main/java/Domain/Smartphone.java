package Domain;

import Domain.Product;

import java.util.Objects;

public class Smartphone extends Product {
    private String producer;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(producer, that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer);
    }

    public Smartphone(String producer, String name, int id, int price) {
        super(name, id, price);
        this.producer = producer;
    }
}
