<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
</head>

<nav class="two">
	<ul>
		<li>
			<form action="controller" method="post">
				<input type="submit" value="Расписание" class="submit1">
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
				<input type="hidden" name="page" value="login"> <input
					type="hidden" name="command" value="commandNavBar"> <input
					type="submit" value="Войти" class="submit1">
			</form>
		</li>
	</ul>
</nav>

<table border="1" width="10%" cellpadding="5">
	<tr>
		<th>№ поезда</th>
		<th>Станция отправления</th>
		<th>Дата/Время отправления</th>
		<th>Станция прибытия</th>
		<th>Дата/Время прибытия</th>
		<th>Купе (свободно)</th>
		<th>Плацкарт (свободно)</th>
		<th>Общий (свободно)</th>
		<th>Стоимость (купе)</th>
		<th>Стоимость (плацкарт)</th>
		<th>Стоимость (общий)</th>
	</tr>
	<c:forEach var="route" items="${routes}">

		<tr>
			<td>${route.trainNumber}</td>
			<td>${route.stationName}</td>
			<td>${route.departureDateAndTime}</td>
			<td>${route.destinationStationName}</td>
			<td>${route.destinationDateAndTime}</td>
			<td>${route.coupe}</td>
			<td>${route.reservedSeat}</td>
			<td>${route.common}</td>
			<td>${route.coupePrice}</td>
			<td>${route.reservedSeatPrice}</td>
			<td>${route.commonPrice}</td>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="command" value="routeDetails"> <input
						type="hidden" name="trainNumber" value="${route.trainNumber}">
					<input type="hidden" name="departureStation"
						value="${route.stationName}"> <input type="hidden"
						name="destinationStation" value="${route.destinationStationName}">
					<input type="submit" value="Подробнее" class="submit2">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>