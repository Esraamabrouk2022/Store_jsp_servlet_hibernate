package com.example.demo3.Servlet;
import com.example.demo3.model.Product;
import com.example.demo3.repo.ProductRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeletProduct extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id"));
        Product product=ProductRepo.findProductById(id);
         ProductRepo.deleteProduct(product);
        response.sendRedirect("products");


    }
}
