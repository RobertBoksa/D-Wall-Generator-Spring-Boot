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
        <h1 class="h2">Czy chcesz usunąć kosz zbrojeniowy o nazwie: ${cage.cageName}</h1>
    </div>
    <c:if test="${empty cage.sectionList}">
        <a class="btn btn-primary" href="/admin/cage/" role="button"> -- NIE -- </a>
        <a class="btn btn btn-danger" href="/admin/cage/deleteAccepted?id=${cage.id}" role="button"> -- TAK -- </a>
    </c:if>

    <c:if test="${not empty cage.sectionList}">
        <h3>Nie można usunąć tego kosza gdyż jest używany w sekcji.</h3>
        <a class="btn btn-primary" href="/admin/cage/" role="button"> -- Powrót -- </a>
    </c:if>




</main>
</div>
</div>


</body>
</html>

