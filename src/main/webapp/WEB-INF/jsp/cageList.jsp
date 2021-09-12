<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 08.09.2021
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>


        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Lista Sekcji</h1>

            </div>

            <div>
                <h3>Rozpoczęte sekcje</h3>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Nazwa</th>
                        <th scope="col">Długość</th>
                        <th scope="col">Szerokość</th>
                        <th scope="col">Wysokość</th>
                        <th scope="col">Całkowita ilość</th>
                        <th scope="col">Góra zbrojenia</th>
                        <th scope="col">Dół zbrojenia</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>

<%--   Dokończyć formularz                 --%>
                    <c:forEach items="${allCag}" var="c">
                            <tr>
                                <th scope="row">${c.cageName}</th>
                                <td>${c.cageLength}</td>
                                <td>${c.cageWidth}</td>
                                <td>${c.cageHeight}</td>
                                <td>${c.sectionList.size()}</td>
                                <td>${c.cageTopLvl}</td>
                                <td>${c.cageBotLvl}</td>
                                <td><a href="/admin/cage/update?id=${c.id}">Edytuj</a></td>
                                <td><a href="">Szczegóły</a></td>
                                <td><a href="/admin/cage/delete/${c.id}">Usuń</a></td>
                            </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </main>
    </div>
</div>


</body>
</html>
