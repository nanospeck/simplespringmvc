<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
	<title>ING Bank ATM Locations</title>
	<link rel='stylesheet' href='<c:url value="style.css" />' type='text/css' media='all' /> 
</head>
<body>
	<h2>ING Bank ATM Locations</h2>

	<p>Welcome, ${name} 
    | <a href="<c:url value="/logout" />" > Logout</a> </p>
	
	<c:if test="${not empty branches}">

		<ul>
			<c:forEach var="listValue" items="${branches}">
				<li>${listValue.address.street},${listValue.address.housenumber},${listValue.address.postalcode},${listValue.address.city}</li>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>