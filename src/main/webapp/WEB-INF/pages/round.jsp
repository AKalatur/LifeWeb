<%--<%@ page import="java.lang.System" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Refresh" content="0.1"/>
<html>

<link rel='stylesheet' href='resources/css/RoundStyle.css' type='text/css'/>

<body>
	<h1 id="s2">ROUND ${count}</h1>

	<form>
		<c:set var="arrL1" value="${fieldN}"/>
		<c:set var="arrL2" value="${fieldK}"/>
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
</body>

</html>
