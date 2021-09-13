<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 08.09.2021
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>


<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Rozpocznij kopanie:</h1>
    </div>

    <div>
        <h3>Przebieg kopania</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Góra warstwy gruntu</th>
                <th scope="col">Spod warstwy gruntu</th>
                <th scope="col">Grubość warstwy</th>
                <th scope="col">Rodzaj gruntu</th>
                <th scope="col"></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${allById}" var="all">
                <tr>
                    <td>${all.lvlTop}</td>
                    <td>${all.lvlBot}</td>
                    <td>${all.lvlBot - all.lvlTop}</td>
                    <td>${all.soil.soilName}</td>
                    <td><a href="">Edytuj</a></td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
        <a class="btn btn-primary" href="/lvlSoil/${id}" role="button">Dodaj kolejną warstwę</a>
        <a class="btn btn-danger" href="/lvlSoil/end/${id}" role="button">Zakończ kopanie</a>
    </div>



</main>
</div>
</div>


</body>
</html>

