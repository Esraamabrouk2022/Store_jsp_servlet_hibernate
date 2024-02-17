package com.example.demo3.Servlet;

import com.example.demo3.EntityManagerProvider;
import com.example.demo3.model.Product;
import com.example.demo3.repo.ProductRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

@WebServlet("/add")
public class AddProduct extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        ProductRepo.saveProduct(product);
        response.sendRedirect("products");
    }
}