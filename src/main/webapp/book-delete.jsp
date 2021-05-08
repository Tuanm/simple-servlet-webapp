<%@ page import="model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book - Delete</title>
</head>
<body>
    <h2>Are you sure to delete this book?</h2>
    <div>
        <% Book book = (Book) request.getAttribute("book"); %>
        <% if (book != null) { %>
            <p><%= book %></p>
            <form action="/book" method="POST">
                <input type="hidden" name="delete">
                <input type="hidden" name="id" value="<%= book.getId() %>">
                <input type="hidden" name="title" value="<%= book.getTitle() %>">
                <input type="hidden" name="author" value="<%= book.getAuthor() %>">
                <input type="hidden" name="publisher" value="<%= book.getPublisher() %>">
                <input type="hidden" name="price" value="<%= book.getPrice() %>">
                <input type="submit" value="Yes">
            </form>
        <% } else { %>
            <p>Wait, it is no longer here. You can click </p>
        <% } %>
    </div>
    <div>
        <a href="/book">Back</a>
    </div>
</body>
</html>
