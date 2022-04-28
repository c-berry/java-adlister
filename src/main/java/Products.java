import java.util.List;

public interface Products {
    // matches SELECT * FROM products;
    List<Product> all();
    // matches INSERT INTO products (name, price) ...
    void insert(Product product);
}