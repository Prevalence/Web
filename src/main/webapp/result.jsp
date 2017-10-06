<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="servlet.Email"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div align="center">
	<%
		String mailAdd = request.getParameter("mailAdd");
		Email email = new Email(mailAdd);
		if (email.isEmail()) {
			out.println(mailAdd + " is right");
		} else {
			out.println(mailAdd + " is not right");
		}
	%>
	<a href="index.jsp">返回</a>
</div>