<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>App - ${user}</title>
<link rel="stylesheet" type="text/css" media="all" href="/css/main.css" />
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />
</head>
<body>
	<div class="container">
		<div>User=${user}</div>
		<div>Role=${role}</div>
	</div>
</body>

</html>
