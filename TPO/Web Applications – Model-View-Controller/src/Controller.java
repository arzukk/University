import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    Model model = new Model();

    protected void request(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int x = Integer.parseInt(request.getParameter("num1"));
            int y = Integer.parseInt(request.getParameter("num2"));
            HttpSession session = request.getSession();
            int result = model.addition(x, y);
            session.setAttribute("add", result);
        } catch (Exception e) {
            HttpSession session = request.getSession();
            session.setAttribute("add", "Invalid input");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request(request, response);
    }
}