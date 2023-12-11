import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private void request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            response.getWriter().write("Invalid input");
            return;
        }

        try {
            int num01 = Integer.parseInt(num1);
            int num02 = Integer.parseInt(num2);

            int sum = num01 + num02;
            response.getWriter().write("The sum of " + num1 + " and " + num2 + " is " + sum);
        } catch (NumberFormatException e) {
            response.getWriter().write("Can't parse to int");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request(request, response);
    }
}
