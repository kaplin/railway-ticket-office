package ua.nure.kaplin.SummaryTask4.DAO.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.nure.kaplin.SummaryTask4.db.DBManager;
import ua.nure.kaplin.SummaryTask4.db.entity.Route;
import ua.nure.kaplin.SummaryTask4.db.entity.Train;

public class DaoRoute {
	private static final String SQL_SELECT_ROUTE_BY_STATION_NAME = "SELECT train_number, arrive_datetime, depart_datetime, name, coupe, reserved_seat, common, coupe_price, reserved_seat_price, common_price\r\n"
			+ "FROM route_point\r\n" + "INNER JOIN train\r\n" + "ON train.id = route_point.train_id \r\n"
			+ "INNER JOIN train_station ON train_station.id = route_point.train_station_id WHERE train_number = ?";

	private static final String SQL_SELECT_TRAIN_BY_STATION_NAME = "SELECT train_number, count(1) as 'repeats'\r\n"
			+ "	FROM route_point\r\n" + "	INNER JOIN train\r\n" + "	ON train.id = route_point.train_id \r\n"
			+ "	INNER JOIN train_station ON train_station.id = route_point.train_station_id \r\n"
			+ "	WHERE name = ? OR name = ? GROUP BY train_number;";


	public List<Route> findRoutePointByStationName(int trainNumber) throws Exception {
		List<Route> routes = new ArrayList<Route>();
		DBManager db = DBManager.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = db.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(SQL_SELECT_ROUTE_BY_STATION_NAME);
			preparedStatement.setInt(1, trainNumber);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Route route = new Route();
				route.setTrainNumber(resultSet.getInt(1));
				route.setDestinationDateAndTime(resultSet.getString(2));
				route.setDepartureDateAndTime(resultSet.getString(3));
				route.setStationName(resultSet.getString(4));
				route.setCoupe(resultSet.getInt(5));
				route.setReservedSeat(resultSet.getInt(6));
				route.setCommon(resultSet.getInt(7));
				route.setCoupePrice(resultSet.getInt(8));
				route.setReservedSeatPrice(resultSet.getInt(9));
				route.setCommonPrice(resultSet.getInt(10));
				routes.add(route);
			}
		} catch (SQLException e) {
			throw new Exception("Can_not_select_route_point_by_name", e);
		} finally {
			db.close(connection, preparedStatement, resultSet);
		}
		return routes;
	}

	public List<Train> findTrainNumberByStationName(String departureStation, String arriveStation) throws Exception {
		List<Train> trains = new ArrayList<Train>();
		DBManager db = DBManager.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = db.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(SQL_SELECT_TRAIN_BY_STATION_NAME);
			preparedStatement.setString(1, departureStation);
			preparedStatement.setString(2, arriveStation);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if(resultSet.getInt(2) > 1) {
					Train train = new Train();
					train.setTrainNunber(resultSet.getInt(1));
					trains.add(train);
				}
			}
		} catch (SQLException e) {
			throw new Exception("Can_not_select_route_point_by_name", e);
		} finally {
			db.close(connection, preparedStatement, resultSet);
		}
		System.out.println(trains.size());
		return trains;
	}

}
