<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<a href='<c:url value="/public"/>'>/public</a>
<br />
<a href='<c:url value="/message/xxx"/>'>/message/xxx</a>
<br />

<a href='<c:url value="/exp"/>'>/exp</a>
<br />

<sec:authorize access="isAuthenticated()">
	<a href='<c:url value="/logout"/>'>/logout</a>
	<br />
</sec:authorize>

<sec:authorize access="not isAuthenticated()">
	<a href='<c:url value="/login"/>'>/login</a>
	<br />
</sec:authorize>