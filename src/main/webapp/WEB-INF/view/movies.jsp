<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Year</th>
            <th>Director</th>
            <th>Description</th>
        </tr>
        <tr>
            <c:forEach var="movie" items="${movies}">
                <td>${movie.title}</td>
                <td>${movie.year}</td>
                <td>${movie.director}</td>
                <td>${movie.description}</td>
            </c:forEach>
        </tr>
    </table>
</body>