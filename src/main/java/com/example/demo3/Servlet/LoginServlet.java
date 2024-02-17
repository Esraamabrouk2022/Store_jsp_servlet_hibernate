package com.example.demo3.Servlet;
import com.example.demo3.EntityManagerProvider;
import com.example.demo3.model.User;
import com.example.demo3.repo.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import java.io.IOException;
@WebServlet( "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform user authentication
        User user = UserRepo.findUserByUsernameAndPassword(username, password);
        System.out.println(username+" "+password);
        if (user != null) {
            // Redirect to product.jsp on successful login
            response.sendRedirect("products.jsp");
        } else {
            // Redirect back to login.jsp with error message
            response.sendRedirect("login.jsp?error=true");
        }
    }

}
