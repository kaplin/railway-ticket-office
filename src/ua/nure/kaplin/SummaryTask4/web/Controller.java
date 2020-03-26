package ua.nure.kaplin.SummaryTask4.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.nure.kaplin.SummaryTask4.DAO.mysql.DaoTrainStation;
import ua.nure.kaplin.SummaryTask4.db.entity.TrainStation;
import ua.nure.kaplin.SummaryTask4.Path;
import ua.nure.kaplin.SummaryTask4.exception.AppException;
import ua.nure.kaplin.SummaryTask4.web.Controller;
import ua.nure.kaplin.SummaryTask4.web.command.Command;
import ua.nure.kaplin.SummaryTask4.web.command.CommandContainer;
import org.apache.log4j.Logger;

public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 2423353715955164816L;

	private static final Logger LOG = Logger.getLogger(Controller.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * Main method of this controller.
	 */
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		LOG.debug("Controller starts");

		// extract command name from the request
		String commandName = request.getParameter("command");
		LOG.trace("Request parameter: command --> " + commandName);

		// obtain command object by its name
		Command command = CommandContainer.get(commandName);
		LOG.trace("Obtained command --> " + command);

		// execute command and get forward address
		String forward = Path.PAGE_ERROR_PAGE;
		try {
			forward = command.execute(request, response);
		} catch (AppException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
		}
		LOG.trace("Forward address --> " + forward);

		LOG.debug("Controller finished, now go to forward address --> " + forward);
		
		// go to forward
		request.getRequestDispatcher(forward).forward(request, response);
	}

}

/*
 * @WebServlet("/adding") public class Controller extends HttpServlet{
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { boolean isAdded; String
 * message = "FAILED"; String stationName = request.getParameter("name"); String
 * nameForUpdate = request.getParameter("nameForUpdate"); String action =
 * request.getParameter("action"); System.out.println(nameForUpdate +
 * " ----awfawffawwe"); System.out.println(action + " ----awfawffawwe");
 * DaoTrainStation dao = new DaoTrainStation(); TrainStation station = new
 * TrainStation(); if("ADD".equals(action)) {
 * station.setStationName(stationName); try { dao.insertStation(station);
 * message = "SUCCESS"; } catch (Exception e) { message = "FAILED";
 * e.printStackTrace(); } } else if ("UPDATE".equals(action) &&
 * !nameForUpdate.isEmpty()) { station.setStationName(stationName);
 * 
 * TrainStation stationForUpdate = new TrainStation();
 * stationForUpdate.setStationName(nameForUpdate); try {
 * dao.updateTrainStation(station, stationForUpdate); message = "SUCCESS"; }
 * catch (Exception e) { message = "FAILED"; e.printStackTrace(); } }
 * request.setAttribute("isAdded", message);
 * request.getRequestDispatcher("admin.jsp").forward(request, response); }
 * 
 * 
 * }
 */
