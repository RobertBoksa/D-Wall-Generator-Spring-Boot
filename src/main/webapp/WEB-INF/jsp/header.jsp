<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 08.09.2021
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="generator" content="Hugo 0.88.1">
    <title>D-wall Generator</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="/css/dashboard.css" rel="stylesheet">

</head>
<body>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company name</a>
        <div class="navbar-brand col-md-3 col-lg-2 me-0 px-3">
            <p>Witaj ${pageContext.request.remoteUser}</p>
        </div>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
          <a class="nav-link px-3" href="/logout">Wyloguj</a>
        </div>
    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">
                            <span data-feather="home"></span>
                            Menu g????wne
                        </a>
                    </li>

                    <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/section/">
                                <span data-feather="file"></span>
                                Lista sekcji
                            </a>
                        </li>
                    </c:if>



                    <li class="nav-item">
                        <a class="nav-link" href="/digging/">
                            <span data-feather="shopping-cart"></span>
                            Rozpocznij kopanie
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/digging/reports">
                            <span data-feather="shopping-cart"></span>
                            Raporty z kopania sekcji
                        </a>
                    </li>

                    <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/concrete/">
                            <span data-feather="bar-chart-2"></span>
                            Betonowanie
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/admin/cage/">
                            <span data-feather="layers"></span>
                            Kosze zbrojeniowe
                        </a>
                    </li>
                    </c:if>

                </ul>
            </div>
        </nav>
