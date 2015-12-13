<%--suppress XmlDuplicatedId --%>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<html>
<head>
    <link rel='stylesheet' href='resources/css/Style.css' type='text/css'/>
</head>

<body>
	<form action="/Life">
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
