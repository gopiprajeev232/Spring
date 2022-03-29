<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<title>Home page</title>
	<body>
		<h2>Home Page</h2>
		<hr>
		Welcome to the home page!
		<hr>
		<p>
			User:
			<security:authentication property="principal.username" />
			<br>
			<br>
			Roles:
			<security:authentication property="principal.authorities" />
		</p>
		<hr>
		<security:authorize access="hasRole('MANAGER')">
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
			</p>
		</security:authorize>
		<security:authorize access="hasRole('ADMIN')">
			<p>
				<a href="${pageContext.request.contextPath}/systems">Admins meeting</a>
			</p>
		</security:authorize>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>