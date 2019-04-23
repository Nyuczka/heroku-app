<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>
    <a href="/">Back to Homepage</a>
    <table class="movies-table">
        <tr>
            <th>Title</th>
            <th>Year</th>
            <th>Director</th>
            <th>Description</th>
            <th>Average Review</th>
            <th>Action</th>
        </tr>
        <c:forEach var="movieWithMean" items="${movieWithMeans}">
            <c:url var="detailsLink" value="/movies/${movieWithMean.movie.movieId}"/>
            <tr>
                <td>${movieWithMean.movie.title}</td>
                <td>${movieWithMean.movie.year}</td>
                <td>${movieWithMean.movie.director}</td>
                <td>${movieWithMean.movie.description}</td>
                <td>${movieWithMean.mean}</td>
                <td><a href="${detailsLink}">Show details</a></td>
            </tr>
        </c:forEach>
    </table>
    <p align="center"><input type="button" value="Add movie" onclick="window.location.href='/movies/showAddMovieForm'; return false;"/></p>
</body>