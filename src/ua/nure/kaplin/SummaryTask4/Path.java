package ua.nure.kaplin.SummaryTask4;

/**
 * Path holder (jsp pages, controller commands).
 * 
 * @author D.Kolesnikov
 * 
 */
public final class Path {
	
	// pages
	public static final String PAGE_LOGIN = "/WEB-INF/view/login.jsp";
	public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
	public static final String PAGE_ADMIN_MENU = "/WEB-INF/view/admin.jsp";
	public static final String PAGE_REGISTRATION= "/WEB-INF/view/registration.jsp";
	public static final String PAGE_ROUTE_DETAILS= "/WEB-INF/view/routeDetails.jsp";
	public static final String PAGE_MAIN= "/WEB-INF/view/main_page.jsp";


	// commands
	public static final String COMMAND_LIST_ORDERS = "/controller?command=listOrders";
	public static final String COMMAND_LIST_MENU = "/controller?command=listMenu";

}