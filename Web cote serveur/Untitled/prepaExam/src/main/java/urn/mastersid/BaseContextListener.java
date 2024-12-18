package urn.mastersid;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class BaseContextListener
 *
 */
public class BaseContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public BaseContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	String realPath = sce.getServletContext().getRealPath("WEB-INF/bookshelf.txt");
        try {
			BookshelfManager.initBooks(realPath);
		} catch (InvalidBookException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
