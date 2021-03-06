<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" media="all" href="/css/main.css" />
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />
</head>

<h1>Login</h1>

<form method="POST" action="/login">
	<c:if test="${param.error == 'true'}">
		<div class="error">Authentication failed!</div>
	</c:if>

	<label>Email:<br> <input autofocus autocapitalize="off"
		type="text" name="username" size="40"></label> <label>Password:<br>
		<br /> <input type="password" name="password" size="40"></label> <input
		type="checkbox" name="remember-me" />
	<button type="submit" class="btn btn-primary">Sign-in</button>	

	<sec:csrfInput />	
	<!-- The same as next line -->
	<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> -->
</form>

<jsp:include page="links.jsp" />

</html>