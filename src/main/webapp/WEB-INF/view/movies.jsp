<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Rating</th>
        </tr>
        <tr>
            <c:forEach var="movie" items="${movies}">
                <td>${movie.title}</td>
                <td>${movie.description}</td>
                <td>${movie.rating}</td>
            </c:forEach>
        </tr>
    </table>
</body>