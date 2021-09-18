<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 17.09.2021
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>

<h1>Raport sekcji: ${section.sectionName}</h1>
<p></p>
<h4>Data rozpoczęcia sekcji: <fmt:parseDate value="${ section.sectionStart }" pattern="yyyy-MM-dd'T'HH:mm"
                                            var="parsedDateTimeStart" type="both"/>
    <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTimeStart }"/></h4>
<p></p>
<h4>Data zakończenia sekcji: <fmt:parseDate value="${ section.sectionEnd }" pattern="yyyy-MM-dd'T'HH:mm"
                                            var="parsedDateTimeEnd" type="both"/>
    <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTimeEnd }"/></h4>
<p></p>
<h4>W sekcji zostały zamontowane następujące kosze zbrojeniowe: <c:forEach items="${section.cageList}"
                                                                           var="c"> ${c.cageName}, </c:forEach></h4>
<p>Parametry koszy zbrojeniowych:</p>
<table style="width:100%">
    <thead>
    <tr>
        <c:forEach items="${section.cageList}" var="c">
            <th colspan="2">${c.cageName}</th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>

    <tr>
        <c:forEach items="${section.cageList}" var="c">
            <td>Szerokość kosza:</td>
            <td>${c.cageWidth} [m]</td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${section.cageList}" var="c">
            <td>Długość kosza:</td>
            <td>${c.cageLength} [m]</td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${section.cageList}" var="c">
            <td>Wysokość kosza:</td>
            <td>${c.cageHeight} [m]</td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${section.cageList}" var="c">
            <td>Ciężar kosza:</td>
            <td>${c.cageWeight} [t]</td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${section.cageList}" var="c">
            <td>Poziom góry kosza:</td>
            <td>${c.cageTopLvl} [m]</td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${section.cageList}" var="c">
            <td>Poziom spodu kosza:</td>
            <td>${c.cageBotLvl} [m]</td>
        </c:forEach>
    </tr>

    </tbody>
</table>

<h4>Długość sekcji: ${section.sectionLength}</h4>
<p></p>
<h4>Szerokość sekcji: ${section.sectionWidth}</h4>
<p></p>
<h4>Głębokość sekcji: ${section.sectionDepth}</h4>
<p></p>
<h3>Przekrój geologiczny sekcji:</h3>
<div>
    <div>
        <table>
            <tr>
                <th>Głębokość</th>
                <c:forEach items="${section.diggingList}" var="dl">
                    <th>${dl.partName}</th>
                </c:forEach>
            </tr>
            <c:forEach begin="0" end="${maxDepth * 2}" step="1" var="i">
                <tr>
                    <td>${i/2}</td>
                    <td>${map.get(1).get(i)}</td>
                    <td>${map.get(2).get(i)}</td>
                    <td>${map.get(3).get(i)}</td>
                    <td>${map.get(4).get(i)}</td>
                    <td>${map.get(5).get(i)}</td>
                    <td>${map.get(6).get(i)}</td>
                    <td>${map.get(7).get(i)}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div>
        <h3>Przebieg betonowania sekcji:</h3>
        <table>
            <tr>
                <th>Wysokość betonu</th>
                <th>Ilość betonu na warstwe</th>
                <th>Skumulowana ilość betonu</th>
            </tr>

            <c:set var="concStep" value="${0}"/>
            <c:forEach items="${section.concreteList}" var="cl">
                <c:set var="concStep" value="${concStep + cl.concreteValue}"/>
                <tr>
                    <td>${maxDepth - cl.bentoniteHeight} [mb]</td>
                    <td>${cl.concreteValue} [m3]</td>
                    <td>${concStep} [m3]</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <h3>Teoretyczna ilość betonu:  ${section.theoreticalConcrete}</h3>
        <br>
        <h3>Całkowita ilość betonu:  ${conCount}</h3>
        <br>
        <h3>Nadkonsumpcja betonu:  ${conCount - section.theoreticalConcrete}</h3>
    </div>



</div>


</body>
</html>
