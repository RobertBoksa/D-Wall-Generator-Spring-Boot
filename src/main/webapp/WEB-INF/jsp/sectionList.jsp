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
                <th scope="col">Głębokość</th>
                <th scope="col">Szerokość</th>
                <th scope="col">Kosze</th>
                <th scope="col">Typ</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>


            <c:forEach items="${allSec}" var="s">
                <c:if test="${s.status == 1}">
                    <tr>
                        <th scope="row">${s.sectionName}</th>
                        <td>${s.sectionLength}</td>
                        <td>${s.sectionDepth}</td>
                        <td>${s.sectionWidth}</td>
                        <td><c:forEach items="${s.cageList}" var="c">
                            ${c.cageName},
                        </c:forEach>
                        </td>
                        <td>${s.sectionType}</td>
                        <td><a href="/admin/section/update?id=${s.id}">Edytuj</a></td>
                        <td><a href="/admin/report/${s.id}">Szczegóły</a></td>
                        <c:if test="${not empty s.concreteList}">
                            <td><a href="/admin/section/close/${s.id}">Zakończ</a></td>
                        </c:if>

                    </tr>
                </c:if>
            </c:forEach>


            </tbody>
        </table>
    </div>
    <div>
        <br>
        <br>
    </div>

    <div>
        <h3>Niewykonane sekcje</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Nazwa</th>
                <th scope="col">Długość</th>
                <th scope="col">Głębokość</th>
                <th scope="col">Szerokość</th>
                <th scope="col">Kosze</th>
                <th scope="col">Typ</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allSec}" var="s">
                <c:if test="${s.status == 0}">
                    <tr>
                        <th scope="row">${s.sectionName}</th>
                        <td>${s.sectionLength}</td>
                        <td>${s.sectionDepth}</td>
                        <td>${s.sectionWidth}</td>
                        <td><c:forEach items="${s.cageList}" var="c">
                            ${c.cageName},
                        </c:forEach>
                        </td>
                        <td>${s.sectionType}</td>
                        <td><a href="/admin/section/update?id=${s.id}">Edytuj</a></td>
                        <td><a href="/admin/report/${s.id}">Szczegóły</a></td>
                        <td><a href="/admin/section/delete/${s.id}">Usuń</a></td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div>
        <br>
        <br>
    </div>

    <div>
        <h3>Wykonane sekcje</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Nazwa</th>
                <th scope="col">Długość</th>
                <th scope="col">Głębokość</th>
                <th scope="col">Szerokość</th>
                <th scope="col">Kosze</th>
                <th scope="col">Typ</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${allSec}" var="s">
                <c:if test="${s.status == 2}">
                    <tr>
                        <th scope="row">${s.sectionName}</th>
                        <td>${s.sectionLength}</td>
                        <td>${s.sectionDepth}</td>
                        <td>${s.sectionWidth}</td>
                        <td><c:forEach items="${s.cageList}" var="c">
                            ${c.cageName},
                        </c:forEach>
                        </td>
                        <td>${s.sectionType}</td>
                        <td><a href="/admin/section/update?id=${s.id}">Edytuj</a></td>
                        <td><a href="/admin/report/${s.id}">Szczegóły</a></td>
                        <td><a href="/admin/section/delete/${s.id}">Usuń</a></td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</div>
</div>


</body>
</html>
