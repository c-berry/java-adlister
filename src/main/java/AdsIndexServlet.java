import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ads")
public class AdsIndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Ads dao1 = DaoFactory.getAdsDao();
        List<Ad> list = dao1.all();

        req.setAttribute("list", list);

        req.getRequestDispatcher("/ads/index.jsp").forward(req, resp);
    }

}
