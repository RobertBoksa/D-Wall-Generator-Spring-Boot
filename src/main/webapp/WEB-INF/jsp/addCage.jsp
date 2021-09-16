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
        <h1 class="h2">Dodawanie koszy zbrojeniowych</h1>
    </div>

    <div>
        <table class="table">
        <form:form method="post" modelAttribute="cage">
            <tr>
                <td><form:label path="cageName">Nazwę kosza:</form:label></td>
                <td><form:input path="cageName"/></td>
                <td><form:errors path="cageName" class="alert-danger"/></td>
            </tr>
            <tr>
                <td><form:label path="cageWidth">Szerokość kosza:</form:label></td>
                <td><form:input path="cageWidth" type="number" step="0.01"/></td>
                <td><form:errors path="cageWidth" class="alert-danger" /></td>
            </tr>
            <tr>
                <td><form:label path="cageLength">Długość kosza:</form:label></td>
                <td><form:input path="cageLength" type="number" step="0.01"/></td>
                <td><form:errors path="cageLength" class="alert-danger"/></td>
            </tr>
            <tr>
                <td><form:label path="cageHeight">Wysokość kosza:</form:label></td>
                <td><form:input path="cageHeight" type="number" step="0.01"/></td>
                <td><form:errors path="cageHeight" class="alert-danger"/></td>
            </tr>
            <tr>
                <td><form:label path="cageWeight">Ciężar kosza:</form:label></td>
                <td><form:input path="cageWeight" type="number" step="0.01"/></td>
                <td><form:errors path="cageWeight" class="alert-danger"/></td>
            </tr>
            <tr>
                <td><form:label path="cageTopLvl">Poziom góry kosza:</form:label></td>
                <td><form:input path="cageTopLvl" type="number" step="0.01"/></td>
                <td><form:errors path="cageTopLvl" class="alert-danger"/></td>
            </tr>

            <tr>
                <td><input type="submit" value="Zapisz"></td>
                <td></td>
            </tr>
        </form:form>
        </table>
    </div>



</main>
</div>
</div>


</body>
</html>

