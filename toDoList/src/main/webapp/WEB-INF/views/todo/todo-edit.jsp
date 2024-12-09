

<form action="${pageContext.request.contextPath}/todo/update" method="post">
    <input type="hidden" name="id" value="${todo.todoId}">
    <label for="todoTitle">Todo Title:</label>
    <input type="text" id="todoTitle" name="todoTitle" value="${todo.todoTitle}" required>
    
    <label for="finished">Status:</label>
    <select id="finished" name="finished">
        <option value="false" ${!todo.finished ? 'selected' : ''}>Pending</option>
        <option value="true" ${todo.finished ? 'selected' : ''}>Finished</option>
    </select>
    
    <button type="submit">Update</button>
</form>


