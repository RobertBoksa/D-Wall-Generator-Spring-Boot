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
        <h1 class="h2">Lista raportów z kopania</h1>
    </div>

    <div>
        <c:forEach items="${allSections}" var="s">
            <h3>Nazwa sekcji: ${s.sectionName} : </h3>
            <table class="table">

                <c:forEach items="${s.diggingList}" var="dl">
                    <thead>
                    <tr>
                        <th scope="col">${dl.partName}: długość zbioru ${dl.partLength} [m]</th>
                        <th scope="col">Grunt:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dl.lvlSoilList}" var="l">
                        <tr>
                            <td>${l.lvlTop} [m] - ${l.lvlBot} [m]</td>
                            <td>${l.soil.soilName}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
        </c:forEach>
    </div>
</main>
</div>
</div>


</body>
</html>
