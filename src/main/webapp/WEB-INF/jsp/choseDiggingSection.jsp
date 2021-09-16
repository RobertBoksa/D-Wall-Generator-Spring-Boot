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
        <table class="table">
            <form:form  method="post" modelAttribute="digging">
                <tr>
                    <td><form:label path="sectionDigg">Nazwę sekcji:</form:label></td>
                    <td><form:select path="sectionDigg" items="${sections}" itemValue="id" itemLabel="sectionName"/></td>
                </tr>
                <tr>
                    <td><form:label path="partName"/>Podaj nazwę zbioru:</td>
                    <td><form:select path="partName">
                        <form:option value="Z1"/>
                        <form:option value="Z2"/>
                        <form:option value="Z3"/>
                        <form:option value="Z4"/>
                        <form:option value="S:1-2"/>
                        <form:option value="S:2-3"/>
                        <form:option value="S:3-4"/>
                    </form:select></td>
                </tr>

                <tr>
                    <td><form:label path="partLength"/>Podaj długość zbioru:</td>
                    <td><form:input path="partLength"/></td>
                    <td><form:errors path="partLength" class="alert-danger"/></td>
                </tr>



                <tr>
                    <td><input type="submit" value="Rozpocznij"></td>
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

