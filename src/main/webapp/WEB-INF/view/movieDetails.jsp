<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <a href="/movies">Back to Movies Page</a> <br/>
    <div align="center">
        <c:choose>
            <c:when test="${not empty movie}">
                Title ${movie.title} <br/>
                <c:if test="${not empty mean}">
                    Mean ${mean}<br/>
                </c:if>
                <table border="1">
                    <tr>
                        <th>Rating</th>
                        <th>Opinion</th>
                    </tr>
                    <c:forEach items="${reviews}" var="review">
                        <tr>
                            <td>${review.rating}</td>
                            <td>${review.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                No movie with given id found!
            </c:otherwise>
        </c:choose>
    </div>
</body>