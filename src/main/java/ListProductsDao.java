import java.util.List;

public class ListProductsDao implements Products {
    List<Product> products = Product.getProducts();

    @Override
    public List<Product> all() {
        return products;
    }

    @Override
    public void insert(Product product) {
        products.add(product);
    }
}
