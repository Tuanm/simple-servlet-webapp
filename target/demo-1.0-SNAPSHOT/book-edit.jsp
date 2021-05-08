<%@ page import="model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book - Edit</title>
</head>
<body>
    <h2>Change it!</h2>
    <div>
        <% Book book = (Book) request.getAttribute("book"); %>
        <% if (book != null && !book.isTrash()) { %>
            <form action="/book" method="POST">
                <input type="hidden" name="edit">
                <table>
                    <tr>
                        <th>Id</th>
                        <td>
                            <input type="number" name="id"
                                   value="<%= book.getId() %>">
                        </td>
                    </tr>
                    <tr>
                        <th>Title</th>
                        <td>
                            <input type="text" name="title"
                                   value="<%= book.getTitle() %>">
                        </td>
                    </tr>
                    <tr>
                        <th>Author</th>
                        <td>
                            <input type="text" name="author"
                                   value="<%= book.getAuthor() %>">
                        </td>
                    </tr>
                    <tr>
                        <th>Publisher</th>
                        <td>
                            <input type="text" name="publisher"
                                   value="<%= book.getPublisher() %>">
                        </td>
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td>
                            <input type="number" name="price"
                                   value="<%= book.getPrice() %>">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </table>
            </form>
        <% } %>

    </div>
    <div>
        <a href="/book">Back</a>
    </div>
</body>
</html>
