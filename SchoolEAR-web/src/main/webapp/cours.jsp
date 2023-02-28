<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
	<main class="container">
   		<h1 class="mt-3">School App - Cours</h1>
   		<hr>
   		<div class="row">
	   		<div class="col-7">
	   			<h2 class="my-5">Liste des cours</h2>
	   			<c:if test="message">
	   				<div class="alert alert-success" role="alert">
                          <%= request.getAttribute("message") %>
                      </div>
	   			</c:if>
	   			<c:if test="erreur">
	   				<div class="alert alert-danger" role="alert">
                          <%= request.getAttribute("erreur") %>
                     </div>
	   			</c:if>
	   			<hr>
	   			<table class="table table-striped table-hover">
	   				<thead> 
	   					<tr>
		   					<th>Identifiant</th>
		   					<th>Nom</th>
		   					<th>Progarmme</th>
		   					<th>Action</th>
	  					</tr>
	   				</thead>
	   				<tbody>
		   				<c:forEach items="${cours}" var="cours">
	                    	<tr>
	                    		<td>${cours.id}</td>
	                        	<td>${cours.name}</td>
	                        	<td>${cours.programme}</td>
	                        	<td class="flex">
                                    <a href="CoursServlet?action=delete&id=${cours.id}" id="${cours.id}-delete" class="btn text-danger">
                                        <img src="https://img.icons8.com/ios/50/000000/delete-forever.png" width="20" height="20" alt="delete"/>
                                    </a>
                                    <a href="CoursServlet?action=detail&id=${cours.id}" id="${cours.id}-edit" class="btn text-success">
                                        <img src="https://img.icons8.com/ios/50/000000/edit.png" width="20" height="20" alt="edit"/>
                                    </a>
                                </td>
	                    	</tr>
	                	</c:forEach>
	 				</tbody>
	   			</table>
	   		</div>
	   		<div class="col-5">
	   			<h2 class="my-5">Formulaire</h2>
	   			<c:if test="${course == null}">
					<form method="post" action="CoursServlet?action=add">
		   				<input type="text" class="form-control mb-3" name="name" placeholder="Nom" required/>
		   				<input type="text" class="form-control mb-3" name="programme" placeholder="Programme" required/>
		   				<input type="submit" class="btn btn-info mb-3 form-control" value="Enregistrer"/>
	   				</form>
	   			</c:if>
	   			<c:if test="${course != null}">
	   				<form method="post" action="CoursServlet?action=edit">
	   					<c:if test="${course != null}">
		                  <input type="hidden" name="id" value="<c:out value='${course.id}'/>" />
		                </c:if>
		   				<input type="text" class="form-control mb-3" name="name" placeholder="Nom" value="<c:out value='${course.name}'/>" required/>
		   				<input type="text" class="form-control mb-3" name="programme" placeholder="Programme" value="<c:out value='${course.programme}'/>" required/>
		   				<input type="submit" class="btn btn-info mb-3 form-control" value="Modifier"/>
		   			</form>
	   			</c:if>
			   			
	   		</div>
   		</div>
	</main>
	
<%@ include file="/layout/footer.jsp"%>


