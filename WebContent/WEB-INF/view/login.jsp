<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Вхід | Віртуальна Залізнична Каса</title>
<link rel="stylesheet" type="text/css" href="resources/style/style.css" />
</head>
<body>
	<div id="wrapper">
		<h1>
			Ласкаво просимо до<br />Віртуальної Залізничної Каси!
		</h1>
		<h3><font color="red">
		   <c:if test="${not empty notActivated and notActivated eq 'true'}">
		      Обліковий запис ще не активовано
		   </c:if>
		   <c:if test="${not empty notExists and notExists eq 'true'}">
		      Обліковий запис не знайдено
		   </c:if>
		   </font>
		</h3>
		<form action="controller" method="post">
		<input type="hidden" name="command" value="login"> 
			<table style="margin: auto">
				<tr>
					<td style="text-align: left">E-mail:</td>
					<td><input name="login" size="35" required /></td>
				</tr>
				<tr>
					<td style="text-align: left">Пароль:</td>
					<td><input name="password" type="password" size="35"
						maxlength="35" required /></td>
				</tr>
			</table>
			<table style="margin: auto">
				<tr>
					<td><input type="submit" class="button-accept"
					    name="login"
						value="Войти" /></td>
				
			</table>
		</form>
		<form action="controller" method="get">
		<input type="hidden" name="page" value="registration"> 
		<input type="hidden" name="command" value="commandNavBar">
			<input type="submit" class="button-register"
			name="register" value="Зареєструватись" />
		</form>
	</div>
</body>
</html>