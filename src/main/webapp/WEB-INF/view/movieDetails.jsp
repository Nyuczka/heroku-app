<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <c:choose>
        <c:when test="${not empty movie}">
            Title: ${movie.title} <br/>
        </c:when>
        <c:otherwise>
            No movie with given id found!
        </c:otherwise>
    </c:choose>
</body>