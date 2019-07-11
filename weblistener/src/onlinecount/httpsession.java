package onlinecount;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class httpsession implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"online");
		Integer attribute = (Integer) session.getServletContext().getAttribute("count");
		attribute++;
		session.getServletContext().setAttribute("count", attribute);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"outline");
		Integer attribute = (Integer) session.getServletContext().getAttribute("count");
		attribute--;
		session.getServletContext().setAttribute("count", attribute);
	}

}
