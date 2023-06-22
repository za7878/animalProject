<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫</title>
</head>
<body>
<form class="PetModel" action="/app/Pet" id="pet">
 <select size="20" id="petName">
       <c:forEach  items="${petList}" var="ss">
	       
	       <option value="${ss.petName}"> 
	       		<c:choose>
			 		<c:when test="${ss.petName eq 'cat' }">
			 			고양이님
			 		</c:when>
			 		<c:when test="${ss.petName eq 'dog' }">
			 			강아지님
			 		</c:when>
			 		<c:when test="${ss.petName eq 'duck' }">
			 			오리님
			 		</c:when>
			 		<c:when test="${ss.petName eq 'pig' }">
			 			돼지님
			 		</c:when>
			 		<c:when test="${ss.petName eq 'woof' }">
			 			늑대님
			 		</c:when>
			 		<c:otherwise><p>NONE</p></c:otherwise>
			 	</c:choose>
	       </option>
       </c:forEach>
    </select>
    <br/><br/>
	 
	<%--  <P>petList : [${petList}]</P> --%>
	 
	 
	 <c:forEach var="p" items="${petList}">
	 	
	 	<c:choose>
	 		<c:when test="${p.petName eq 'cat' }">
	 			<p>고양이님 : <c:out value="${p.petName }" /></p>
	 		</c:when>
	 		<c:when test="${p.petName eq 'dog' }">
	 			<p>강아지님 : <c:out value="${p.petName }" /></p>
	 		</c:when>
	 		<c:when test="${p.petName eq 'duck' }">
	 			<p>오리님 : <c:out value="${p.petName }" /></p>
	 		</c:when>
	 		<c:when test="${p.petName eq 'pig' }">
	 			<p>돼지님 : <c:out value="${p.petName }" /></p>
	 		</c:when>
	 		<c:when test="${p.petName eq 'woof' }">
	 			<p>늑대님 : <c:out value="${p.petName }" /></p>
	 		</c:when>
	 		<c:otherwise><p>NONE</p></c:otherwise>
	 	</c:choose>
	 	<br/>
	 	
	 	
	 </c:forEach>
	 
	<!--  
	 for(int i=0; i<pets.size(); i++) {
	 	PetModel p = pets.get(i);
	   logger.debug("pets[{}] ",p.getPetName());
	 
	 }
	 
	 for(PetModel p : pets) {
				logger.debug("pets[{}] ",p.getPetName());
			} -->
</form>
</body>

<script src='https:code.jquery.com/jQuery-3.5.0.js'></script>
<script>
$(document).on(function(){  
	var message = '${asd}';
	console.log("message: "+message);
	if(message != null && message != undefined && message != '') {
		alert(message);
	}
</script>
</html>