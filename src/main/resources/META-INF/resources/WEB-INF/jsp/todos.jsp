     <%@ include file="common/header.jspf" %>
     <%@ include file="common/navigation.jspf" %>
    <div class="container">
    <h1>Welcome ${name} </h1>
    <hr>
    <h2>Your TodoList</h2>
    <table class="table">
    <thead>
    <tr>
        <th>description</th>
        <th> Target date</th>
        <th>Done</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}"  var="todo" >
       <tr>
            <td>${todo.description}</td>
            <td>${todo.targetdate}</td>
            <td>${todo.done}</td>   
            <td> <a href="todo-delete?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
            <td> <a href="todo-update?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
       </tr>
    </c:forEach>
    </tbody>
     
    </table>
    <a href="add-todo" class="btn btn-success" >Add Todo</a>
    </div>
    <%@ include file="common/footer.jspf" %>
