import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/favCity")
public class FavoriteCity extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Favorite City</h1>");
        String html = "<form method='POST'>";
        html += "<label>Search</label>  ";
        html += "<input name='city' placeholder='Enter favorite city'> ";
        html += "<button>Submit</button>";
        html += "</form";
        resp.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String favCity = req.getParameter("city");
        System.out.println(favCity);
        resp.sendRedirect("/favCity/results?city=" + favCity);
    }

}
