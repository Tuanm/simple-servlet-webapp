<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book - Create</title>
</head>
<body>
    <h2>Create new book!</h2>
    <div>
        <form action="/book?create" method="POST">
            <table>
                <tr>
                    <th>Id</th>
                    <td>
                        <input type="number" name="id">
                    </td>
                </tr>
                <tr>
                    <th>Title</th>
                    <td>
                        <input type="text" name="title">
                    </td>
                </tr>
                <tr>
                    <th>Author</th>
                    <td>
                        <input type="text" name="author">
                    </td>
                </tr>
                <tr>
                    <th>Publisher</th>
                    <td>
                        <input type="text" name="publisher">
                    </td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td>
                        <input type="number" name="price">
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <input type="submit" value="Create">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div>
        <a href="/book">Back</a>
    </div>
</body>
</html>
