<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>

	<meta charset="UTF-8">
	<title>Маршрут</title>
	<link rel="stylesheet" type="text/css"
		href="resources/style/navbar.css" />
	<link rel="stylesheet" type="text/css" href="resources/style/style.css" />
</head>
<body>
	<nav class="two">
		<ul>
			<li>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="main_page"> <input
						type="hidden" name="command" value="commandNavBar"> <input
						type="submit" value="Расписание" class="submit1">
				</form>
			</li>
			<li>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="Airplane.jsp"> <input
						type="hidden" name="command" value="pageMapping"> <input
						type="submit" value="Контакты" class="submit1">
				</form>
			</li>
			<li style="float: right">
				<form action="controller" method="post">
					<input type="hidden" name="page" value="login.jsp"> <input
						type="hidden" name="command" value="pageMapping"> <input
						type="submit" value="Войти" class="submit1">
				</form>
			</li>
		</ul>
	</nav>

	<table border="1" width="10%" cellpadding="5">
				<tr>
					<th>№ поезда</th>
					<th>Пункт отправления</th>
					<th>Дата/Время прибытия</th>
					<th>Дата/Время отправления</th>
					<th>Пункт назначения</th>
				</tr>
				<c:forEach var="route" items="${routes}">

					<tr>
						<td>${route.trainNumber}</td>
						<td>${route.stationName}</td>
						<td>${route.destinationDateAndTime}</td>
						<td>${route.departureDateAndTime}</td>
						<td>${route.destinationStationName}</td>
						<td>
							<form action="controller" method="post">
								<input type="hidden" name="command" value="routeDetails">
								<input type="hidden" name="trainNumber" value="${route.trainNumber}">
								<input type="submit" value="Купить" class="submit2">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>

</body>
</html>