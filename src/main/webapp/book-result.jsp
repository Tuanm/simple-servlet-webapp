<%@ page import="model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book - Result</title>
</head>
<body>
    <h2>Result</h2>
    <div>
        <% Book book = (Book) request.getAttribute("book"); %>
        <% if (book != null && !book.isTrash()) { %>
            <table>
                <tr>
                    <th>Id</th>
                    <td><%= book.getId() %></td>
                </tr>
                <tr>
                    <th>Title</th>
                    <td><%= book.getTitle() %></td>
                </tr>
                <tr>
                    <th>Author</th>
                    <td><%= book.getAuthor() %></td>
                </tr>
                <tr>
                    <th>Publisher</th>
                    <td><%= book.getPublisher() %></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><%= book.getPrice() %></td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <form action="/book" method="GET">
                            <input type="hidden" name="edit">
                            <input type="hidden" name="id" value="<%= book.getId() %>">
                            <input type="submit" value="Edit">
                        </form>
                        <form action="/book" method="GET">
                            <input type="hidden" name="delete">
                            <input type="hidden" name="id" value="<%= book.getId() %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </table>
        <% } else { %>
            <p>Book Not Found</p>
        <% } %>
    </div>
    <div>
        <a href="/book">Back</a>
    </div>
</body>
</html>
