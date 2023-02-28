<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
	<main class="container">
   		<h1 class="mt-3">School App - Etudiant</h1>
   		<hr>
   		<div class="row">
	   		<div class="col-8">
	   			<h2 class="my-5">Liste des Etudiant</h2>
	   			<hr>
	   			<c:if test="${message}">
	   				<div class="alert alert-success" role="alert">${message}</div>
	   			</c:if>
	   			<c:if test="${erreur}">
	   				<div class="alert alert-danger" role="alert">${erreur}</div>
	   			</c:if>
	   			<table class="table table-striped table-hover">
	   				<thead> 
	   					<tr>
		   					<th>Identifiant</th>
		   					<th>Prenom</th>
		   					<th>Nom</th>
		   					<th>Date de naissance</th>
		   					<th>Téléphone</th>
		   					<th>Action</th>
	  					</tr>
	   				</thead>
	   				<c:forEach items="${etudiants}" var="etudiants">
	                    	<tr>
	                    		<td>${etudiants.id}</td>
	                        	<td>${etudiants.firstName}</td>
	                        	<td>${etudiants.lastName}</td>
	                        	<td>${etudiants.birthdate}</td> 
	                        	<td>${etudiants.phone}</td>
	                        	<td class="flex">
	                        		<a href="InscriptionServlet?action=view&id=${etudiants.id}" id="${etudiants.id}-view" class="btn text-success">
                                        <img src="https://icons8.com/icon/986/eye" width="20" height="20" alt="view"/>
                                    </a>
                                    <a href="StudentServlet?action=delete&id=${etudiants.id}" id="${etudiants.id}-delete" class="btn text-danger">
                                        <img src="https://img.icons8.com/ios/50/000000/delete-forever.png" width="20" height="20" alt="delete"/>
                                    </a>
                                    <a href="StudentServlet?action=detail&id=${etudiants.id}" id="${etudiants.id}-edit" class="btn text-success">
                                        <img src="https://img.icons8.com/ios/50/000000/edit.png" width="20" height="20" alt="edit"/>
                                    </a>
                                    <a class="btn btn-info text-light" href="InscriptionServlet?action=inscription&id=${etudiants.id}">
                                    	Inscription
                                    </a>
                                </td>
	                    	</tr>
	                	</c:forEach>
	 				</tbody>
	   			</table>
	   		</div>
	   		<div class="col-4">
	   			<h2 class="my-5">Formulaire</h2>
	   			<c:if test="${etudent == null}">
		   			<form method="post" action="StudentServlet?action=add">
		   				<input type="text" class="form-control mb-3" name="lastName" placeholder="Nom" required/>
		   				<input type="text" class="form-control mb-3" name="firstName" placeholder="Prenom" required/>
		   				<input type="datetime-local" class="form-control mb-3" name="birthdate" placeholder="Date de naissance" required/>
		   				<input type="number" class="form-control mb-3" name="phone" placeholder="Téléphone" required/>
		   				<input type="submit" class="btn btn-info mb-3 form-control" value="Enregistrer"/>
		   			</form>
	   			</c:if>
	   			
	   			<c:if test="${etudent != null}">
		   			<form method="post" action="StudentServlet?action=edit">
		   				<c:if test="${etudent != null}">
		                  <input type="hidden" name="id" value="<c:out value='${etudent.id}'/>" />
		                </c:if>
		   				<input type="text" class="form-control mb-3" name="lastName" placeholder="Nom" value="<c:out value='${etudent.lastName}'/>" required/>
		   				<input type="text" class="form-control mb-3" name="firstName" placeholder="Prenom" value="<c:out value='${etudent.firstName}'/>" required/>
		   				<input type="datetime-local" class="form-control mb-3" name="birthdate" placeholder="Date de naissance" value="<c:out value='${etudent.birthdate}'/>" required/>
		   				<input type="number" class="form-control mb-3" name="phone" placeholder="Téléphone" value="<c:out value='${etudent.phone}'/>" required/>
		   				<input type="submit" class="btn btn-info mb-3 form-control" value="Modifier"/>
		   			</form>
	   			</c:if>
	   		</div>
   		</div>
	</main>
	
<%@ include file="/layout/footer.jsp"%>


