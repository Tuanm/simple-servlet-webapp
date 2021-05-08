<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book - Error</title>
</head>
<body>
    <h2>Whoops!</h2>
    <div>
        <% String error = request.getAttribute("error").toString(); %>
        <p>Message: <%= error %></p>
    </div>
    <div>
        <a href="/book">Back</a>
    </div>
</body>
</html>
