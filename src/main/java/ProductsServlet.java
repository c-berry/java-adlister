import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ProductsServlet", urlPatterns = "/Products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Products productsDao = DaoFactory.getProductsDao();
        List<Product> products = productsDao.all();

        request.setAttribute("products", products);
        RequestDispatcher view = request.getRequestDispatcher("/products.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(name, price);
//        List<Product> products = Product.getProducts();
//        products.add(product);

        Products productsDao = DaoFactory.getProductsDao();
        productsDao.insert(product);

        List<Product> products = productsDao.all();

        request.setAttribute("products", products);
        RequestDispatcher view = request.getRequestDispatcher("/products.jsp");
        view.forward(request, response);
    }
}