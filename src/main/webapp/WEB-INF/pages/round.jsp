<%--<%@ page import="java.lang.System" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Refresh" content="0.25"/>
<html>
<head>
	<link href="<c:url value="/resources/css/RoundStyle.css" />" rel="stylesheet">
</head>

<body>
	<h1 id="s2">ROUND ${count}</h1>

	<form>
		<c:set var="arrL1" value="${arrL1}"/>
		<c:set var="arrL2" value="${arrL2}"/>
		<table>
		<c:forEach var="i" begin="0" end="${arrL1}">
			<tr>
		<c:forEach var="j" begin="0" end="${arrL2}">
			<c:if test="${arr[i][j] == 0}">
				<td bgcolor=#00008b></td>
			</c:if>
			<c:if test="${arr[i][j] == 1}">
				<td bgcolor=red></td>
			</c:if>
		</c:forEach>
		</tr>
	</c:forEach>
		</table>
	</form>

	<h1 id="s3">${message}</h1>

	<form action="/">
		<button type="submit" submit>TRY AGAIN</button>
	</form>

</body>

</html>
