<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>School App</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
	<nav class="navbar navbar-expand-lg bg-info container-fluid">
	  <div class="container-fluid d-flex justify-content-around">
	    <a class="navbar-brand text-light font-weight" href="index.jsp">School App</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active text-light" aria-current="page" href="index.jsp">Accueil</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link text-light" href="CoursServlet">Cours</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link text-light" href="StudentServlet">Etudiants</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</header>