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
                <h1 class="h2">Menu główne</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group me-2">
                        <a href="" type="button" class="btn btn-sm btn-outline-secondary">Drukuj raport</a>
                        <a href="" type="button" class="btn btn-sm btn-outline-secondary">Drukuj ukończone raporty</a>
                    </div>
                </div>
            </div>

            <div>
            <h3>Wykonane sekcje</h3>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                </div>
            </div>

            <br>
            <br>
            <div>
                <a class="btn btn-primary" href="/admin/section/add" role="button">Dodaj nową sekcję +</a>
                <a class="btn btn-primary" href="/admin/cage/add" role="button">Dodaj nowy kosz +</a>
            </div>


        </main>
    </div>
</div>


</body>
</html>
