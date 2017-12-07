<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hello World</title>
<s:head />
</head>
<body>
	<s:form action="register">
		<s:textfield name="userName" label="UserName" />
		<s:textfield name="password" label="Password" />
		<s:submit />
		<hr />
		<table>
			<tr>
				<td>UserName</td>
				<td>Password</td>
			</tr>
			<s:iterator value="userList">
				<tr>
					<td><s:property value="userName" /></td>
					<td><s:property value="password" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
</body>
</html>