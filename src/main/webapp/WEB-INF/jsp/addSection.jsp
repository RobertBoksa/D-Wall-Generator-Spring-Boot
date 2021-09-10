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
                </tr>
                <tr>
                    <td><form:label path="sectionWidth">Szerokość sekcji:</form:label></td>
                    <td><form:input path="sectionWidth"/></td>
                </tr>
                <tr>
                    <td><form:label path="sectionLength">Długość sekcji:</form:label></td>
                    <td><form:input path="sectionLength"/></td>
                </tr>
                <tr>
                    <td><form:label path="sectionDepth">Głębokość sekcji:</form:label></td>
                    <td><form:input path="sectionDepth"/></td>
                </tr>
                <tr>
                    <td><form:label path="sectionType">Typ sekcji:</form:label></td>
                    <td><form:select path="sectionType">
                        <form:option value="o" label="Otwierająca"/>
                        <form:option value="n" label="Następująca"/>
                        <form:option value="z" label="Zamykająca"/>
                    </form:select>
                    </td>
                </tr>

                <tr>
                    <td><input type="submit" value="Zapisz"></td>
                    <td></td>
                </tr>


                <tr>


                    <c:forEach var="s" begin="1" end="4" step="1">
                        <td><c:out value="Kosz ${s}"/></td>
                        <%--                        <td>  <select id=`cage${s}`>--%>
                        <%--                                <option>brak</option>--%>
                        <%--                            <c:forEach items="${}" var="c">--%>
                        <%--                                <option>${c.cageName}</option>--%>
                        <%--                            </c:forEach>--%>
                        <%--                        </select></td>--%>


                        <td>
                                <form:label path="cageList"/>
                            <form:select path="cageList">
                                <form:options items="${cageList}" itemLabel="cageName" itemValue="id"/>
                            </form:select>
                        <td/>
                    </c:forEach>

                </tr>


            </form:form>
        </table>
    </div>


</main>
</div>
</div>


</body>
</html>

