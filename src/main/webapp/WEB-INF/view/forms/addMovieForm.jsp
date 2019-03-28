<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<div id="container">
    <a href="/movies">Back to movies</a>
    <h3>Save Movie</h3>

    <form:form action="saveMovie" modelAttribute="movie" method="post">
        <table>
            <tr>
                <td><label>Title: </label></td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td><label>Year: </label></td>
                <td><form:input path="year" type="number"/></td>
            </tr>
            <tr>
                <td><label>Director: </label></td>
                <td><form:input path="director"/></td>
            </tr>
            <tr>
                <td><label>Description: </label></td>
                <td><form:input path="description"/></td>
            </tr>
            <tr><td><input type="submit" value="Save" class="save"/></td></tr>
        </table>
    </form:form>


</div>
</body>