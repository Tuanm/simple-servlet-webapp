<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book - Search</title>
</head>
<body>
    <h2>Search by</h2>
    <div>
        <form action="/book" method="GET">
            <input type="hidden" name="search">
            <table>
                <tr>
                    <th>Id</th>
                    <td>
                        <input type="number" name="id">
                    </td>
                    <td>
                        <input type="submit" value="Find">
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
