<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
	<main class="container">
   		<h1 class="mt-3">School App - Detail</h1>
 		
		<c:if test="${inscriptions != null}">
		   	<div class="row">
		   		<div class="col-4">
			   		<h3>${inscriptions[0].student.firstName} ${inscriptions[0].student.lastName}</h3>
			   		
			   		<span>Telephone : ${inscriptions[0].student.phone}</span><br>
			   		<span>Date de naissance : ${inscriptions[0].student.birthdate}</span>
		   		</div>
		   		<div class="col-8 row row-cols-1 row-cols-md-3 g-4">
		   			<c:forEach items="${inscriptions}" var="inscription">
			   			<div class="card border-info m-3" style="max-width: 18rem;">
						  <div class="card-header">${inscription.year.name}</div>
						  <div class="card-body">
						    <h5 class="card-title">${inscription.courses.name}</h5>
						    <p class="card-text">${inscription.details}</p>
						  </div>
						</div>
					</c:forEach>
		   		</div>
	   		</div>
		</c:if>
		<c:if test="${inscriptions == null}">
			<p>L'etudiant est inscrite a aucun cours.</p>
		</c:if>
	</main>
	
<%@ include file="/layout/footer.jsp"%>


