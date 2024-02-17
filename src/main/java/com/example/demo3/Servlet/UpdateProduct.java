package com.example.demo3.Servlet;

import com.example.demo3.model.Product;
import com.example.demo3.repo.ProductRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/update")
public class UpdateProduct extends HttpServlet {

    int id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       ProductRepo productRepository= new ProductRepo();
        id= Integer.parseInt(request.getParameter("id"));
        Product product= productRepository.findProductById(Math.toIntExact(id));
        request.setAttribute("id",id);
        request.setAttribute("name",product.getName());
        request.setAttribute("price",product.getPrice());

        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        ProductRepo.updateProduct(product);
        response.sendRedirect("products");

    }
}
