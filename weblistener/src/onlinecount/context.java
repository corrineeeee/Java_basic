package onlinecount;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class context implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("count", 0);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	
	
}
