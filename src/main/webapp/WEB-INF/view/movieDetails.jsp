<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <a href="/movies">Back to Movies Page</a> <br/>
    <c:choose>
        <c:when test="${not empty movie}">
            Title ${movie.title} <br/>
            Mean ${mean}<br/>
            <c:forEach items="${reviews}" var="review">
                ${review.rating}
                ${review.description}
                <br/>
            </c:forEach>
        </c:when>
        <c:otherwise>
            No movie with given id found!
        </c:otherwise>
    </c:choose>
</body>