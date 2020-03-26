package ua.nure.kaplin.SummaryTask4.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.kaplin.SummaryTask4.Path;
import ua.nure.kaplin.SummaryTask4.DAO.mysql.DaoRoute;
import ua.nure.kaplin.SummaryTask4.db.entity.Route;
import ua.nure.kaplin.SummaryTask4.db.entity.Train;
import ua.nure.kaplin.SummaryTask4.exception.AppException;

public class CommandRoute extends Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, AppException {
	    String departureStation = request.getParameter("departureStation");
	    String arriveStation = request.getParameter("arrivalStation");
	    String message = "";
	    List<Route> routes = new ArrayList<Route>();
	    List<Route> routesBuf;
	    List<Train> trains = new ArrayList<Train>();
	    DaoRoute dao = new DaoRoute();
	    try {
	    	trains = dao.findTrainNumberByStationName(departureStation, arriveStation);
	    	
	    	for(Train train: trains) {
	    		routesBuf = new ArrayList<Route>(Route.setRouteDestinationDeparture(dao.findRoutePointByStationName(train.getTrainNunber()), departureStation, arriveStation));
	    		routes.addAll(routesBuf);
	    	}
	    	
			request.setAttribute("routes", routes);
		} catch (Exception e) {
			e.printStackTrace();
		}	    
	    if(routes.size() == 0) {
	    	message = "Поездов не найдено";
	    }
	    request.setAttribute("message", message);
		return Path.PAGE_MAIN;
	}

}
