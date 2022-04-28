import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guess")
public class GuessingGame extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/guess.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int randomNumber = (int) (Math.random() * 3 + 1);
        int userGuess = Integer.parseInt(req.getParameter("guess"));

        if (userGuess == randomNumber){
            resp.sendRedirect("/correct");
        } else {
            resp.sendRedirect("/incorrect");
        }

    }

} //END
