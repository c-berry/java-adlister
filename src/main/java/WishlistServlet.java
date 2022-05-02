import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/wishlist")
public class WishlistServlet extends HttpServlet {

    //show wishlist =>
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/wishlist.jsp").forward(req, resp);
    }

    //add to wishlist =>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (req.getParameter("clear") != null) {
            session.setAttribute("wishlist", new ArrayList<>());
            resp.sendRedirect("/wishlist");
            return;
        }

        List<Ad> wishlistAds = null;

        if (session.getAttribute("wishlist") != null) {
            wishlistAds = (List<Ad>) session.getAttribute("wishlist");
        } else {
            wishlistAds = new ArrayList<>();
            session.setAttribute("wishlist", wishlistAds);
        }
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            Ad adToSave = new Ad(title, description);
            wishlistAds.add(adToSave);
            resp.sendRedirect("/ads");


        //different example =>
//        List<String> wishlistArray = null;
//
//        if (session.getAttribute("wishlist") != null) {
//            wishlistArray = (List<String>) session.getAttribute("wishlist");
//        } else {
//            wishlistArray = new ArrayList<>();
//            session.setAttribute("wishlist", wishlistArray);
//        }
//
//        wishlistArray.add(req.getParameter("wishlist"));
//        resp.sendRedirect("/profile");
    }
}
