<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h1>Todo List!</h1>
    
    <form action="${ pageContext.request.contextPath  }/todo/list" method = "post">
    	<label for= "todo Title"> Add a new todo: </label>
    	<input type = "text" id = "todoTitle" name = "todoTitle" placeholder = "Enter todo title">
    	<button type = "submit"> Add </button>
    	
    </form>
    	<h2>Todo List</h2>
    	<ul> 
    		<c:forEach var = "todo" items = "${todos}"> 
    	
    		<li>
    			<strong>${todo.todoTitle}</strong>
    			-Created At : ${todo.createdAt}
    			-Status: <c:if test = "${todo.finished }">finished </c:if>
    				<c:if test = "${!todo.finished }">pending </c:if>
    				
    				<form action="${ pageContext.request.contextPath }/todo/finish/${todo.todoId}" method="post" style="display:inline;">
                   
                    	<button type="submit">Finish</button>
                	</form>
                	<form action="${pageContext.request.contextPath}/todo/edit/${todo.todoId}" method="get" style="display:inline;">
               			 
               			 <button type="submit">Edit</button>
            		</form>
    		</li>
    		</c:forEach> 	
    	</ul>
   
    	
    	
    
    
    
    
    
    
    
   <!-- <p>Welcome to the JSP page served by Spring Boot.</p>

    <p>The current date and time is: </p>

    <!-- Add a link to go back to the homepage or other routes -->
    <a href="/">Go back to Home</a>
</body>
</html>
