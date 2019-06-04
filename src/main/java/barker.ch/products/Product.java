package barker.ch.products;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private double price;
    private boolean onFrontPage;

    public Product() {}

    public Product(String name, String description, double price, boolean onFrontPage) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.onFrontPage = onFrontPage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOnFrontPage() {
        return onFrontPage;
    }

    public void setOnFrontPage(boolean frontPage) {
        this.onFrontPage = frontPage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", onFrontPage=" + onFrontPage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
