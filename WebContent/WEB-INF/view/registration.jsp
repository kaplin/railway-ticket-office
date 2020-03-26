<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Реєстрація | Віртуальна Залізнична Каса</title>
<link rel="stylesheet" type="text/css" href="resources/style/style.css" />
</head>
<body>
	<div id="wrapper">
		<h1>Реєстрація нового користувача</h1>
		<h3>
			<font color="red"> <c:if
					test="${not empty passwordNotMatch and passwordNotMatch eq 'true'}">
		      Введені паролі не співпадають
		    </c:if> <c:if
					test="${not empty userNotCreated and userNotCreated eq 'true'}">
		       Користувач з такими даними вже зареєстрований
		    </c:if>
			</font>
		</h3>
		<form action="controller" method="post">
			<table style="margin: auto; text-align: left">
				<tr>
					<td>Login:</td>
					<td><input type="text" name="login" size="35" required /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><input name="email" type="email" size="35" required /></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type="text" name="password" type="password" size="35"
						maxlength="35" required /></td>
				</tr>
				<tr>
					<td>Підтвердіть пароль:</td>
					<td><input name="passwordConfirm" type="password" size="35"
						maxlength="35" required /></td>
				</tr>
				<tr>
					<td>Прізвище:</td>
					<td><input name="surname" type="text" size="35" maxlength="35"
						required /></td>
				</tr>
				<tr>
					<td>Ім'я:</td>
					<td><input name="name" type="text" size="35" maxlength="35"
						required /></td>
				</tr>
			</table>
			<table style="margin: auto">
				<tr>
					<td>
						<form action="controller" method="post">
						<input type="hidden" name="command" value="registerUser"> 
						<input type="submit" class="button-accept"
						value="Підтвердити" />
						</form> 

					</td>
					<td><a class="link-cancel" href="/RailwayOfficeSystem/login">
							Відмінити</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>