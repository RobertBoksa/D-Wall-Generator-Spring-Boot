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
        <h1 class="h2">Dodawanie sekcji</h1>
    </div>

    <div>
        <table class="table">
            <form:form method="post" modelAttribute="section">
                <tr>
                    <td><form:label path="sectionName">Nazwę sekcji:</form:label></td>
                    <td><form:input path="sectionName"/></td>
                    <td><form:errors path="sectionName" class="alert-danger"/></td>
                </tr>
                <tr>
                    <td><form:label path="sectionWidth">Szerokość sekcji:</form:label></td>
                    <td><form:input path="sectionWidth" type="number" step="0.01"/></td>
                    <td><form:errors path="sectionWidth" class="alert-danger"/></td>
                </tr>
                <tr>
                    <td><form:label path="sectionLength">Długość sekcji:</form:label></td>
                    <td><form:input path="sectionLength" type="number" step="0.01"/></td>
                    <td><form:errors path="sectionLength"/></td>
                </tr>
                <tr>
                    <td><form:label path="sectionDepth">Głębokość sekcji:</form:label></td>
                    <td><form:input path="sectionDepth" type="number" step="0.01"/></td>
                    <td><form:errors path="sectionDepth"/></td>
                </tr>
                <tr>
                    <td><form:label path="sectionType">Typ sekcji:</form:label></td>
                    <td><form:select path="sectionType">
                        <form:option value="Otwierająca" label="Otwierająca"/>
                        <form:option value="Następująca" label="Następująca"/>
                        <form:option value="Zamykająca" label="Zamykająca"/>
                    </form:select>
                    </td>
                </tr>

                <c:forEach var="s" begin="0" end="3" step="1">
                    <tr>
                        <td><c:out value="Kosz ${s+1}"/></td>
                        <td>
                            <form:select path="cageList[${s}]">
                            <form:option value="${null}">brak</form:option>
                                <form:options items="${cageLists}" itemLabel="cageName" itemValue="id"/>
                            </form:select>
                        <td/>
                        <td><form:errors path="cageList"/></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td><form:label path="status">Status sekcji:</form:label></td>
                    <td><form:select path="status" itemValue="0">
                        <form:option value="0" label="Nierozpoczęta"/>
                        <form:option value="1" label="Wykonywana"/>
                        <form:option value="2" label="Zamknięta"/>
                    </form:select>
                    </td>
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

