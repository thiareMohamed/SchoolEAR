<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
	<main class="container">
   		<h1 class="mt-3">School App - Inscription</h1>
   		<form method="post" action="InscriptionServlet?action=add" class="m-auto w-25 my-5">
			<select class="form-control mb-3" name="etudiantId" id="etudiant" desibled="true">
				<option selected value="${etudiant.id}">${etudiant.firstName} ${etudiant.lastName}</option>
			</select>
			<select class="form-control mb-3" name="coursId" id="cours">
				<c:forEach items="${cours}" var="cour">
					<option value="${cour.id}">${cour.name}</option>
				</c:forEach>
			</select>
			<textarea rows="4" cols="" class="form-control mb-3" placeholder="Message" name="details"></textarea>
			<input type="submit" class="btn btn-info mb-3 form-control text-light" value="Inscription"/>
		</form>
	</main>
	
<%@ include file="/layout/footer.jsp"%>


