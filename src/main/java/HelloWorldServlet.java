import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    private int count = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        count += 1;
        String name
                = req.getParameter("name");
        if (name == null){

            name = "World";
        }
        if (req.getParameter("reset") != null){
            count = 0;
            res.sendRedirect("/hello");
        }

        res.getWriter().println("Hello, " + name);
        res.getWriter().println("View count: " + count);
    }

//    public int counter(int num){
//        return num + 1;
//    }

}


