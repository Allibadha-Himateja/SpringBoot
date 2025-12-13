<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.iss.springboot.Models.Product" %> <%-- Replace com.yourpackage.Product with your actual Product class path --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product List View (Scriptlets)</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h1>Available Products</h1>

<%
    // 1. Retrieve the product list from the Model (which is available via the request scope)
    //    NOTE: You must cast the object retrieved from the request attribute.
    List<Product> productList = (List<Product>) request.getAttribute("productlist");
%>

<%
    // 2. Scriptlet for conditional check (if the list is empty or null)
    if (productList == null || productList.isEmpty()) {
%>
<p>No products are currently available.</p>
<%
} else {
%>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <%
        // 3. Scriptlet for iteration (loop through the list)
        for (Product product : productList) {
    %>
    <tr>
        <%-- 4. Using JSP Expression Language (EL) to display data is still recommended and easier --%>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td>$<%= product.getPrice() %></td>
        <%-- NOTE: Alternatively, you could still use the product object in EL if it's set in a smaller scope:
            <td>${product.id}</td> (But this is often complex to manage without JSTL's c:forEach)
        --%>
    </tr>
    <%
        } // End of for loop
    %>
    </tbody>
</table>
<%
    } // End of if/else block
%>

</body>
</html>