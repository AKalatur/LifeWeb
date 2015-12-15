<%--suppress XmlDuplicatedId --%>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href="<c:url value="/resources/css/Style.css" />" rel="stylesheet">
</head>

<body>
	<form action="/redirect">
		<table class="table">
			<tr>
				<th colspan='3' id='s1'>INPUT SIZE OF ARRAY N*K</th>
			</tr>
			<tr>
				<td align='center' id='s2'>N:</td>
				<td colspan='2'><input type='number' value='5' min='5' max='100' name='fieldN' onkeyup='this.value=parseInt(this.value) | 0'/></td>
			</tr>
			<tr>
				<td align='center' id='s2'>K:</td>
				<td colspan='2'><input type='number' value='5' min='5' max='100' name='fieldK' onkeyup='this.value=parseInt(this.value) | 0'/></td>
			</tr>
			<tr>
				<td align='center' colspan='3'><button type='submit'>START</button>
			</tr>
		</table>
	</form>
</body>
</html>
