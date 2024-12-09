<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello Page</title>
</head>
<body>
    <h1>Hello, JSP in Spring Boot!</h1>
    <p>Welcome to the JSP page served by Spring Boot.</p>

    <p>The current date and time is: <%= new java.util.Date() %></p>

    <!-- Add a link to go back to the homepage or other routes -->
    <a href="/">Go back to Home</a>
</body>
</html>
