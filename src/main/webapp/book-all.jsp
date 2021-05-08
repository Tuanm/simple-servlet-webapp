<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book - All</title>
</head>
<body>
    <h2>All Books</h2>
    <div>
        <a href="/">Home</a>
        <a href="/book?create">Create</a>
        <a href="/book?search">Edit</a>
        <a href="/book?delete">Delete</a>
    </div>
    <div>
        <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
        <% if (books != null && !books.isEmpty()) { %>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Price</th>
                </tr>
                <% for (Book book : books) { %>
                    <% if (book != null && !book.isTrash()) { %>
                        <tr>
                            <td><%= book.getId() %></td>
                            <td><%= book.getTitle() %></td>
                            <td><%= book.getAuthor() %></td>
                            <td><%= book.getPublisher() %></td>
                            <td>$<%= book.getPrice() %></td>
                        </tr>
                    <% } %>
                <% } %>
            </table>
        <% } else { %>
            <p>No Books Available</p>
        <% } %>
    </div>
</body>
</html>
