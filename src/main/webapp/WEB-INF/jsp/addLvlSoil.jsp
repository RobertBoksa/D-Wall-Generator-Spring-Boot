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
        <h1 class="h2">Dodaj kolejną warstwę:</h1>
    </div>

    <div>
        <table class="table">
            <form:form method="post" modelAttribute="lvlSoil">
                                <tr>
                                    <td><form:label path="lvlTop">Góra warstwy gruntu:</form:label></td>
                                    <td><form:input path="lvlTop" value = "${allById[allById.size()-1].lvlBot}"/></td>
                                </tr>

                <tr>
                    <td><form:label path="lvlBot">Dół warstwy gruntu:</form:label></td>
                    <td><form:input path="lvlBot"/></td>
                </tr>

                <tr>
                    <td>
                            <form:label path="soil"/>
                        <form:select path="soil">
                            <form:options items="${soilList}" itemLabel="soilName" itemValue="id"/>
                        </form:select>
                    <td/>
                </tr>


                <tr>
                    <td><input type="submit" value="Dodaj warstwę"></td>
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

