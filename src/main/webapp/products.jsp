<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo3.model.Product" %>
<%@ page import="com.example.demo3.repo.ProductRepo" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <%
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = productRepo.findAllProducts();
        for (Product product : productList) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <td>
            <!-- Update action -->
            <a href="update?id=<%= product.getId() %>">Update</a>
            <!-- Delete action -->
            <a href="delete?id=<%= product.getId() %>" onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<a href="add.jsp">Add Product</a>
</body>
</html>
