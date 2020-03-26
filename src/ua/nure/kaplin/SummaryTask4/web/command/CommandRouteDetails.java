package ua.nure.kaplin.SummaryTask4.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kaplin.SummaryTask4.Path;
import ua.nure.kaplin.SummaryTask4.DAO.mysql.DaoRoute;
import ua.nure.kaplin.SummaryTask4.db.entity.Route;
import ua.nure.kaplin.SummaryTask4.db.entity.User;
import ua.nure.kaplin.SummaryTask4.exception.AppException;
import ua.nure.kaplin.SummaryTask4.db.Role;


public class CommandRouteDetails extends Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, AppException {
		
		HttpSession session = request.getSession();
		
		Role userRole = (Role) session.getAttribute("userRole");
		
		String forward = Path.PAGE_ERROR_PAGE;

		if (userRole == Role.ADMIN) {
			forward = Path.PAGE_ADMIN_MENU;
		}

		if (userRole == Role.CLIENT) {
			forward = Path.PAGE_ROUTE_DETAILS;
		}
		
		String trainNumber = request.getParameter("trainNumber");
		String departureStation = request.getParameter("departureStation");
		String destinationStation = request.getParameter("destinationStation");
		System.out.println("Train number: " + trainNumber);
		List<Route> routes = new ArrayList<Route>();
		DaoRoute dao = new DaoRoute();
		 
		 try {
			 routes =Route.setRouteBetweenRoutePoints(dao.findRoutePointByStationName(Integer.parseInt(trainNumber)), departureStation, destinationStation);
			 request.setAttribute("routes", routes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return forward;
	}

}
